/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacionDAO;

import dominio.Estado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Municipio;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class EstadoDAO implements Serializable {

    public EstadoDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estado estado) {
        if (estado.getMunicipos() == null) {
            estado.setMunicipos(new ArrayList<Municipio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Municipio> attachedMunicipos = new ArrayList<Municipio>();
            for (Municipio municiposMunicipioToAttach : estado.getMunicipos()) {
                municiposMunicipioToAttach = em.getReference(municiposMunicipioToAttach.getClass(), municiposMunicipioToAttach.getId());
                attachedMunicipos.add(municiposMunicipioToAttach);
            }
            estado.setMunicipos(attachedMunicipos);
            em.persist(estado);
            for (Municipio municiposMunicipio : estado.getMunicipos()) {
                Estado oldEstadoOfMuniciposMunicipio = municiposMunicipio.getEstado();
                municiposMunicipio.setEstado(estado);
                municiposMunicipio = em.merge(municiposMunicipio);
                if (oldEstadoOfMuniciposMunicipio != null) {
                    oldEstadoOfMuniciposMunicipio.getMunicipos().remove(municiposMunicipio);
                    oldEstadoOfMuniciposMunicipio = em.merge(oldEstadoOfMuniciposMunicipio);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estado estado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estado persistentEstado = em.find(Estado.class, estado.getId());
            List<Municipio> municiposOld = persistentEstado.getMunicipos();
            List<Municipio> municiposNew = estado.getMunicipos();
            List<Municipio> attachedMuniciposNew = new ArrayList<Municipio>();
            for (Municipio municiposNewMunicipioToAttach : municiposNew) {
                municiposNewMunicipioToAttach = em.getReference(municiposNewMunicipioToAttach.getClass(), municiposNewMunicipioToAttach.getId());
                attachedMuniciposNew.add(municiposNewMunicipioToAttach);
            }
            municiposNew = attachedMuniciposNew;
            estado.setMunicipos(municiposNew);
            estado = em.merge(estado);
            for (Municipio municiposOldMunicipio : municiposOld) {
                if (!municiposNew.contains(municiposOldMunicipio)) {
                    municiposOldMunicipio.setEstado(null);
                    municiposOldMunicipio = em.merge(municiposOldMunicipio);
                }
            }
            for (Municipio municiposNewMunicipio : municiposNew) {
                if (!municiposOld.contains(municiposNewMunicipio)) {
                    Estado oldEstadoOfMuniciposNewMunicipio = municiposNewMunicipio.getEstado();
                    municiposNewMunicipio.setEstado(estado);
                    municiposNewMunicipio = em.merge(municiposNewMunicipio);
                    if (oldEstadoOfMuniciposNewMunicipio != null && !oldEstadoOfMuniciposNewMunicipio.equals(estado)) {
                        oldEstadoOfMuniciposNewMunicipio.getMunicipos().remove(municiposNewMunicipio);
                        oldEstadoOfMuniciposNewMunicipio = em.merge(oldEstadoOfMuniciposNewMunicipio);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estado.getId();
                if (findEstado(id) == null) {
                    throw new NonexistentEntityException("The estado with id " + id + " no longer exists.");
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
            Estado estado;
            try {
                estado = em.getReference(Estado.class, id);
                estado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estado with id " + id + " no longer exists.", enfe);
            }
            List<Municipio> municipos = estado.getMunicipos();
            for (Municipio municiposMunicipio : municipos) {
                municiposMunicipio.setEstado(null);
                municiposMunicipio = em.merge(municiposMunicipio);
            }
            em.remove(estado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estado> findEstadoEntities() {
        return findEstadoEntities(true, -1, -1);
    }

    public List<Estado> findEstadoEntities(int maxResults, int firstResult) {
        return findEstadoEntities(false, maxResults, firstResult);
    }

    private List<Estado> findEstadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estado.class));
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

    public Estado findEstado(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estado> rt = cq.from(Estado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
