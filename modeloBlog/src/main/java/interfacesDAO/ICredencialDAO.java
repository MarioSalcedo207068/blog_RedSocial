/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Credencial;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface ICredencialDAO {

    public void create(Credencial credencial);

    public void edit(Credencial credencial) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Credencial findCredencial(Long id);

    public List<Credencial> findCredencialEntities();
}
