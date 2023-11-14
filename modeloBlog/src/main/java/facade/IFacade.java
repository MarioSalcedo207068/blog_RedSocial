/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

/**
 *
 * @author HP
 */
public interface IFacade {

    public FacadeAdministradorDAO useAdministradorDAO();

    public FacadeAncladaDAO useAncladaDAO();

    public FacadeComentarioDAO useComentarioDAO();

    public FacadeComunDAO useComunDAO();

    public FacadeCredencialDAO useCredencialDAO();

    public FacadeEstadoDAO useEstadoDAO();

    public FacadeMunicipioDAO useMunicipioDAO();

    public FacadeNormalDAO useNormalDAO();

    public FacadePublicacionDAO usePublicacionDAO();

    public FacadeUsuarioDAO useUsuarioDAO();
}
