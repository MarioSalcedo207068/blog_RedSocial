/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Publicacion;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IPublicacionDAO {

    public void create(Publicacion publicacion);

    public void edit(Publicacion publicacion) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Publicacion findPublicacion(Long id);

    public List<Publicacion> findPublicacionEntities();
}
