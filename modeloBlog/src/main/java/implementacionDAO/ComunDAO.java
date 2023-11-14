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
import dominio.Normal;
import dominio.Comentario;
import dominio.Comun;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IComunDAO;
import java.util.ArrayList;
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

    public Comun create(Comun comun) {
        if (comun.getComentarios() == null) {
            comun.setComentarios(new ArrayList<Comentario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comun);
            em.getTransaction().commit();
            return comun;
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
            Normal usuarioNormalOld = persistentComun.getUsuarioNormal();
            Normal usuarioNormalNew = comun.getUsuarioNormal();
            List<Comentario> comentariosOld = persistentComun.getComentarios();
            List<Comentario> comentariosNew = comun.getComentarios();
            if (usuarioNormalNew != null) {
                usuarioNormalNew = em.getReference(usuarioNormalNew.getClass(), usuarioNormalNew.getId());
                comun.setUsuarioNormal(usuarioNormalNew);
            }
            List<Comentario> attachedComentariosNew = new ArrayList<Comentario>();
            for (Comentario comentariosNewComentarioToAttach : comentariosNew) {
                comentariosNewComentarioToAttach = em.getReference(comentariosNewComentarioToAttach.getClass(), comentariosNewComentarioToAttach.getId());
                attachedComentariosNew.add(comentariosNewComentarioToAttach);
            }
            comentariosNew = attachedComentariosNew;
            comun.setComentarios(comentariosNew);
            comun = em.merge(comun);
            if (usuarioNormalOld != null && !usuarioNormalOld.equals(usuarioNormalNew)) {
                usuarioNormalOld.getPublicacionesComunes().remove(comun);
                usuarioNormalOld = em.merge(usuarioNormalOld);
            }
            if (usuarioNormalNew != null && !usuarioNormalNew.equals(usuarioNormalOld)) {
                usuarioNormalNew.getPublicacionesComunes().add(comun);
                usuarioNormalNew = em.merge(usuarioNormalNew);
            }
            for (Comentario comentariosOldComentario : comentariosOld) {
                if (!comentariosNew.contains(comentariosOldComentario)) {
                    comentariosOldComentario.setPublicacionComun(null);
                    comentariosOldComentario = em.merge(comentariosOldComentario);
                }
            }
            for (Comentario comentariosNewComentario : comentariosNew) {
                if (!comentariosOld.contains(comentariosNewComentario)) {
                    Comun oldPublicacionComunOfComentariosNewComentario = comentariosNewComentario.getPublicacionComun();
                    comentariosNewComentario.setPublicacionComun(comun);
                    comentariosNewComentario = em.merge(comentariosNewComentario);
                    if (oldPublicacionComunOfComentariosNewComentario != null && !oldPublicacionComunOfComentariosNewComentario.equals(comun)) {
                        oldPublicacionComunOfComentariosNewComentario.getComentarios().remove(comentariosNewComentario);
                        oldPublicacionComunOfComentariosNewComentario = em.merge(oldPublicacionComunOfComentariosNewComentario);
                    }
                }
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
