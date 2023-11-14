/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Estado;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IEstadolDAO {

    public void create(Estado estado);

    public void edit(Estado estado) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Estado findEstado(Long id);

    public List<Estado> findEstadoEntities();
}
