/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Administrador;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IAdministradorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeAdministradorDAO {

    IAdministradorDAO administradorDAO;

    public FacadeAdministradorDAO(IAdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    public void create(Administrador administrador) {
        administradorDAO.create(administrador);
    }

    public void edit(Administrador administrador) {
        try {
            administradorDAO.edit(administrador);
        } catch (Exception ex) {
            Logger.getLogger(FacadeAdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            administradorDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeAdministradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Administrador findAdministrador(Long id) {
        return administradorDAO.findAdministrador(id);
    }

    public List<Administrador> findAdministradorEntities() {
        return administradorDAO.findAdministradorEntities();
    }

}
