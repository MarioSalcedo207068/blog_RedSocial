/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Normal;
import dominio.Usuario;
import facade.IFacade;
import java.util.List;

/**
 *
 * @author HP
 */
public class UsuarioNegocio {

    private IFacade facade;

    public UsuarioNegocio(IFacade facade) {
        this.facade = facade;
    }

    public void registrarUsuario(Usuario usuario) {
        this.facade.useUsuarioDAO().create(usuario);
    }

    public Usuario validarInicioUsuario(String avatar, String contrasenia) {
        List<Usuario> usuarios = facade.useUsuarioDAO().findUsuarioEntities();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getAvatar().equals(avatar)
                    && usuarios.get(i).getCredencial().getContrasenia().equals(contrasenia)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

}
