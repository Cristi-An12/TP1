package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ConcursoTest {
    private Concurso concurso;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    private LocalDate fechaPrimerosDias;

    @BeforeEach
    public void setUp() {
        fechaInicio = LocalDate.now ();
        fechaLimite = LocalDate.now ().plusDays(10);
        fechaPrimerosDias =LocalDate.now ().plusDays (6);
        concurso = new Concurso (fechaInicio, fechaLimite, "Concurso rock", fechaPrimerosDias);
   }

    @Test
    public void InscripcionParticipantes () {
        //caso 1
        Participante participante1 = new Participante (123456, "Chester", "Bennington", LocalDate.now ());
        LocalDate fechaInscripcion = LocalDate.now ().plusDays (1);

        boolean resultado = concurso.agregarParticipante (fechaInscripcion, participante1);

        assertTrue (resultado);
        assertEquals (1, participante1.numeroDeInscripto());

        assertEquals (0, participante1.verPuntos ());

    }


    @Test
    void testInscripcionPrimerDia () {
        LocalDate fechaIncripcion = LocalDate.now ();
        fechaIncripcion = fechaIncripcion.plusDays (3);
        Participante participante;
        assert (participante.puntosGanados ());
    }

}