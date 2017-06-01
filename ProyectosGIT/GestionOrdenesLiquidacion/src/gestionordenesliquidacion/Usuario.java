/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionordenesliquidacion;

/**
 *
 * @author luis-valerio
 */
public class Usuario {
    
    public static Usuario userApp;
    private String usuario;
    private String correo;
    private String tipo_cuenta;

    public Usuario(String usuario, String tipo_cuenta,String correo) {
        this.usuario = usuario;
        this.correo = correo;
        this.tipo_cuenta = tipo_cuenta;
        userApp = this;
    }

    public Usuario() {
        userApp=null;
    }

    
    public String getTipo_cuenta() {
        return tipo_cuenta;
    }

    public void setTipo_cuenta(String tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", correo=" + correo + ", tipo_cuenta=" + tipo_cuenta + '}';
    }

}
