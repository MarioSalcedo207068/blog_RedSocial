/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionDAO;

import dominio.Comun;
import dominio.Publicacion;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IPublicacionDAO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author HP
 */
public class PublicacionDAO implements Serializable, IPublicacionDAO {

    public PublicacionDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Publicacion publicacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(publicacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Publicacion publicacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            publicacion = em.merge(publicacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = publicacion.getId();
                if (findPublicacion(id) == null) {
                    throw new NonexistentEntityException("The publicacion with id " + id + " no longer exists.");
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
                comun = em.find(Comun.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comun with id " + id + " no longer exists.", enfe);
            }
            if (comun != null) {
                em.remove(comun);
            }
            //comentario = em.merge(comentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Publicacion> findPublicacionEntities() {
        return findPublicacionEntities(true, -1, -1);
    }

    public List<Publicacion> findPublicacionEntities(int maxResults, int firstResult) {
        return findPublicacionEntities(false, maxResults, firstResult);
    }

    private List<Publicacion> findPublicacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Publicacion.class));
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

    public Publicacion findPublicacion(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Publicacion.class, id);
        } finally {
            em.close();
        }
    }



}
