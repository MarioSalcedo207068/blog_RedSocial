/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionDAO;

import dominio.Administrador;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Municipio;
import dominio.Comun;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class AdministradorDAO implements Serializable {

    public AdministradorDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrador administrador) {
        if (administrador.getPublicacionesComunes() == null) {
            administrador.setPublicacionesComunes(new ArrayList<Comun>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Municipio municipio = administrador.getMunicipio();
            if (municipio != null) {
                municipio = em.getReference(municipio.getClass(), municipio.getId());
                administrador.setMunicipio(municipio);
            }
            List<Comun> attachedPublicacionesComunes = new ArrayList<Comun>();
            for (Comun publicacionesComunesComunToAttach : administrador.getPublicacionesComunes()) {
                publicacionesComunesComunToAttach = em.getReference(publicacionesComunesComunToAttach.getClass(), publicacionesComunesComunToAttach.getId());
                attachedPublicacionesComunes.add(publicacionesComunesComunToAttach);
            }
            administrador.setPublicacionesComunes(attachedPublicacionesComunes);
            em.persist(administrador);
            if (municipio != null) {
                municipio.getUsuarios().add(administrador);
                municipio = em.merge(municipio);
            }
            for (Comun publicacionesComunesComun : administrador.getPublicacionesComunes()) {
                dominio.Usuario oldUsuarioOfPublicacionesComunesComun = publicacionesComunesComun.getUsuario();
                publicacionesComunesComun.setUsuario(administrador);
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

    public void edit(Administrador administrador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador persistentAdministrador = em.find(Administrador.class, administrador.getId());
            Municipio municipioOld = persistentAdministrador.getMunicipio();
            Municipio municipioNew = administrador.getMunicipio();
            List<Comun> publicacionesComunesOld = persistentAdministrador.getPublicacionesComunes();
            List<Comun> publicacionesComunesNew = administrador.getPublicacionesComunes();
            if (municipioNew != null) {
                municipioNew = em.getReference(municipioNew.getClass(), municipioNew.getId());
                administrador.setMunicipio(municipioNew);
            }
            List<Comun> attachedPublicacionesComunesNew = new ArrayList<Comun>();
            for (Comun publicacionesComunesNewComunToAttach : publicacionesComunesNew) {
                publicacionesComunesNewComunToAttach = em.getReference(publicacionesComunesNewComunToAttach.getClass(), publicacionesComunesNewComunToAttach.getId());
                attachedPublicacionesComunesNew.add(publicacionesComunesNewComunToAttach);
            }
            publicacionesComunesNew = attachedPublicacionesComunesNew;
            administrador.setPublicacionesComunes(publicacionesComunesNew);
            administrador = em.merge(administrador);
            if (municipioOld != null && !municipioOld.equals(municipioNew)) {
                municipioOld.getUsuarios().remove(administrador);
                municipioOld = em.merge(municipioOld);
            }
            if (municipioNew != null && !municipioNew.equals(municipioOld)) {
                municipioNew.getUsuarios().add(administrador);
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
                    Administrador oldUsuarioOfPublicacionesComunesNewComun = (Administrador) publicacionesComunesNewComun.getUsuario();
                    publicacionesComunesNewComun.setUsuario(administrador);
                    publicacionesComunesNewComun = em.merge(publicacionesComunesNewComun);
                    if (oldUsuarioOfPublicacionesComunesNewComun != null && !oldUsuarioOfPublicacionesComunesNewComun.equals(administrador)) {
                        oldUsuarioOfPublicacionesComunesNewComun.getPublicacionesComunes().remove(publicacionesComunesNewComun);
                        oldUsuarioOfPublicacionesComunesNewComun = em.merge(oldUsuarioOfPublicacionesComunesNewComun);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = administrador.getId();
                if (findAdministrador(id) == null) {
                    throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.");
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
            Administrador administrador;
            try {
                administrador = em.getReference(Administrador.class, id);
                administrador.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The administrador with id " + id + " no longer exists.", enfe);
            }
            Municipio municipio = administrador.getMunicipio();
            if (municipio != null) {
                municipio.getUsuarios().remove(administrador);
                municipio = em.merge(municipio);
            }
            List<Comun> publicacionesComunes = administrador.getPublicacionesComunes();
            for (Comun publicacionesComunesComun : publicacionesComunes) {
                publicacionesComunesComun.setUsuario(null);
                publicacionesComunesComun = em.merge(publicacionesComunesComun);
            }
            em.remove(administrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Administrador> findAdministradorEntities() {
        return findAdministradorEntities(true, -1, -1);
    }

    public List<Administrador> findAdministradorEntities(int maxResults, int firstResult) {
        return findAdministradorEntities(false, maxResults, firstResult);
    }

    private List<Administrador> findAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrador.class));
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

    public Administrador findAdministrador(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrador.class, id);
        } finally {
            em.close();
        }
    }

}
