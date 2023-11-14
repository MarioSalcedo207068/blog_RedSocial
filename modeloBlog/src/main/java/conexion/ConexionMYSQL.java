/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HP
 */
public class ConexionMYSQL implements IConexionBD {

    private EntityManagerFactory factory;

    @Override
    public EntityManagerFactory usarBD() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("persistencia");
        }
        return factory;
    }

}
