/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial_amaya_reyes;

import Enums.Rol;
import static Enums.Rol.R;

/**
 *
 * @author danie
 */
public class Revisor extends Usuario{
    private String especialidad;
    private int numArticulos;
    
    /***
     * Constructor de Revisor
     * @param nombre
     * @param apellido
     * @param correoElectronico
     * @param especialidad
     * @param user
     * @param code 
     * @param rol 
     */
    
    public Revisor(String nombre, String apellido, String correoElectronico, String especialidad, String user, String code, Rol rol) {
        super(nombre, apellido, correoElectronico, user, code, rol);
        this.especialidad = especialidad;
        this.user = correoElectronico.split("@")[0];
        this.code = code;
    }
    /***
     * 
     * @return 
     */
    public String especialidad(){
        return especialidad;
    }
    /***
     * 
     * @return 
     */
    public int getNumArticulos(){
        return numArticulos;
    }
    /***
     * 
     * @return 
     */
    @Override
    public String getUser(){
        return user;
    }
    
    /***
     * 
     * @return 
     */
    @Override
    public String getCode(){
        return code;
    }
    /***
     * 
     * @param especialidad 
     */
    public void setEspecialidad(String especialidad){
        this.especialidad = especialidad;
    }
    /***
     * 
     * @param numArticulos 
     */
    public void setNumArticulos(int numArticulos){
        this.numArticulos = numArticulos;
    }
    /***
     * 
     * @param user 
     */
    public void setUser(String user){
        this.user = user;
    }
    /***
     * 
     * @param code 
     */
    public void setCode(String code){
        this.code = code;
    }

    @Override
    public void revisarArticulo() {
    }
    @Override
    public String toString() {
        return nombre + "," + apellido + "," + correoElectronico + ","
                +numArticulos + "," + user+","+code+","+rol;
    }
    
}
