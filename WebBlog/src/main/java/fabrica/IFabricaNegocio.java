/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import negocio.PublicacionNegocio;
import negocio.UsuarioNegocio;

/**
 *
 * @author HP
 */
public interface IFabricaNegocio {

    public UsuarioNegocio createUsuarioNegocio();

    public PublicacionNegocio createPublicacionNegocio();
}
