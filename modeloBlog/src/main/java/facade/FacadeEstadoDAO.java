/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Estado;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IEstadoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeEstadoDAO {

    IEstadoDAO estadoDAO;

    public FacadeEstadoDAO(IEstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

    public void create(Estado estado) {
        estadoDAO.create(estado);
    }

    public void edit(Estado estado) {
        try {
            estadoDAO.edit(estado);
        } catch (Exception ex) {
            Logger.getLogger(FacadeEstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            estadoDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeEstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Estado findEstado(Long id) {
        return estadoDAO.findEstado(id);
    }

    public List<Estado> findEstadoEntities() {
        return estadoDAO.findEstadoEntities();
    }

}
