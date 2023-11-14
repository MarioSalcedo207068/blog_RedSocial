/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Municipio;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IMunicipioDAO {

    public void create(Municipio municipio);

    public void edit(Municipio municipio) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Municipio findMunicipio(Long id);

    public List<Municipio> findMunicipioEntities();
}
