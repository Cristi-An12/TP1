package org.example;

import java.time.LocalDate;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main (String[] args) {
        LocalDate fechaInicio = LocalDate.now ();
        LocalDate fechaLimite = LocalDate.now ().plusDays (10);
        LocalDate PrimerosDias = LocalDate.now ();

        Concurso concurso = new Concurso (fechaInicio, fechaLimite, "CONCURSO DE ROCK", PrimerosDias);



        Participante participante1 = new Participante (123456, "Chester", "Bennington", LocalDate.now ());
        Participante participante2 = new Participante (987654, "Ricardo", "Iorio", LocalDate.now ().plusDays (3));
        Participante participante3 = new Participante (192837, "John", "Lennon", LocalDate.now ());

        concurso.agregarParticipante (participante1.fechaInscripcionParticipante(), participante1);
        concurso.agregarParticipante (participante2.fechaInscripcionParticipante(), participante2);
        concurso.agregarParticipante (participante3.fechaInscripcionParticipante(), participante3);

        participante1.puntosGanados ();
        participante2.puntosGanados ();
        participante3.puntosGanados ();

    }
}