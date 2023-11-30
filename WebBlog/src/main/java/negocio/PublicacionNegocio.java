/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import dominio.Anclada;
import dominio.Comun;
import dominio.Publicacion;
import facade.IFacade;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class PublicacionNegocio {

    private IFacade facade;

    public PublicacionNegocio(IFacade facade) {
        this.facade = facade;
    }

    public void registrarPublicacion(Publicacion publicacion) {
        this.facade.usePublicacionDAO().create(publicacion);
    }

    public List<Comun> consultarPublicacionesComunes() {
        List<Publicacion> publicaciones
                = facade.usePublicacionDAO().findPublicacionEntities();
        List<Comun> publicacionesComunes = new ArrayList<>();
        for (int i = 0; i < publicaciones.size(); i++) {
            if (publicaciones.get(i) instanceof Comun) {
                publicacionesComunes.add((Comun) publicaciones.get(i));
            }
        }
        return publicacionesComunes;
    }

    public List<Anclada> consultarPublicacionesAncladas() {
        List<Publicacion> publicaciones
                = facade.usePublicacionDAO().findPublicacionEntities();
        List<Anclada> publicacionesAncladas = null;
        for (int i = 0; i < publicaciones.size(); i++) {
            if (publicaciones.get(i) instanceof Anclada) {
                publicacionesAncladas.add((Anclada) publicaciones.get(i));
            }
        }
        return publicacionesAncladas;
    }
}
