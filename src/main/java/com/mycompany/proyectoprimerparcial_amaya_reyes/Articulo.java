/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial_amaya_reyes;

import Enums.Estado;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author danie
 */
public class Articulo {
    private String titulo;
    private String resumen;
    private String contenido;
    private String palabrasClave;
    private String codigo;
    private String autor;
    private Revisor revisor1;
    private Revisor revisor2;
    
    
    
    public Articulo(String titulo, String resumen, String contenido, String palabrasClave, String autor, String codigo){
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido = contenido;
        this.palabrasClave = palabrasClave;
        this.autor = autor;
        this.codigo = codigo;
    }
    
    /***
     * 
     * @return 
     */
    public String getTitulo() {
        return titulo;
    }

    /***
     * 
     * @param titulo 
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /***
     * 
     * @return 
     */
    public String getResumen() {
        return resumen;
    }

    /***
     * 
     * @param resumen 
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    /***
     * 
     * @return 
     */
    public String getContenido() {
        return contenido;
    }

    /***
     * 
     * @param contenido 
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /***
     * 
     * @return 
     */
    public String getPalabrasClave() {
        return palabrasClave;
    }

    /***
     * 
     * @param palabrasClave 
     */
    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    /***
     * 
     * @return 
     */
    public String getCodigo() {
        return codigo;
    }

    /***
     * 
     * @param codigo 
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    /***
     * 
     * @return 
     */
    public String getAutorNombre(){
        return autor;
    }
    
    /***
     * 
     * @return 
     */
    public Revisor getRev1(){
        return revisor1;
    }
    
    public void setRevisor1(Revisor rev1){
        this.revisor1 = rev1;
    }
    
    /***
     * 
     * @return 
     */
    public Revisor getRev2(){
        return revisor2;
    }
    
    /***
     * 
     * @param rev2 
     */
    public void setRevisor2(Revisor rev2){
        this.revisor2 = rev2;
    }
    /***
     * 
     * @return 
     */
    @Override
    public String toString() {
        return titulo + "," + resumen + "," + contenido + ","
                + palabrasClave +","+autor+","+codigo;
    }
    
    
}
