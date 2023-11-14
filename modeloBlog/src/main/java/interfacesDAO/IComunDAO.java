/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesDAO;

import dominio.Comun;
import java.util.List;

/**
 *
 * @author HP
 */
public interface IComunDAO {

    public void create(Comun comun);

    public void edit(Comun comun);

    public void destroy(Long id);

    public Comun findComun(Long id);

    public List<Comun> findComunEntities();
}
