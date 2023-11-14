/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Comun;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IComunDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeComunDAO {

    IComunDAO comunDAO;

    public FacadeComunDAO(IComunDAO comunDAO) {
        this.comunDAO = comunDAO;
    }

    public Comun create(Comun comun) {
        return comunDAO.create(comun);
    }

    public void edit(Comun comun) {
        try {
            comunDAO.edit(comun);
        } catch (Exception ex) {
            Logger.getLogger(FacadeComunDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            comunDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeComunDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Comun findComun(Long id) {
        return comunDAO.findComun(id);
    }

    public List<Comun> findComunEntities() {
        return comunDAO.findComunEntities();
    }

}
