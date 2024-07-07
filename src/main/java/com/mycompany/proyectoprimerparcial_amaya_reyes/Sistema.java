/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprimerparcial_amaya_reyes;

import static Enums.Estado.ACEPTADO;
import static Enums.Estado.RECHAZADO;
import Enums.Rol;
import static Enums.Rol.A;
import ManejoArchivos.ManejoArchivos;
import static ManejoArchivos.ManejoArchivos.LeerValidando;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class Sistema {

    private static final String correo = "pruebapoo65@gmail.com";
    private static final String clave = "ogvk ijcx ndfb pwfr";
    private static String host = "smtp.gmail.com";
    private static String puerto = "465";
    private static Properties properties = new Properties();
    private static Session session;
    static ArrayList<Usuario> listaAutores = new ArrayList<>();
    static ArrayList<Revisor> listaRevisores = new ArrayList<>();
    static ArrayList<Articulo> listaArticulos = new ArrayList<>();
    static ArrayList<Revision> listaRevisiones = new ArrayList<>();
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    static String[] digitos = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    static Random rd = new Random();

    public static String crearCodigo() {
        String cod = "";
        for (int i = 0; i < 4; i++) {
            int randomNumber = rd.nextInt(36);
            cod += digitos[randomNumber];
        }
        return cod;
    }

    /**
     *
     */
    public static void cargarPropiedades() {
//        properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.ssl.trust", host);
        properties.put("mail.smtp.port", puerto);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", true);
        properties.put("mail.smtp.socketFactory.port", puerto);
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }

    public static String getCorreo() {
        return correo;
    }

    /**
     *
     */
    public static void crearSesion() {
        session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(correo, clave);
            }
        });
    }

    public static String sendMail(String destinatario, String asunto, String mensaje) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correo));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asunto);
            message.setText(mensaje);
            Transport.send(message);
            return "Correo enviado correctamente a " + destinatario;
        } catch (MessagingException e) {
            return "Error al enviar correo a " + destinatario + ": " + e.getMessage();
        }
    }

    /**
     * *
     *
     * @param args
     */
    public static void main(String[] args) {
        cargarPropiedades();
        crearSesion();

        System.out.println(sendMail("danielamaya4568@gmail.com", "owo", "al finnnnnnnn"));
        cargarArticulos();
        cargarUsuarios();
        System.out.println(listaUsuarios);
        mostrarMenu();
    }

    public static void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Someter articulo\n2. Iniciar sesion\n3. Salir");
        String eleccion = sc.nextLine();
        switch (eleccion) {
            case "1" -> {
                someterArticulo();
                mostrarMenu();
            }
            case "2" -> {
                iniciarSesion();
                mostrarMenu();
            }
            case "3" -> {
                break;
            }
        }

    }

    public static void cargarUsuarios() {
        ArrayList<String[]> datosUsuarios = LeerValidando("usuarios.txt", false);
        for (String[] dato : datosUsuarios) {
            switch (dato[6]) {
                case "R" -> {
                    listaRevisores.add(new Revisor(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], Rol.valueOf(dato[6])));
                    listaUsuarios.add(new Revisor(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], Rol.valueOf(dato[6])));

                }
                case "E" -> {
                    listaUsuarios.add(new Editor(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5], Rol.valueOf(dato[6])));

                }
            }
        }
    }

    /**
     * *
     *
     */
    public static void cargarArticulos() {
        ArrayList<String[]> datosArticulos = LeerValidando("articulos.txt", false);
        for (String[] dato : datosArticulos) {
            listaArticulos.add(new Articulo(dato[0], dato[1], dato[2], dato[3], dato[4], dato[5]));
        }
    }

    public static void imprimir() {
        for (Usuario usuario : listaUsuarios) {
            System.out.println(usuario);
        }
    }

    /**
     * *
     *
     */
    public static void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        imprimir();
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("BIENVENIDO AL SISTEMA");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.print("USUARIO: ");
        String user = sc.nextLine();
        System.out.print("CONTRASENIA: ");
        String password = sc.nextLine();
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUser().equals(user) && usuario.getCode().equals(password)) {

                if (usuario instanceof Revisor revisor) {
                    System.out.println("Ingreso exitoso");
                    System.out.println("Revisor: Revision del articulo");
                    sc.nextLine();
                    System.out.println("Ingrese el codigo del articulo que desee aprobar");
                    String art = sc.nextLine();
                    for (Articulo arti : listaArticulos) {
                        if (art.endsWith(arti.getCodigo())) {
                            System.out.println("Los datos a revisar son\n" + arti);
                        }
                    }
                    for (Revision rev : listaRevisiones) {
                        System.out.println("Escriba un comentario");
                        String comentario = sc.nextLine();
                        if (rev.getComentario1() == null) {
                            rev.setComentario1(comentario);
                        } else if (rev.getComentario1() != null && rev.getComentario2() == null) {
                            rev.setComentario2(comentario);
                        }
                        System.out.println("Aprueba este articulo? S/N");
                        String respuesta = sc.nextLine();
                        switch (respuesta) {
                            case "S" -> {
                                if (rev.getEstado1().equals(ACEPTADO)) {
                                    rev.setEstado1(ACEPTADO);
                                    iniciarSesion();
                                } else if ((rev.getEstado1().equals(RECHAZADO) || rev.getEstado1().equals(ACEPTADO)) && rev.getEstado2().equals(ACEPTADO)) {
                                    rev.setEstado2(ACEPTADO);
                                    iniciarSesion();
                                }
                            }
                            case "N" -> {
                                if (rev.getEstado1().equals(ACEPTADO)) {
                                    rev.setEstado1(RECHAZADO);
                                } else if (rev.getEstado1().equals(RECHAZADO) && rev.getEstado2().equals(ACEPTADO)) {
                                    rev.setEstado2(RECHAZADO);

                                }
                            }
                        }
                    }
                    iniciarSesion();
                }

                if (usuario instanceof Editor editor) {
                    sc.nextLine();
                    System.out.println("Ingreso exitoso");
                    System.out.println("Editor: Registro de decision final sobre articulo");
                    System.out.println("Ingrese el codigo del articulo que desee aprobar");
                    String art = sc.nextLine();
                    for (Articulo arti : listaArticulos) {
                        if (art.endsWith(arti.getCodigo())) {
                            System.out.println(arti);
                        }
                    }
                    for (Revision rev : listaRevisiones) {
                        System.out.println("Escriba un comentario");
                        String comentarioEditor = sc.nextLine();

                        if (rev.getComentario3() == null) {

                            rev.setComentario3(comentarioEditor);

                        }
                        System.out.println("Aprueba este articulo? S/N");
                        String respuesta = sc.nextLine();
                        switch (respuesta) {
                            case "S" -> {
                                if (rev.getEstado3().equals(ACEPTADO)) {
                                    rev.setEstado3(ACEPTADO);
                                    ManejoArchivos.EscribirArchivo("revisiones.txt", rev.toString());

                                }
                            }
                            case "N" -> {
                                if (rev.getEstado3().equals(ACEPTADO)) {
                                    rev.setEstado3(RECHAZADO);
                                    ManejoArchivos.EscribirArchivo("revisiones.txt", rev.toString());

                                }
                            }

                        }
                        if ((rev.getEstado1().equals(ACEPTADO) && rev.getEstado2().equals(ACEPTADO)) && rev.getEstado3().equals(ACEPTADO)) {
                            for (Articulo arti : listaArticulos) {
                                if (rev.getCodigo().endsWith(arti.getCodigo())) {
                                    for (Usuario autor : listaAutores) {
                                        if (autor instanceof Autor) {
                                            if (arti.getAutorNombre().equals(autor.getNombre())) {
                                                System.out.println(sendMail(autor.getCorreo(), "Su articulo fue aprobado", "Se le informa que su articulo ha sido aprobado"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if ((rev.getEstado1().equals(ACEPTADO) && rev.getEstado2().equals(ACEPTADO)) && rev.getEstado3().equals(RECHAZADO)) {
                            for (Articulo arti : listaArticulos) {
                                if (rev.getCodigo().endsWith(arti.getCodigo())) {
                                    for (Usuario autor : listaAutores) {
                                        if (autor instanceof Autor) {
                                            if (arti.getAutorNombre().equals(autor.getNombre())) {
                                                System.out.println(sendMail(autor.getCorreo(), "Su articulo fue Rechazado", "Se le informa que su articulo ha sido rechazado"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if ((rev.getEstado1().equals(RECHAZADO) && rev.getEstado2().equals(ACEPTADO)) && rev.getEstado3().equals(ACEPTADO)) {
                            for (Articulo arti : listaArticulos) {
                                if (rev.getCodigo().endsWith(arti.getCodigo())) {
                                    for (Usuario autor : listaAutores) {
                                        if (autor instanceof Autor) {
                                            if (arti.getAutorNombre().equals(autor.getNombre())) {
                                                System.out.println(sendMail(autor.getCorreo(), "Su articulo fue aceptado", "Se le informa que su articulo ha sido aceptado"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if ((rev.getEstado1().equals(ACEPTADO) && rev.getEstado2().equals(RECHAZADO)) && rev.getEstado3().equals(ACEPTADO)) {
                            for (Articulo arti : listaArticulos) {
                                if (rev.getCodigo().endsWith(arti.getCodigo())) {
                                    for (Usuario autor : listaAutores) {
                                        if (autor instanceof Autor) {
                                            if (arti.getAutorNombre().equals(autor.getNombre())) {
                                                System.out.println(sendMail(autor.getCorreo(), "Su articulo fue Rechazado", "Se le informa que su articulo ha sido rechazado"));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        
                    }
                }
                cargarPropiedades();
            }
        }

    }

    /**
     * *
     *
     */
    public static void someterArticulo() {
        Scanner sc = new Scanner(System.in);
        String palabras = "";
        System.out.println("Ingrese su nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su Apellido");
        String apellido = sc.nextLine();
        System.out.println("Ingrese su correo");
        String correo = sc.nextLine();
        System.out.println("Ingrese la institucion para la que trabaja");
        String instit = sc.nextLine();
        System.out.println("Ingrese su campo de investigacion");
        String campInv = sc.nextLine();
        Autor autor = new Autor(nombre, apellido, correo, instit, campInv, crearCodigo(), crearCodigo(), A);
        listaAutores.add(autor);
        ManejoArchivos.EscribirArchivo("autores.txt", autor.toString());
        sc.nextLine();
        System.out.println("Ahora registre los datos de su articulo");
        System.out.println("Ingrese el titulo");
        String titulo = sc.nextLine();
        System.out.println("Ingrese un resumen");
        String resumen = sc.nextLine();
        System.out.println("Ingrese el contenido");
        String contenido = sc.nextLine();
        System.out.println("Cuantas palabras clave tendra?");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Ingrese una palabra clave");
            String palabraClave = sc.nextLine();
            palabras += palabraClave + " ";
        }
        //Se asignan los revisores al articulo
        Revisor rev1 = asignarRevisor();
        Revisor rev2 = asignarRevisor();
        while (rev2.equals(rev1)) {
            rev2 = asignarRevisor();
        }
        Articulo articulo = new Articulo(titulo, resumen, contenido, palabras, autor.getNombre(), crearCodigo());
        articulo.setRevisor1(rev1);
        articulo.setRevisor2(rev2);
        Revision revision = new Revision(articulo.getCodigo(), articulo.getTitulo());
        listaRevisiones.add(revision);
        listaArticulos.add(articulo);
        ManejoArchivos.EscribirArchivo("articulos.txt", articulo.toString());
        sc.nextLine();
        System.out.println(articulo.getRev1().correoElectronico + "\nSe le escribe con el objetivo de indicarle que se le asigno revisar el articulo con el codigo: " + articulo.getCodigo());
        System.out.println(articulo.getRev2().correoElectronico + "\nSe le escribe con el objetivo de indicarle que se le asigno revisar el articulo con el codigo: " + articulo.getCodigo());
        sendMail(rev1.getCorreo(), "Debe revisar el articulo: " + articulo.getCodigo(), articulo.getContenido());
        sendMail(rev2.getCorreo(), "Debe revisar el articulo: " + articulo.getCodigo(), articulo.getContenido());
    }

    /**
     * *
     *
     * @return
     */
    public static Revisor asignarRevisor() {
        int randomNumber = rd.nextInt(listaRevisores.size() + 1);
        return listaRevisores.get(randomNumber);
    }
}
