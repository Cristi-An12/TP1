package org.example;
import java.time.LocalDate;

public class Concurso {
    private String nombreConcurso;
    private int cantParticipantes=0;
    private LocalDate fechInicio;
    private LocalDate fechLimite;
    private LocalDate primerosDias;
    public Concurso (LocalDate fechInicio, LocalDate fechLimite, String nombreConcurso, LocalDate primerosDias) {
        this.fechInicio= fechInicio;
        this.fechLimite = fechLimite;
        this.nombreConcurso = nombreConcurso;
        this.primerosDias = primerosDias;
    }

    public boolean agregarParticipante(LocalDate fechaInscripto, Participante P){
        if (fechaInscripto.isAfter (fechInicio) && fechaInscripto.isBefore(fechLimite)) {
            if (fechaInscripto.isBefore(primerosDias)){
                P.agregarPuntos (10);
            }
            cantParticipantes++;
            P.agregarParticipante (cantParticipantes);
            System.out.println("Participante inscripto con exito");
            return true;
        } else{
            System.out.println(fechaInscripto + " supera la fecha limite de " + fechLimite);
        }
        return false;
    }
}
