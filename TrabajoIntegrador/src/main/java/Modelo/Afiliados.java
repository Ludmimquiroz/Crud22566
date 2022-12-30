/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
/**
 *
 * @author alumno
 */
public class Afiliados {
    private int idAfiliados;
    private String nombre;
    private String apellido;
    private String direccion;
    private String localidad;
    private String nacionalidad;
    private LocalDate  fnac;
    private String mail;
    private String telefono;
    private boolean activo;

    public Afiliados(int idAfiliados, String nombre, String apellido, String direccion, String localidad, String nacionalidad, LocalDate fnac, String mail, String telefono, boolean activo) {
        this.idAfiliados = idAfiliados;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.localidad = localidad;
        this.nacionalidad = nacionalidad;
        this.fnac = fnac;
        this.mail = mail;
        this.telefono = telefono;
        this.activo = activo;
    }
    
    

    public int getIdAfiliados() {
        return idAfiliados;
    }

    public void setIdAfiliados(int idAfiliados) {
        this.idAfiliados = idAfiliados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getFnac() {
        return fnac;
    }

    public void setFnac(LocalDate fnac) {
        this.fnac = fnac;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
    
}

