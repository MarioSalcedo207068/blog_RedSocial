/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Comentario;
import implementacionDAO.exceptions.NonexistentEntityException;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IComentarioDAO {

    public void create(Comentario comentario);

    public void edit(Comentario comentario) throws NonexistentEntityException, Exception;

    public void destroy(Long id) throws NonexistentEntityException;

    public Comentario findComentario(Long id);

    public List<Comentario> findComentarioEntities();
}
