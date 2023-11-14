/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Anclada;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IAncladaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeAncladaDAO {

    IAncladaDAO ancladaDAO;

    public FacadeAncladaDAO(IAncladaDAO ancladaDAO) {
        this.ancladaDAO = ancladaDAO;
    }

    public void create(Anclada anclada) {
        ancladaDAO.create(anclada);
    }

    public void edit(Anclada anclada) {
        try {
            ancladaDAO.edit(anclada);
        } catch (Exception ex) {
            Logger.getLogger(FacadeAncladaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            ancladaDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeAncladaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Anclada findAnclada(Long id) {
        return ancladaDAO.findAnclada(id);
    }

    public List<Anclada> findAncladaEntities() {
        return ancladaDAO.findAncladaEntities();
    }

}
