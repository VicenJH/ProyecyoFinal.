package co.edu.uniquindio.poo.hospital.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TestPaciente {

    @Test
    public void testGetCitasProgramadas() {

        Paciente paciente = new Paciente(101, "Juan López", "juan@correo.com", LocalDate.of(1990,5,15));

        Medico medico = new Medico(1, "Dr. Pérez", "perez@hospital.com", LocalDate.of(2003,3,23),"Cardiología");

        CitaMedica cita1 = new CitaMedica(LocalDateTime.of(2025, 5, 10, 14, 30), paciente, medico);
        CitaMedica cita2 = new CitaMedica(LocalDateTime.of(2025, 6, 20, 9, 0), paciente, medico);

        paciente.getCitasProgramadas().add(cita1);
        paciente.getCitasProgramadas().add(cita2);

        List<CitaMedica> citas = paciente.getCitasProgramadas();

        Assertions.assertEquals(2, citas.size(), "Debe haber 2 citas médicas programadas.");
        Assertions.assertTrue(citas.contains(cita1), "El paciente debe tener la cita 1 registrada.");
        Assertions.assertTrue(citas.contains(cita2), "El paciente debe tener la cita 2 registrada.");

        System.out.println("Citas programadas para " + paciente.getNombre() + ":");
        for (CitaMedica cita : citas) {
            System.out.println("- " + cita.detallesCita());
        }
        System.out.println("Todas las pruebas han pasado correctamente. ¡El método getCitasProgramadas() funciona bien!");
    }
}