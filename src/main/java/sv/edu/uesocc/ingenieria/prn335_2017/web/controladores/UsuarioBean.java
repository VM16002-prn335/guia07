/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.web.controladores;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.GenericFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso.UsuarioFacadeLocal;
import sv.edu.uesocc.ingenieria.prn335_2017.datos.definiciones.Usuario;

/**
 *
 * @author bryan
 */
@Named(value = "usuarioBean")
@ViewScoped
public class UsuarioBean extends GenericManagedBean<Usuario> implements Serializable {

    public UsuarioBean() {
    }

    @EJB
    UsuarioFacadeLocal facade;
    Usuario usuarioEntity;
    boolean mostrar = false, crudBtns=true;  

    // <editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public UsuarioFacadeLocal getFacade() {
        return facade;
    }

    public boolean isMostrar() {
        return mostrar;
    }

    public boolean isCrudBtns() {
        return crudBtns;
    }

    public void setCrudBtns(boolean crudBtns) {
        this.crudBtns = crudBtns;
    }

    public void setMostrar(boolean mostrar) {
        this.mostrar = mostrar;
    }

    public void setFacade(UsuarioFacadeLocal facade) {
        this.facade = facade;
    }

    public Usuario getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(Usuario usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }

    public List<Usuario> getListaDatos() {
        return listaDatos;
    }

    public void setListaDatos(List<Usuario> listaDatos) {
        this.listaDatos = listaDatos;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Overrrides">
    @Override
    public Usuario getEntity() {
        return usuarioEntity;
    }

    @Override
    protected GenericFacadeLocal<Usuario> getFacadeLocal() {
        return facade;
    }

   @Override
    public void reset() {
        usuarioEntity.setActivo(false);
        usuarioEntity.setApellidos(null);
        usuarioEntity.setComentarios(null);
        usuarioEntity.setFechaNacimiento(null);
        usuarioEntity.setNombres(null);
        usuarioEntity.setPassword(null);
        usuarioEntity.setUsername(null);
    }

    @Override
    public void nuevo() {
        usuarioEntity = new Usuario();
        setMostrar(true);
        setCrudBtns(true);
    }
    
    @Override
    public void cancelar(){
        usuarioEntity = new Usuario();
        setMostrar(false);
        setCrudBtns(true);
    }
    
    // </editor-fold>

    @PostConstruct
    public void init() {
        llenarLista();
    }
    
    /**
     * Este metodo sirve para mostrar el la fila seleccionada en un formulario para ser editado o eliminado
     * @param event 
     */
    public void onRowSelect(SelectEvent event) {
        setCrudBtns(false);
        setMostrar(true);
    }
    
}
