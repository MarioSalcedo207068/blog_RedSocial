/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import conexion.ConexionMYSQL;
import conexion.IConexionBD;
import implementacionDAO.*;
import interfacesDAO.*;

/**
 *
 * @author HP
 */
public class FactoryDAO implements IFactoryDAO {

    IConexionBD conexionBD;

    public FactoryDAO() {
        this.conexionBD = new ConexionMYSQL();
    }

    @Override
    public IAdministradorDAO crearAdministradorDAO() {
        return new AdministradorDAO(conexionBD.usarBD());
    }

    @Override
    public IAncladaDAO crearAncladaDAO() {
        return new AncladaDAO(conexionBD.usarBD());
    }

    @Override
    public IComentarioDAO crearComentarioDAO() {
        return new ComentarioDAO(conexionBD.usarBD());
    }

    @Override
    public IComunDAO crearComunDAO() {
        return new ComunDAO(conexionBD.usarBD());
    }

    @Override
    public ICredencialDAO crearCredencialDAO() {
        return new CredencialDAO(conexionBD.usarBD());
    }

    @Override
    public IEstadoDAO crearEstadoDAO() {
        return new EstadoDAO(conexionBD.usarBD());
    }

    @Override
    public IMunicipioDAO crearMunicipioDAO() {
        return new MunicipioDAO(conexionBD.usarBD());
    }

    @Override
    public INormalDAO crearNormalDAO() {
        return new NormalDAO(conexionBD.usarBD());
    }

    @Override
    public IPublicacionDAO crearPublicacionDAO() {
        return new PublicacionDAO(conexionBD.usarBD());
    }

    @Override
    public IUsuarioDAO crearUsuarioDAO() {
        return new UsuarioDAO(conexionBD.usarBD());
    }

}
