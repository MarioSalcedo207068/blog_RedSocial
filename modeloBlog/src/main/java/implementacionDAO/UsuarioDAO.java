/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionDAO;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Municipio;
import dominio.Comun;
import dominio.Usuario;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class UsuarioDAO implements Serializable, IUsuarioDAO {

    public UsuarioDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getPublicacionesComunes() == null) {
            usuario.setPublicacionesComunes(new ArrayList<Comun>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Municipio municipio = usuario.getMunicipio();
            if (municipio != null) {
                municipio = em.getReference(municipio.getClass(), municipio.getId());
                usuario.setMunicipio(municipio);
            }
            List<Comun> attachedPublicacionesComunes = new ArrayList<Comun>();
            for (Comun publicacionesComunesComunToAttach : usuario.getPublicacionesComunes()) {
                publicacionesComunesComunToAttach = em.getReference(publicacionesComunesComunToAttach.getClass(), publicacionesComunesComunToAttach.getId());
                attachedPublicacionesComunes.add(publicacionesComunesComunToAttach);
            }
            usuario.setPublicacionesComunes(attachedPublicacionesComunes);
            em.persist(usuario);
            if (municipio != null) {
                municipio.getUsuarios().add(usuario);
                municipio = em.merge(municipio);
            }
            for (Comun publicacionesComunesComun : usuario.getPublicacionesComunes()) {
                Usuario oldUsuarioOfPublicacionesComunesComun = publicacionesComunesComun.getUsuario();
                publicacionesComunesComun.setUsuario(usuario);
                publicacionesComunesComun = em.merge(publicacionesComunesComun);
                if (oldUsuarioOfPublicacionesComunesComun != null) {
                    oldUsuarioOfPublicacionesComunesComun.getPublicacionesComunes().remove(publicacionesComunesComun);
                    oldUsuarioOfPublicacionesComunesComun = em.merge(oldUsuarioOfPublicacionesComunesComun);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Municipio municipioOld = persistentUsuario.getMunicipio();
            Municipio municipioNew = usuario.getMunicipio();
            List<Comun> publicacionesComunesOld = persistentUsuario.getPublicacionesComunes();
            List<Comun> publicacionesComunesNew = usuario.getPublicacionesComunes();
            if (municipioNew != null) {
                municipioNew = em.getReference(municipioNew.getClass(), municipioNew.getId());
                usuario.setMunicipio(municipioNew);
            }
            List<Comun> attachedPublicacionesComunesNew = new ArrayList<Comun>();
            for (Comun publicacionesComunesNewComunToAttach : publicacionesComunesNew) {
                publicacionesComunesNewComunToAttach = em.getReference(publicacionesComunesNewComunToAttach.getClass(), publicacionesComunesNewComunToAttach.getId());
                attachedPublicacionesComunesNew.add(publicacionesComunesNewComunToAttach);
            }
            publicacionesComunesNew = attachedPublicacionesComunesNew;
            usuario.setPublicacionesComunes(publicacionesComunesNew);
            usuario = em.merge(usuario);
            if (municipioOld != null && !municipioOld.equals(municipioNew)) {
                municipioOld.getUsuarios().remove(usuario);
                municipioOld = em.merge(municipioOld);
            }
            if (municipioNew != null && !municipioNew.equals(municipioOld)) {
                municipioNew.getUsuarios().add(usuario);
                municipioNew = em.merge(municipioNew);
            }
            for (Comun publicacionesComunesOldComun : publicacionesComunesOld) {
                if (!publicacionesComunesNew.contains(publicacionesComunesOldComun)) {
                    publicacionesComunesOldComun.setUsuario(null);
                    publicacionesComunesOldComun = em.merge(publicacionesComunesOldComun);
                }
            }
            for (Comun publicacionesComunesNewComun : publicacionesComunesNew) {
                if (!publicacionesComunesOld.contains(publicacionesComunesNewComun)) {
                    Usuario oldUsuarioOfPublicacionesComunesNewComun = publicacionesComunesNewComun.getUsuario();
                    publicacionesComunesNewComun.setUsuario(usuario);
                    publicacionesComunesNewComun = em.merge(publicacionesComunesNewComun);
                    if (oldUsuarioOfPublicacionesComunesNewComun != null && !oldUsuarioOfPublicacionesComunesNewComun.equals(usuario)) {
                        oldUsuarioOfPublicacionesComunesNewComun.getPublicacionesComunes().remove(publicacionesComunesNewComun);
                        oldUsuarioOfPublicacionesComunesNewComun = em.merge(oldUsuarioOfPublicacionesComunesNewComun);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Municipio municipio = usuario.getMunicipio();
            if (municipio != null) {
                municipio.getUsuarios().remove(usuario);
                municipio = em.merge(municipio);
            }
            List<Comun> publicacionesComunes = usuario.getPublicacionesComunes();
            for (Comun publicacionesComunesComun : publicacionesComunes) {
                publicacionesComunesComun.setUsuario(null);
                publicacionesComunesComun = em.merge(publicacionesComunesComun);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
