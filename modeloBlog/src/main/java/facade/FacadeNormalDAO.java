/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import interfacesDAO.INormalDAO;

/**
 *
 * @author HP
 */
public class FacadeNormalDAO {

    INormalDAO normalDAO;

    public FacadeNormalDAO(INormalDAO normalDAO) {
        this.normalDAO = normalDAO;
    }

}
