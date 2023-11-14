/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Usuario;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IUsuarioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeUsuarioDAO {

    IUsuarioDAO usuarioDAO;

    public FacadeUsuarioDAO(IUsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public void create(Usuario usuario) {
        usuarioDAO.create(usuario);
    }

    public void edit(Usuario usuario) {
        try {
            usuarioDAO.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(FacadeUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            usuarioDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario findUsuario(Long id) {
        return usuarioDAO.findUsuario(id);
    }

    public List<Usuario> findUsuarioEntities() {
        return usuarioDAO.findUsuarioEntities();
    }

}
