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
    public IComentarioDAO crearComentarioDAO() {
        return new ComentarioDAO(conexionBD.usarBD());
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
