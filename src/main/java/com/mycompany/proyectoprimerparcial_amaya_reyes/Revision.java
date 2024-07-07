/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial_amaya_reyes;

import Enums.Estado;
import static Enums.Estado.ACEPTADO;

/**
 *
 * @author danie
 */
public class Revision {

    private String codigo;
    private String titulo;
    private String comentario1;
    private String comentario2;
    private String comentario3;
    private Estado estado1;
    private Estado estado2;
    private Estado estado3;
    
    Revision(String codigo, String titulo){
        this.codigo = codigo;
        this.titulo = titulo;
        this.comentario1 = null;
        this.comentario2 = null;
        this.comentario3 = null;
        this.estado1 = ACEPTADO;
        this.estado2 = ACEPTADO;
        this.estado3 = ACEPTADO;
    }

    Revision(String codigo, String titulo, String comentario1, String comentario2, String comentario3, Estado estado1, Estado estado2, Estado estado3) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.comentario1 = comentario1;
        this.comentario2 = comentario2;
        this.comentario3 = comentario3;
        this.estado1 = estado1;
        this.estado2 = estado2;
        this.estado3 = estado3;
    }

    /**
     * *
     *
     */
    public void comentar() {

    }

    /**
     * *
     *
     */
    public void mostrarComentarios() {

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
    public String getComentario1() {
        return comentario1;
    }

    /***
     * 
     * @param comentario1 
     */
    public void setComentario1(String comentario1) {
        this.comentario1 = comentario1;
    }

    /***
     * 
     * @return 
     */
    public String getComentario2() {
        return comentario2;
    }

    /***
     * 
     * @param comentario2 
     */
    public void setComentario2(String comentario2) {
        this.comentario2 = comentario2;
    }

    /***
     * 
     * @return 
     */
    public String getComentario3() {
        return comentario3;
    }

    /***
     * 
     * @param comentario3 
     */
    public void setComentario3(String comentario3) {
        this.comentario3 = comentario3;
    }

    /***
     * 
     * @return 
     */
    public Estado getEstado1() {
        return estado1;
    }

    public void setEstado1(Estado estado1) {
        this.estado1 = estado1;
    }

    /***
     * 
     * @return 
     */
    public Estado getEstado2() {
        return estado2;
    }

    /***
     * 
     * @param estado2 
     */
    public void setEstado2(Estado estado2) {
        this.estado2 = estado2;
    }

    /***
     * 
     * @return 
     */
    public Estado getEstado3() {
        return estado3;
    }

    /***
     * 
     * @param estado3 
     */
    public void setEstado3(Estado estado3) {
        this.estado3 = estado3;
    }

    /***
     * 
     * @return 
     */
    public String toString() {
        return codigo + "," + titulo + "," + comentario1 + "," + comentario2 + "," + comentario3 + "," + estado1 + "," + estado2 + "," + estado3;
    }

}
