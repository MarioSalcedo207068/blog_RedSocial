/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.IAncladaDAO;

/**
 *
 * @author HP
 */
public class FacadeAncladaDAO {

    IAncladaDAO ancladaDAO;

    public FacadeAncladaDAO(IAncladaDAO ancladaDAO) {
        this.ancladaDAO = ancladaDAO;
    }

}
