package org.example;
import java.time.LocalDate;

public class Participante {
    private int DNI;
    private String nombre;
    private String apellido;
    private int numInscripcion;//la dara el concurso con un autoincremental
    private LocalDate fechaInscripto;
    private int puntos=0;

    public Participante (int DNI, String nombre, String apellido, LocalDate fechaInscripto) {
        this.DNI=DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaInscripto = fechaInscripto;
    }

    public void agregarPuntos (int puntosAgregados){
        puntos = puntos+puntosAgregados;
    }

    public void agregarParticipante (int numInscripcion){
        this.numInscripcion = numInscripcion;
    }

    public void puntosGanados(){
        System.out.println ("Los puntos de " + nombre + " " + apellido + " es de:" + puntos);
    }

    public LocalDate fechaInscripcionParticipante() {
        return fechaInscripto;
    }

    public int numeroDeInscripto (){
        return numInscripcion;
    }

    public int verPuntos (){
        return puntos;
    }
}
