/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial_amaya_reyes;

import Enums.Rol;

/**
 *
 * @author danie
 */
public abstract class Usuario {
    protected String user;
    protected String code;
    protected String nombre;
    protected String apellido;
    protected String correoElectronico;
    protected Rol rol;
    
    /***
     * Constructor de Usuario
     * @param nombre
     * @param apellido
     * @param correoElectronico 
     */
    public Usuario(String nombre, String apellido, String correoElectronico, String usuario, String code, Rol rol){
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
    }
    /***
     * 
     * @return 
     */
    public String getNombre(){
        return nombre;
    }
    /***
     * 
     * @return 
     */
    public String getApellido(){
        return apellido;
    }
    /***
     * 
     * @return 
     */
    public String getCorreo(){
        return correoElectronico;
    }
    /***
     * 
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /***
     * 
     * @param apellido 
     */
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    /***
     * 
     * @param correoElectronico 
     */
    public void setCorreo(String correoElectronico){
        this.correoElectronico = correoElectronico;
    }
    
    public abstract void revisarArticulo();

    public String getUser() {
       return user;
    }

    Object getCode() {
        return code;
    }
    
}
