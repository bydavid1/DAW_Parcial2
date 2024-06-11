package com.mycompany.webapp.entidades;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "inscripcion")
public class Inscripcion implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripcion_id_seq")
    @SequenceGenerator(name = "inscripcion_id_seq", sequenceName = "inscripcion_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "alumno_id", nullable = false)
    private Integer alumnoId;
    
    @Column(name = "materia_id", nullable = false)
    private Integer materiaId;
    
    @ManyToOne
    @JoinColumn(name = "alumno_id", insertable = false, updatable = false)
    private Alumno alumno;
    
    @ManyToOne
    @JoinColumn(name = "materia_id", insertable = false, updatable = false)
    private Materia materia;
    
    @Column(name = "anio", nullable = false)
    private Integer anio;
    
    @Column(name = "ciclo", nullable = false)
    private Integer ciclo;
    
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Integer getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Integer materiaId) {
        this.materiaId = materiaId;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getCiclo() {
        return ciclo;
    }

    public void setCiclo(Integer ciclo) {
        this.ciclo = ciclo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", alumnoId=" + alumnoId + ", materiaId=" + materiaId + ", anio=" + anio + ", ciclo=" + ciclo + ", fecha=" + fecha + '}';
    }

    public Inscripcion() {
    }

    public Inscripcion(Integer id, Integer alumnoId, Integer materiaId, Integer anio, Integer ciclo, Date fecha) {
        this.id = id;
        this.alumnoId = alumnoId;
        this.materiaId = materiaId;
        this.anio = anio;
        this.ciclo = ciclo;
        this.fecha = fecha;
    }
}
