package co.edu.uniquindio.poo.hospital.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TestAdministrador {

    @Test
    public void testGenerarReporteOcupacion() {
        Hospital hospital = new Hospital();

        Administrador administrador = new Administrador(1, "Carlos Gómez", "carlos@email.com",LocalDate.of(2023, 4, 24),"42343");

        Medico medico1 = new Medico(101, "Dr. Juan Pérez", "juan@hospital.com",LocalDate.of(1990,3,5),"Cardiología","898698");
        Medico medico2 = new Medico(102, "Dra. María López", "maria@hospital.com", LocalDate.of(1980,2,6),"Pediatría","798797");
        administrador.registrarMedico(hospital, medico1);
        administrador.registrarMedico(hospital, medico2);

        Paciente paciente1 = new Paciente(201, "Luis Fernández", "luis@email.com", LocalDate.of(1980,5,6),"4545");
        Paciente paciente2 = new Paciente(202, "Ana Rodríguez", "ana@email.com", LocalDate.of(2001,4,23),"45345");
        Paciente paciente3 = new Paciente(203, "Pedro García", "pedro@email.com", LocalDate.of(2020,06,11),"345345");

        administrador.registrarPaciente(hospital, paciente1);
        administrador.registrarPaciente(hospital, paciente2);
        administrador.registrarPaciente(hospital, paciente3);

        administrador.asignarPaciente(medico1, paciente1);
        administrador.asignarPaciente(medico1, paciente2);
        administrador.asignarPaciente(medico2, paciente3);

        administrador.generarReporteOcupacion(hospital);

        Assertions.assertEquals(2, medico1.getPacientes().size(), "El Dr. Juan Pérez debería tener 2 pacientes.");
        Assertions.assertEquals(1, medico2.getPacientes().size(), "La Dra. María López debería tener 1 paciente.");
    }
}
