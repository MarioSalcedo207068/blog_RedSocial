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
    public FacadeAdministradorDAO useAdministradorDAO() {
        return new FacadeAdministradorDAO(factoryDAO.crearAdministradorDAO());
    }

    @Override
    public FacadeAncladaDAO useAncladaDAO() {
        return new FacadeAncladaDAO(factoryDAO.crearAncladaDAO());
    }

    @Override
    public FacadeComentarioDAO useComentarioDAO() {
        return new FacadeComentarioDAO(factoryDAO.crearComentarioDAO());
    }

    @Override
    public FacadeComunDAO useComunDAO() {
        return new FacadeComunDAO(factoryDAO.crearComunDAO());
    }

    @Override
    public FacadeCredencialDAO useCredencialDAO() {
        return new FacadeCredencialDAO(factoryDAO.crearCredencialDAO());
    }

    @Override
    public FacadeEstadoDAO useEstadoDAO() {
        return new FacadeEstadoDAO(factoryDAO.crearEstadoDAO());
    }

    @Override
    public FacadeMunicipioDAO useMunicipioDAO() {
        return new FacadeMunicipioDAO(factoryDAO.crearMunicipioDAO());
    }

    @Override
    public FacadeNormalDAO useNormalDAO() {
        return new FacadeNormalDAO(factoryDAO.crearNormalDAO());
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
