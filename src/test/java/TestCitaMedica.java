import co.edu.uniquindio.poo.hospital.model.CitaMedica;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

public class TestCitaMedica {

    @Test
    public void testDetallesCita() {
        Medico medico = new Medico(1, "Dr. Pérez", "perez@hospital.com", "Cardiología");
        Paciente paciente = new Paciente(101, "Juan López", "juan@correo.com");

        LocalDateTime fechaCita = LocalDateTime.of(2025, 5, 10, 14, 30);

        CitaMedica cita = new CitaMedica(fechaCita, paciente, medico);

        Assertions.assertEquals(fechaCita, cita.getFechaHora(), "La fecha y hora de la cita deben coincidir.");
        Assertions.assertEquals(paciente, cita.getPaciente(), "El paciente asignado a la cita debe coincidir.");
        Assertions.assertEquals(medico, cita.getMedico(), "El médico asignado a la cita debe coincidir.");

        String esperado = "Cita con el Dr. " + medico.getNombre() + " para " + paciente.getNombre() + " el " + fechaCita.toString();
        Assertions.assertEquals(esperado, cita.detallesCita(), "El formato del detalle de la cita debe ser correcto.");

        System.out.println("Todas las pruebas han pasado correctamente");
    }
}