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
import dominio.Estado;
import dominio.Municipio;
import dominio.Usuario;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IComunDAO;
import interfacesDAO.IMunicipioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class MunicipioDAO implements Serializable, IMunicipioDAO {

    public MunicipioDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Municipio municipio) {
        if (municipio.getUsuarios() == null) {
            municipio.setUsuarios(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estado estado = municipio.getEstado();
            if (estado != null) {
                estado = em.getReference(estado.getClass(), estado.getId());
                municipio.setEstado(estado);
            }
            List<Usuario> attachedUsuarios = new ArrayList<Usuario>();
            for (Usuario usuariosUsuarioToAttach : municipio.getUsuarios()) {
                usuariosUsuarioToAttach = em.getReference(usuariosUsuarioToAttach.getClass(), usuariosUsuarioToAttach.getId());
                attachedUsuarios.add(usuariosUsuarioToAttach);
            }
            municipio.setUsuarios(attachedUsuarios);
            em.persist(municipio);
            if (estado != null) {
                estado.getMunicipos().add(municipio);
                estado = em.merge(estado);
            }
            for (Usuario usuariosUsuario : municipio.getUsuarios()) {
                Municipio oldMunicipioOfUsuariosUsuario = usuariosUsuario.getMunicipio();
                usuariosUsuario.setMunicipio(municipio);
                usuariosUsuario = em.merge(usuariosUsuario);
                if (oldMunicipioOfUsuariosUsuario != null) {
                    oldMunicipioOfUsuariosUsuario.getUsuarios().remove(usuariosUsuario);
                    oldMunicipioOfUsuariosUsuario = em.merge(oldMunicipioOfUsuariosUsuario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Municipio municipio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Municipio persistentMunicipio = em.find(Municipio.class, municipio.getId());
            Estado estadoOld = persistentMunicipio.getEstado();
            Estado estadoNew = municipio.getEstado();
            List<Usuario> usuariosOld = persistentMunicipio.getUsuarios();
            List<Usuario> usuariosNew = municipio.getUsuarios();
            if (estadoNew != null) {
                estadoNew = em.getReference(estadoNew.getClass(), estadoNew.getId());
                municipio.setEstado(estadoNew);
            }
            List<Usuario> attachedUsuariosNew = new ArrayList<Usuario>();
            for (Usuario usuariosNewUsuarioToAttach : usuariosNew) {
                usuariosNewUsuarioToAttach = em.getReference(usuariosNewUsuarioToAttach.getClass(), usuariosNewUsuarioToAttach.getId());
                attachedUsuariosNew.add(usuariosNewUsuarioToAttach);
            }
            usuariosNew = attachedUsuariosNew;
            municipio.setUsuarios(usuariosNew);
            municipio = em.merge(municipio);
            if (estadoOld != null && !estadoOld.equals(estadoNew)) {
                estadoOld.getMunicipos().remove(municipio);
                estadoOld = em.merge(estadoOld);
            }
            if (estadoNew != null && !estadoNew.equals(estadoOld)) {
                estadoNew.getMunicipos().add(municipio);
                estadoNew = em.merge(estadoNew);
            }
            for (Usuario usuariosOldUsuario : usuariosOld) {
                if (!usuariosNew.contains(usuariosOldUsuario)) {
                    usuariosOldUsuario.setMunicipio(null);
                    usuariosOldUsuario = em.merge(usuariosOldUsuario);
                }
            }
            for (Usuario usuariosNewUsuario : usuariosNew) {
                if (!usuariosOld.contains(usuariosNewUsuario)) {
                    Municipio oldMunicipioOfUsuariosNewUsuario = usuariosNewUsuario.getMunicipio();
                    usuariosNewUsuario.setMunicipio(municipio);
                    usuariosNewUsuario = em.merge(usuariosNewUsuario);
                    if (oldMunicipioOfUsuariosNewUsuario != null && !oldMunicipioOfUsuariosNewUsuario.equals(municipio)) {
                        oldMunicipioOfUsuariosNewUsuario.getUsuarios().remove(usuariosNewUsuario);
                        oldMunicipioOfUsuariosNewUsuario = em.merge(oldMunicipioOfUsuariosNewUsuario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = municipio.getId();
                if (findMunicipio(id) == null) {
                    throw new NonexistentEntityException("The municipio with id " + id + " no longer exists.");
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
            Municipio municipio;
            try {
                municipio = em.getReference(Municipio.class, id);
                municipio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The municipio with id " + id + " no longer exists.", enfe);
            }
            Estado estado = municipio.getEstado();
            if (estado != null) {
                estado.getMunicipos().remove(municipio);
                estado = em.merge(estado);
            }
            List<Usuario> usuarios = municipio.getUsuarios();
            for (Usuario usuariosUsuario : usuarios) {
                usuariosUsuario.setMunicipio(null);
                usuariosUsuario = em.merge(usuariosUsuario);
            }
            em.remove(municipio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Municipio> findMunicipioEntities() {
        return findMunicipioEntities(true, -1, -1);
    }

    public List<Municipio> findMunicipioEntities(int maxResults, int firstResult) {
        return findMunicipioEntities(false, maxResults, firstResult);
    }

    private List<Municipio> findMunicipioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Municipio.class));
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

    public Municipio findMunicipio(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Municipio.class, id);
        } finally {
            em.close();
        }
    }

    public int getMunicipioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Municipio> rt = cq.from(Municipio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
