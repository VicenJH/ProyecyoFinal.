package co.edu.uniquindio.poo.hospital.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAdministrador {

    @Test
    public void testGenerarReporteOcupacion() {
        Hospital hospital = new Hospital();

        Administrador administrador = new Administrador(1, "Carlos Gómez", "carlos@email.com");

        Medico medico1 = new Medico(101, "Dr. Juan Pérez", "juan@hospital.com", "Cardiología");
        Medico medico2 = new Medico(102, "Dra. María López", "maria@hospital.com", "Pediatría");
        administrador.registrarMedico(hospital, medico1);
        administrador.registrarMedico(hospital, medico2);

        Paciente paciente1 = new Paciente(201, "Luis Fernández", "luis@email.com");
        Paciente paciente2 = new Paciente(202, "Ana Rodríguez", "ana@email.com");
        Paciente paciente3 = new Paciente(203, "Pedro García", "pedro@email.com");

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
