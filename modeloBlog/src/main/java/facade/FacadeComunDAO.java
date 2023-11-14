/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.IComunDAO;

/**
 *
 * @author HP
 */
public class FacadeComunDAO {

    IComunDAO comunDAO;

    public FacadeComunDAO(IComunDAO comunDAO) {
        this.comunDAO = comunDAO;
    }

}
