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
import dominio.Comentario;
import java.util.ArrayList;
import java.util.List;
import dominio.Comun;
import dominio.Normal;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.INormalDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class NormalDAO implements Serializable, INormalDAO {

    public NormalDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Normal create(Normal normal) {

        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(normal);
            em.getTransaction().commit();
            em.refresh(normal);
            return normal;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Normal normal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Normal persistentNormal = em.find(Normal.class, normal.getId());
            Municipio municipioOld = persistentNormal.getMunicipio();
            Municipio municipioNew = normal.getMunicipio();
            List<Comentario> comenatariosOld = persistentNormal.getComenatarios();
            List<Comentario> comenatariosNew = normal.getComenatarios();
            List<Comun> publicacionesComunesOld = persistentNormal.getPublicacionesComunes();
            List<Comun> publicacionesComunesNew = normal.getPublicacionesComunes();
            if (municipioNew != null) {
                municipioNew = em.getReference(municipioNew.getClass(), municipioNew.getId());
                normal.setMunicipio(municipioNew);
            }
            List<Comentario> attachedComenatariosNew = new ArrayList<Comentario>();
            for (Comentario comenatariosNewComentarioToAttach : comenatariosNew) {
                comenatariosNewComentarioToAttach = em.getReference(comenatariosNewComentarioToAttach.getClass(), comenatariosNewComentarioToAttach.getId());
                attachedComenatariosNew.add(comenatariosNewComentarioToAttach);
            }
            comenatariosNew = attachedComenatariosNew;
            normal.setComenatarios(comenatariosNew);
            List<Comun> attachedPublicacionesComunesNew = new ArrayList<Comun>();
            for (Comun publicacionesComunesNewComunToAttach : publicacionesComunesNew) {
                publicacionesComunesNewComunToAttach = em.getReference(publicacionesComunesNewComunToAttach.getClass(), publicacionesComunesNewComunToAttach.getId());
                attachedPublicacionesComunesNew.add(publicacionesComunesNewComunToAttach);
            }
            publicacionesComunesNew = attachedPublicacionesComunesNew;
            normal.setPublicacionesComunes(publicacionesComunesNew);
            normal = em.merge(normal);
            if (municipioOld != null && !municipioOld.equals(municipioNew)) {
                municipioOld.getUsuarios().remove(normal);
                municipioOld = em.merge(municipioOld);
            }
            if (municipioNew != null && !municipioNew.equals(municipioOld)) {
                municipioNew.getUsuarios().add(normal);
                municipioNew = em.merge(municipioNew);
            }
            for (Comentario comenatariosOldComentario : comenatariosOld) {
                if (!comenatariosNew.contains(comenatariosOldComentario)) {
                    comenatariosOldComentario.setUsuarioNormal(null);
                    comenatariosOldComentario = em.merge(comenatariosOldComentario);
                }
            }
            for (Comentario comenatariosNewComentario : comenatariosNew) {
                if (!comenatariosOld.contains(comenatariosNewComentario)) {
                    Normal oldUsuarioNormalOfComenatariosNewComentario = comenatariosNewComentario.getUsuarioNormal();
                    comenatariosNewComentario.setUsuarioNormal(normal);
                    comenatariosNewComentario = em.merge(comenatariosNewComentario);
                    if (oldUsuarioNormalOfComenatariosNewComentario != null && !oldUsuarioNormalOfComenatariosNewComentario.equals(normal)) {
                        oldUsuarioNormalOfComenatariosNewComentario.getComenatarios().remove(comenatariosNewComentario);
                        oldUsuarioNormalOfComenatariosNewComentario = em.merge(oldUsuarioNormalOfComenatariosNewComentario);
                    }
                }
            }
            for (Comun publicacionesComunesOldComun : publicacionesComunesOld) {
                if (!publicacionesComunesNew.contains(publicacionesComunesOldComun)) {
                    publicacionesComunesOldComun.setUsuarioNormal(null);
                    publicacionesComunesOldComun = em.merge(publicacionesComunesOldComun);
                }
            }
            for (Comun publicacionesComunesNewComun : publicacionesComunesNew) {
                if (!publicacionesComunesOld.contains(publicacionesComunesNewComun)) {
                    Normal oldUsuarioNormalOfPublicacionesComunesNewComun = publicacionesComunesNewComun.getUsuarioNormal();
                    publicacionesComunesNewComun.setUsuarioNormal(normal);
                    publicacionesComunesNewComun = em.merge(publicacionesComunesNewComun);
                    if (oldUsuarioNormalOfPublicacionesComunesNewComun != null && !oldUsuarioNormalOfPublicacionesComunesNewComun.equals(normal)) {
                        oldUsuarioNormalOfPublicacionesComunesNewComun.getPublicacionesComunes().remove(publicacionesComunesNewComun);
                        oldUsuarioNormalOfPublicacionesComunesNewComun = em.merge(oldUsuarioNormalOfPublicacionesComunesNewComun);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = normal.getId();
                if (findNormal(id) == null) {
                    throw new NonexistentEntityException("The normal with id " + id + " no longer exists.");
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
            Normal normal;
            try {
                normal = em.getReference(Normal.class, id);
                normal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The normal with id " + id + " no longer exists.", enfe);
            }
            Municipio municipio = normal.getMunicipio();
            if (municipio != null) {
                municipio.getUsuarios().remove(normal);
                municipio = em.merge(municipio);
            }
            List<Comentario> comenatarios = normal.getComenatarios();
            for (Comentario comenatariosComentario : comenatarios) {
                comenatariosComentario.setUsuarioNormal(null);
                comenatariosComentario = em.merge(comenatariosComentario);
            }
            List<Comun> publicacionesComunes = normal.getPublicacionesComunes();
            for (Comun publicacionesComunesComun : publicacionesComunes) {
                publicacionesComunesComun.setUsuarioNormal(null);
                publicacionesComunesComun = em.merge(publicacionesComunesComun);
            }
            em.remove(normal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Normal> findNormalEntities() {
        return findNormalEntities(true, -1, -1);
    }

    public List<Normal> findNormalEntities(int maxResults, int firstResult) {
        return findNormalEntities(false, maxResults, firstResult);
    }

    private List<Normal> findNormalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Normal.class));
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

    public Normal findNormal(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Normal.class, id);
        } finally {
            em.close();
        }
    }

    public int getNormalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Normal> rt = cq.from(Normal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
