/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Anclada;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IAncladaDAO {

    public void create(Anclada anclada);

    public void edit(Anclada anclada);

    public void destroy(Long id);

    public Anclada findAnclada(Long id);

    public List<Anclada> findAncladaEntities();
}
