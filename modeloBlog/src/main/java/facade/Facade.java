/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import factory.FactoryDAO;
import factory.IFactoryDAO;

/**
 *
 * @author HP
 */
public class Facade implements IFacade {

    IFactoryDAO factoryDAO;

    public Facade() {
        this.factoryDAO = new FactoryDAO();
    }

    @Override
    public FacadeComentarioDAO useComentarioDAO() {
        return new FacadeComentarioDAO(factoryDAO.crearComentarioDAO());
    }

    @Override
    public FacadePublicacionDAO usePublicacionDAO() {
        return new FacadePublicacionDAO(factoryDAO.crearPublicacionDAO());
    }

    @Override
    public FacadeUsuarioDAO useUsuarioDAO() {
        return new FacadeUsuarioDAO(factoryDAO.crearUsuarioDAO());
    }
}
