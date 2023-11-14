/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.ICredencialDAO;

/**
 *
 * @author HP
 */
public class FacadeCredencialDAO {

    ICredencialDAO credencialDAO;

    public FacadeCredencialDAO(ICredencialDAO credencialDAO) {
        this.credencialDAO = credencialDAO;
    }

}
