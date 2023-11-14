/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.IAdministradorDAO;

/**
 *
 * @author HP
 */
public class FacadeAdministradorDAO {

    IAdministradorDAO administradorDAO;

    public FacadeAdministradorDAO(IAdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }
    
    

}
