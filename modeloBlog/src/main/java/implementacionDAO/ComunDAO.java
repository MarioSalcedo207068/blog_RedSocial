/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionDAO;

import dominio.Comun;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Usuario;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IComunDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class ComunDAO implements Serializable, IComunDAO {

    public ComunDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comun comun) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario = comun.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                comun.setUsuario(usuario);
            }
            em.persist(comun);
            if (usuario != null) {
                usuario.getPublicacionesComunes().add(comun);
                usuario = em.merge(usuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comun comun) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comun persistentComun = em.find(Comun.class, comun.getId());
            Usuario usuarioOld = persistentComun.getUsuario();
            Usuario usuarioNew = comun.getUsuario();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId());
                comun.setUsuario(usuarioNew);
            }
            comun = em.merge(comun);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getPublicacionesComunes().remove(comun);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getPublicacionesComunes().add(comun);
                usuarioNew = em.merge(usuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = comun.getId();
                if (findComun(id) == null) {
                    throw new NonexistentEntityException("The comun with id " + id + " no longer exists.");
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
            Comun comun;
            try {
                comun = em.getReference(Comun.class, id);
                comun.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comun with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario = comun.getUsuario();
            if (usuario != null) {
                usuario.getPublicacionesComunes().remove(comun);
                usuario = em.merge(usuario);
            }
            em.remove(comun);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comun> findComunEntities() {
        return findComunEntities(true, -1, -1);
    }

    public List<Comun> findComunEntities(int maxResults, int firstResult) {
        return findComunEntities(false, maxResults, firstResult);
    }

    private List<Comun> findComunEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comun.class));
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

    public Comun findComun(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comun.class, id);
        } finally {
            em.close();
        }
    }

    public int getComunCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comun> rt = cq.from(Comun.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
