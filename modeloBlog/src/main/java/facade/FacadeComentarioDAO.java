/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Comentario;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IComentarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeComentarioDAO {

    IComentarioDAO comentarioDAO;

    public FacadeComentarioDAO(IComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

    public void create(Comentario comentario) {
        comentarioDAO.create(comentario);
    }

    public void edit(Comentario comentario) {
        try {
            comentarioDAO.edit(comentario);
        } catch (Exception ex) {
            Logger.getLogger(FacadeComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            comentarioDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeComentarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Comentario findComentario(Long id) {
        return comentarioDAO.findComentario(id);
    }

    public List<Comentario> findComentarioEntities() {
        return comentarioDAO.findComentarioEntities();
    }

}
