/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Credencial;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.ICredencialDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeCredencialDAO {

    ICredencialDAO credencialDAO;

    public FacadeCredencialDAO(ICredencialDAO credencialDAO) {
        this.credencialDAO = credencialDAO;
    }

    public void create(Credencial credencial) {
        credencialDAO.create(credencial);
    }

    public void edit(Credencial credencial) {
        try {
            credencialDAO.edit(credencial);
        } catch (Exception ex) {
            Logger.getLogger(FacadeCredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            credencialDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeCredencialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Credencial findCredencial(Long id) {
        return credencialDAO.findCredencial(id);
    }

    public List<Credencial> findCredencialEntities() {
        return credencialDAO.findCredencialEntities();
    }

}
