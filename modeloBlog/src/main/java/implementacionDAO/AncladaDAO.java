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
import dominio.Administrador;
import dominio.Anclada;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class AncladaDAO implements Serializable {

    public AncladaDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Anclada anclada) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador admin = anclada.getAdmin();
            if (admin != null) {
                admin = em.getReference(admin.getClass(), admin.getId());
                anclada.setAdmin(admin);
            }
            em.persist(anclada);
            if (admin != null) {
                admin.getPublicacionesAncladas().add(anclada);
                admin = em.merge(admin);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Anclada anclada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Anclada persistentAnclada = em.find(Anclada.class, anclada.getId());
            Administrador adminOld = persistentAnclada.getAdmin();
            Administrador adminNew = anclada.getAdmin();
            if (adminNew != null) {
                adminNew = em.getReference(adminNew.getClass(), adminNew.getId());
                anclada.setAdmin(adminNew);
            }
            anclada = em.merge(anclada);
            if (adminOld != null && !adminOld.equals(adminNew)) {
                adminOld.getPublicacionesAncladas().remove(anclada);
                adminOld = em.merge(adminOld);
            }
            if (adminNew != null && !adminNew.equals(adminOld)) {
                adminNew.getPublicacionesAncladas().add(anclada);
                adminNew = em.merge(adminNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = anclada.getId();
                if (findAnclada(id) == null) {
                    throw new NonexistentEntityException("The anclada with id " + id + " no longer exists.");
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
            Anclada anclada;
            try {
                anclada = em.getReference(Anclada.class, id);
                anclada.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The anclada with id " + id + " no longer exists.", enfe);
            }
            Administrador admin = anclada.getAdmin();
            if (admin != null) {
                admin.getPublicacionesAncladas().remove(anclada);
                admin = em.merge(admin);
            }
            em.remove(anclada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Anclada> findAncladaEntities() {
        return findAncladaEntities(true, -1, -1);
    }

    public List<Anclada> findAncladaEntities(int maxResults, int firstResult) {
        return findAncladaEntities(false, maxResults, firstResult);
    }

    private List<Anclada> findAncladaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Anclada.class));
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

    public Anclada findAnclada(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Anclada.class, id);
        } finally {
            em.close();
        }
    }

    public int getAncladaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Anclada> rt = cq.from(Anclada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
