/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Administrador;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IAdministradorDAO {

    public void create(Administrador administrador);

    public void edit(Administrador administrador) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Administrador findAdministrador(Long id);

    public List<Administrador> findAdministradorEntities();

}
