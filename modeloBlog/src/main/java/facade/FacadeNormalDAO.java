/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Normal;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.INormalDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeNormalDAO {

    INormalDAO normalDAO;

    public FacadeNormalDAO(INormalDAO normalDAO) {
        this.normalDAO = normalDAO;
    }

    public void create(Normal normal) {
        normalDAO.create(normal);
    }

    public void edit(Normal normal) {
        try {
            normalDAO.edit(normal);
        } catch (Exception ex) {
            Logger.getLogger(FacadeNormalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            normalDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeNormalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Normal findNormal(Long id) {
        return normalDAO.findNormal(id);
    }

    public List<Normal> findNormalEntities() {
        return normalDAO.findNormalEntities();
    }

}
