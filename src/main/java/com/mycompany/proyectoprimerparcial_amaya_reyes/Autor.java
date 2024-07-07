/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial_amaya_reyes;

import Enums.Rol;
import static Enums.Rol.A;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danie
 */
public class Autor extends Usuario{
    
    private ArrayList<Articulo> articulos;
    private String codigo;
    private String institucion;
    private String campoInvestigacion;
    private Rol rol;
    
    /***
     * Constructor de Autor
     * @param nombre
     * @param apellido
     * @param correoElectronico
     * @param codigo
     * @param institucion
     * @param campoInvestigacion 
     */
    String[] digitos = {"a", "b", "c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"};
    static Random rd = new Random();
    public Autor(String nombre, String apellido, String correoElectronico,String institucion,String campoInvestigacion, String user, String codigo, Rol rol) {
        super(nombre, apellido, correoElectronico, user, codigo, rol);
        this.institucion=institucion;
        this.campoInvestigacion=campoInvestigacion;
        this.rol = rol;
    }    

    /***
     * 
     * @return 
     */
    @Override
    public String getCode(){
        return codigo;
    }
    @Override
    public String getUser(){
        return user;
    }
    
    /***
     * 
     * @return 
     */
    public String getInstitucion(){
        return institucion;
    }
    
    /***
     * 
     * @return 
     */
    public String getCampoInvestigacion(){
        return campoInvestigacion;
    }

    /***
     * 
     * @param codigo 
     */
    public void setCode(String codigo){
        this.codigo=codigo;
    }
    
    /***
     * 
     * @param institucion 
     */
    public void setInstitucion(String institucion){
        this.institucion=institucion;
    }
    
    /***
     * 
     * @param campoInvestigacion 
     */
    public void setCampoInvestigacion(String campoInvestigacion){
        this.campoInvestigacion=campoInvestigacion;
    }
    /***
     * 
     * @return 
     */
    @Override
    public String toString() {
        return nombre + "," + apellido + "," + correoElectronico + ","
                + institucion + "," + campoInvestigacion+","+codigo+","+rol;
    }

    @Override
    public void revisarArticulo() {
    }
}


