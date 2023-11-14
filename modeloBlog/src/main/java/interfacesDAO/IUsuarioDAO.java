/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Usuario;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IUsuarioDAO {

    public void create(Usuario usuario);

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Usuario findUsuario(Long id);

    public List<Usuario> findUsuarioEntities();
}
