package pro.universidad.modelo;

import java.time.LocalDate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jannete
 */
public class Alumno {
   private int idAlumno;
   private String apellido;
   private String nombre;
   private boolean activo;
   private int legajo;
   private LocalDate fechaNac;

    public Alumno() {
    }

    public Alumno(int idAlumno, String apellido, String nombre, boolean activo, int legajo, LocalDate fechaNac) {
        this.idAlumno = idAlumno;
        this.apellido = apellido;
        this.nombre = nombre;
        this.activo = activo;
        this.legajo = legajo;
        this.fechaNac = fechaNac;
    }

    public Alumno(String apellido, String nombre, boolean activo, int legajo, LocalDate fechaNac) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.activo = activo;
        this.legajo = legajo;
        this.fechaNac = fechaNac;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return   apellido + " "+nombre;
    }
            
            
}
