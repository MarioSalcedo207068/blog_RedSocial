/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import interfacesDAO.*;

/**
 *
 * @author HP
 */
public interface IFactoryDAO {

    public IAdministradorDAO crearAdministradorDAO();

    public IAncladaDAO crearAncladaDAO();

    public IComentarioDAO crearComentarioDAO();

    public IComunDAO crearComunDAO();

    public ICredencialDAO crearCredencialDAO();

    public IEstadoDAO crearEstadoDAO();

    public IMunicipioDAO crearMunicipioDAO();

    public INormalDAO crearNormalDAO();

    public IPublicacionDAO crearPublicacionDAO();

    public IUsuarioDAO crearUsuarioDAO();
}
