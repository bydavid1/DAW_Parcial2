/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webapp.controladores;

import com.mycompany.webapp.entidades.Alumno;
import com.mycompany.webapp.entidades.Inscripcion;
import com.mycompany.webapp.entidades.Materia;
import com.mycompany.webapp.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class InscripcionController {
    
    private List<Inscripcion> inscripcionesList = new ArrayList<>();
    private List<Alumno> alumnosList = new ArrayList<>();
    private List<Materia> materiasList = new ArrayList<>();
    
    private Inscripcion inscripcion = new Inscripcion();
    
    @EJB 
    DataService servicio;
    
    @PostConstruct
    public void init(){
        cargarInscripciones();
        cargarAlumnos();
        cargarMaterias();
    }
    
    public void cargarInscripciones(){
        inscripcionesList = servicio.getInscripciones();
    }

    public void cargarAlumnos(){
        alumnosList = servicio.getAlumnos();
    }

    public void cargarMaterias(){
        materiasList = servicio.getMaterias();
    }

    public void guardarInscripcion(){
        servicio.saveInscripcion(inscripcion);
        inscripcion = new Inscripcion();  
        cargarInscripciones();                        
    }

    public void eliminarInscripcion(Inscripcion inscripcion){
        servicio.deleteInscripcion(inscripcion);
        cargarInscripciones();
    }
    
    //** Getter and Setter **//
    public List<Inscripcion> getInscripcionesList() {
        return inscripcionesList;
    }
    
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }
    
    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }
    
    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }
}