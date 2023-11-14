/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dominio.Municipio;
import implementacionDAO.exceptions.NonexistentEntityException;
import interfacesDAO.IMunicipioDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class FacadeMunicipioDAO {

    IMunicipioDAO municipioDAO;

    public FacadeMunicipioDAO(IMunicipioDAO municipioDAO) {
        this.municipioDAO = municipioDAO;
    }

    public void create(Municipio municipio) {
        municipioDAO.create(municipio);
    }

    public void edit(Municipio municipio) {
        try {
            municipioDAO.edit(municipio);
        } catch (Exception ex) {
            Logger.getLogger(FacadeMunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void destroy(Long id) {
        try {
            municipioDAO.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FacadeMunicipioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Municipio findMunicipio(Long id) {
        return municipioDAO.findMunicipio(id);
    }

    public List<Municipio> findMunicipioEntities() {
        return municipioDAO.findMunicipioEntities();
    }

}
