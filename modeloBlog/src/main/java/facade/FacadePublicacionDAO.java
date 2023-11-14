/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Publicacion;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IPublicacionDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadePublicacionDAO {

    IPublicacionDAO publicacionDAO;

    public FacadePublicacionDAO(IPublicacionDAO publicacionDAO) {
        this.publicacionDAO = publicacionDAO;
    }

    public void create(Publicacion publicacion) {
        publicacionDAO.create(publicacion);
    }

    public void edit(Publicacion publicacion) {
        try {
            publicacionDAO.edit(publicacion);
        } catch (Exception ex) {
            Logger.getLogger(FacadePublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            publicacionDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadePublicacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Publicacion findPublicacion(Long id) {
        return publicacionDAO.findPublicacion(id);
    }

    public List<Publicacion> findPublicacionEntities() {
        return publicacionDAO.findPublicacionEntities();
    }

}
