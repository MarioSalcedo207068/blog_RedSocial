/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import facade.Facade;
import facade.IFacade;
import negocio.UsuarioNegocio;

/**
 *
 * @author HP
 */
public class FabricaNegocio implements IFabricaNegocio {

    IFacade facade;

    public FabricaNegocio() {
        this.facade = new Facade();
    }

    @Override
    public UsuarioNegocio createUsuarioNegocio() {
        return new UsuarioNegocio(facade);
    }

}
