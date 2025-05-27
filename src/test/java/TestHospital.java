import co.edu.uniquindio.poo.hospital.model.Hospital;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

public class TestHospital {

    @Test
    public void testAgregarMedicoYPaciente() {
        Hospital hospital = new Hospital();
        Medico medico = new Medico(1, "Dr. Pérez", "perez@hospital.com", "Cardiología");
        Paciente paciente = new Paciente(101, "Juan López", "juan@correo.com");

        hospital.agregarMedico(medico);
        hospital.agregarPaciente(paciente);

        List<Medico> medicos = hospital.getMedicos();
        List<Paciente> pacientes = hospital.getPacientes();

        Assertions.assertEquals(1, medicos.size(), "Debe haber 1 médico en el hospital.");
        Assertions.assertEquals(1, pacientes.size(), "Debe haber 1 paciente en el hospital.");
        Assertions.assertEquals(medico, medicos.get(0), "El médico agregado debe coincidir.");
        Assertions.assertEquals(paciente, pacientes.get(0), "El paciente agregado debe coincidir.");
    }

    @Test
    public void testAsignarPacienteAMedico() {
        Hospital hospital = new Hospital();
        Medico medico = new Medico(1, "Dr. Pérez", "perez@hospital.com", "Cardiología");
        Paciente paciente = new Paciente(101, "Juan López", "juan@correo.com");

        hospital.agregarMedico(medico);
        hospital.agregarPaciente(paciente);

        hospital.asignarPacienteAMedico(paciente, medico);

        Assertions.assertTrue(medico.getPacientes().contains(paciente), "El paciente debe estar en la lista del médico.");

        System.out.println("Resumen del hospital:");
        System.out.println("Total de médicos: " + hospital.getMedicos().size());
        System.out.println("Total de pacientes: " + hospital.getPacientes().size());
        System.out.println("Pacientes asignados al Dr. Pérez: " + medico.getPacientes().size());
        System.out.println("Todas las pruebas han pasado correctamente");
    }
}