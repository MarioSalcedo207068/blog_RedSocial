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
import dominio.Comun;
import dominio.Comentario;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author HP
 */
public class ComentarioDAO implements Serializable {

    public ComentarioDAO(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comentario comentario) {
        if (comentario.getComentarios() == null) {
            comentario.setComentarios(new ArrayList<Comentario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Normal usuarioNormal = comentario.getUsuarioNormal();
            if (usuarioNormal != null) {
                usuarioNormal = em.getReference(usuarioNormal.getClass(), usuarioNormal.getId());
                comentario.setUsuarioNormal(usuarioNormal);
            }
            Comun publicacionComun = comentario.getPublicacionComun();
            if (publicacionComun != null) {
                publicacionComun = em.getReference(publicacionComun.getClass(), publicacionComun.getId());
                comentario.setPublicacionComun(publicacionComun);
            }
            Comentario comentarioPadre = comentario.getComentarioPadre();
            if (comentarioPadre != null) {
                comentarioPadre = em.getReference(comentarioPadre.getClass(), comentarioPadre.getId());
                comentario.setComentarioPadre(comentarioPadre);
            }
            List<Comentario> attachedComentarios = new ArrayList<Comentario>();
            for (Comentario comentariosComentarioToAttach : comentario.getComentarios()) {
                comentariosComentarioToAttach = em.getReference(comentariosComentarioToAttach.getClass(), comentariosComentarioToAttach.getId());
                attachedComentarios.add(comentariosComentarioToAttach);
            }
            comentario.setComentarios(attachedComentarios);
            em.persist(comentario);
            if (usuarioNormal != null) {
                usuarioNormal.getComenatarios().add(comentario);
                usuarioNormal = em.merge(usuarioNormal);
            }
            if (publicacionComun != null) {
                publicacionComun.getComentarios().add(comentario);
                publicacionComun = em.merge(publicacionComun);
            }
            if (comentarioPadre != null) {
                comentarioPadre.getComentarios().add(comentario);
                comentarioPadre = em.merge(comentarioPadre);
            }
            for (Comentario comentariosComentario : comentario.getComentarios()) {
                Comentario oldComentarioPadreOfComentariosComentario = comentariosComentario.getComentarioPadre();
                comentariosComentario.setComentarioPadre(comentario);
                comentariosComentario = em.merge(comentariosComentario);
                if (oldComentarioPadreOfComentariosComentario != null) {
                    oldComentarioPadreOfComentariosComentario.getComentarios().remove(comentariosComentario);
                    oldComentarioPadreOfComentariosComentario = em.merge(oldComentarioPadreOfComentariosComentario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comentario comentario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Comentario persistentComentario = em.find(Comentario.class, comentario.getId());
            Normal usuarioNormalOld = persistentComentario.getUsuarioNormal();
            Normal usuarioNormalNew = comentario.getUsuarioNormal();
            Comun publicacionComunOld = persistentComentario.getPublicacionComun();
            Comun publicacionComunNew = comentario.getPublicacionComun();
            Comentario comentarioPadreOld = persistentComentario.getComentarioPadre();
            Comentario comentarioPadreNew = comentario.getComentarioPadre();
            List<Comentario> comentariosOld = persistentComentario.getComentarios();
            List<Comentario> comentariosNew = comentario.getComentarios();
            if (usuarioNormalNew != null) {
                usuarioNormalNew = em.getReference(usuarioNormalNew.getClass(), usuarioNormalNew.getId());
                comentario.setUsuarioNormal(usuarioNormalNew);
            }
            if (publicacionComunNew != null) {
                publicacionComunNew = em.getReference(publicacionComunNew.getClass(), publicacionComunNew.getId());
                comentario.setPublicacionComun(publicacionComunNew);
            }
            if (comentarioPadreNew != null) {
                comentarioPadreNew = em.getReference(comentarioPadreNew.getClass(), comentarioPadreNew.getId());
                comentario.setComentarioPadre(comentarioPadreNew);
            }
            List<Comentario> attachedComentariosNew = new ArrayList<Comentario>();
            for (Comentario comentariosNewComentarioToAttach : comentariosNew) {
                comentariosNewComentarioToAttach = em.getReference(comentariosNewComentarioToAttach.getClass(), comentariosNewComentarioToAttach.getId());
                attachedComentariosNew.add(comentariosNewComentarioToAttach);
            }
            comentariosNew = attachedComentariosNew;
            comentario.setComentarios(comentariosNew);
            comentario = em.merge(comentario);
            if (usuarioNormalOld != null && !usuarioNormalOld.equals(usuarioNormalNew)) {
                usuarioNormalOld.getComenatarios().remove(comentario);
                usuarioNormalOld = em.merge(usuarioNormalOld);
            }
            if (usuarioNormalNew != null && !usuarioNormalNew.equals(usuarioNormalOld)) {
                usuarioNormalNew.getComenatarios().add(comentario);
                usuarioNormalNew = em.merge(usuarioNormalNew);
            }
            if (publicacionComunOld != null && !publicacionComunOld.equals(publicacionComunNew)) {
                publicacionComunOld.getComentarios().remove(comentario);
                publicacionComunOld = em.merge(publicacionComunOld);
            }
            if (publicacionComunNew != null && !publicacionComunNew.equals(publicacionComunOld)) {
                publicacionComunNew.getComentarios().add(comentario);
                publicacionComunNew = em.merge(publicacionComunNew);
            }
            if (comentarioPadreOld != null && !comentarioPadreOld.equals(comentarioPadreNew)) {
                comentarioPadreOld.getComentarios().remove(comentario);
                comentarioPadreOld = em.merge(comentarioPadreOld);
            }
            if (comentarioPadreNew != null && !comentarioPadreNew.equals(comentarioPadreOld)) {
                comentarioPadreNew.getComentarios().add(comentario);
                comentarioPadreNew = em.merge(comentarioPadreNew);
            }
            for (Comentario comentariosOldComentario : comentariosOld) {
                if (!comentariosNew.contains(comentariosOldComentario)) {
                    comentariosOldComentario.setComentarioPadre(null);
                    comentariosOldComentario = em.merge(comentariosOldComentario);
                }
            }
            for (Comentario comentariosNewComentario : comentariosNew) {
                if (!comentariosOld.contains(comentariosNewComentario)) {
                    Comentario oldComentarioPadreOfComentariosNewComentario = comentariosNewComentario.getComentarioPadre();
                    comentariosNewComentario.setComentarioPadre(comentario);
                    comentariosNewComentario = em.merge(comentariosNewComentario);
                    if (oldComentarioPadreOfComentariosNewComentario != null && !oldComentarioPadreOfComentariosNewComentario.equals(comentario)) {
                        oldComentarioPadreOfComentariosNewComentario.getComentarios().remove(comentariosNewComentario);
                        oldComentarioPadreOfComentariosNewComentario = em.merge(oldComentarioPadreOfComentariosNewComentario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = comentario.getId();
                if (findComentario(id) == null) {
                    throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.");
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
            Comentario comentario;
            try {
                comentario = em.getReference(Comentario.class, id);
                comentario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comentario with id " + id + " no longer exists.", enfe);
            }
            Normal usuarioNormal = comentario.getUsuarioNormal();
            if (usuarioNormal != null) {
                usuarioNormal.getComenatarios().remove(comentario);
                usuarioNormal = em.merge(usuarioNormal);
            }
            Comun publicacionComun = comentario.getPublicacionComun();
            if (publicacionComun != null) {
                publicacionComun.getComentarios().remove(comentario);
                publicacionComun = em.merge(publicacionComun);
            }
            Comentario comentarioPadre = comentario.getComentarioPadre();
            if (comentarioPadre != null) {
                comentarioPadre.getComentarios().remove(comentario);
                comentarioPadre = em.merge(comentarioPadre);
            }
            List<Comentario> comentarios = comentario.getComentarios();
            for (Comentario comentariosComentario : comentarios) {
                comentariosComentario.setComentarioPadre(null);
                comentariosComentario = em.merge(comentariosComentario);
            }
            em.remove(comentario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comentario> findComentarioEntities() {
        return findComentarioEntities(true, -1, -1);
    }

    public List<Comentario> findComentarioEntities(int maxResults, int firstResult) {
        return findComentarioEntities(false, maxResults, firstResult);
    }

    private List<Comentario> findComentarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comentario.class));
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

    public Comentario findComentario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comentario.class, id);
        } finally {
            em.close();
        }
    }

    public int getComentarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comentario> rt = cq.from(Comentario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
