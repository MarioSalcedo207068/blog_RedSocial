/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.IEstadoDAO;

/**
 *
 * @author HP
 */
public class FacadeEstadoDAO {

    IEstadoDAO estadoDAO;

    public FacadeEstadoDAO(IEstadoDAO estadoDAO) {
        this.estadoDAO = estadoDAO;
    }

}
