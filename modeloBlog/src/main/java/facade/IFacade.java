/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author HP
 */
public interface IFacade {

    public FacadeComentarioDAO useComentarioDAO();

    public FacadePublicacionDAO usePublicacionDAO();

    public FacadeUsuarioDAO useUsuarioDAO();
}
