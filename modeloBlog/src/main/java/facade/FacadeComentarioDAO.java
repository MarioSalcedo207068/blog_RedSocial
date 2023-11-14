/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.IComentarioDAO;

/**
 *
 * @author HP
 */
public class FacadeComentarioDAO {

    IComentarioDAO comentarioDAO;

    public FacadeComentarioDAO(IComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }

}
