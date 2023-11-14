/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.IPublicacionDAO;

/**
 *
 * @author HP
 */
public class FacadePublicacionDAO {

    IPublicacionDAO publicacionDAO;

    public FacadePublicacionDAO(IPublicacionDAO publicacionDAO) {
        this.publicacionDAO = publicacionDAO;
    }

}
