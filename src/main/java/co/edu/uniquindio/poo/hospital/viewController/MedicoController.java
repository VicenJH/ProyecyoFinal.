package co.edu.uniquindio.poo.hospital.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import co.edu.uniquindio.poo.hospital.model.Horario;
public class MedicoController {

    @FXML
    private ComboBox<Paciente> comboPacientes;

    @FXML
    private TextField txtDiagnostico, txtTratamiento, txtDia, txtHora;

    @FXML
    private ListView<String> listHorarios, listNotificaciones;

    private Medico medico;  // Este se debe pasar desde la pantalla anterior

    @FXML
    public void initialize() {
        // Solo se inicializa la vista. El médico debe asignarse externamente.
    }

    public void setMedico(Medico medico) {
        this.medico = medico;

        ObservableList<Paciente> pacientes = FXCollections.observableArrayList(medico.getPacientes());
        comboPacientes.setItems(pacientes);

        actualizarHorarios();
    }

    public void registrarDiagnostico() {
        Paciente p = comboPacientes.getValue();
        String diag = txtDiagnostico.getText();

        if (p != null && !diag.isEmpty()) {
            medico.registrarDiagnostico(p, diag);
            mostrarMensaje("Diagnóstico registrado.");
            txtDiagnostico.clear();
        } else {
            mostrarMensaje("Seleccione un paciente y escriba el diagnóstico.");
        }
    }

    public void registrarTratamiento() {
        Paciente p = comboPacientes.getValue();
        String trat = txtTratamiento.getText();

        if (p != null && !trat.isEmpty()) {
            medico.registrarTratamiento(p, trat);
            mostrarMensaje("Tratamiento registrado.");
            txtTratamiento.clear();
        } else {
            mostrarMensaje("Seleccione un paciente y escriba el tratamiento.");
        }
    }

    public void asignarHorario() {
        String dia = txtDia.getText();
        String hora = txtHora.getText();

        if (!dia.isEmpty() && !hora.isEmpty()) {
            medico.asignarHorario(dia, hora);
            actualizarHorarios();
            txtDia.clear();
            txtHora.clear();
            mostrarMensaje("Horario asignado.");
        } else {
            mostrarMensaje("Ingrese día y hora.");
        }
    }

    public void actualizarHorarios() {
        ObservableList<String> lista = FXCollections.observableArrayList();
        for (Horario h : medico.getHorariosConsulta()) {
            lista.add(h.getDia() + " - " + h.getHora());
        }
        listHorarios.setItems(lista);
    }

    public void verNotificaciones() {
        ObservableList<String> lista = FXCollections.observableArrayList(medico.getNotificaciones());
        listNotificaciones.setItems(lista);
        medico.getNotificaciones().clear();
    }

    private void mostrarMensaje(String texto) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(texto);
        alert.showAndWait();
    }
}