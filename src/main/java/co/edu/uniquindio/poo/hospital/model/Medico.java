package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniquindio.poo.hospital.model.Paciente;
import co.edu.uniquindio.poo.hospital.model.Medico;
import co.edu.uniquindio.poo.hospital.model.CitaMedica;

public class Medico extends Usuario implements IGestionCitas {
    private String especialidad;
    private List<Paciente> pacientes;
    private List<Horario> horariosConsulta;
    private List<String> notificaciones;
    private List<CitaMedica> citas;

    public Medico(int id, String nombre, String email, LocalDate fechaNacimiento, String especialidad, String contrasena) {
        super(id, nombre, email, fechaNacimiento, contrasena);
        this.especialidad = especialidad;
        this.pacientes = new ArrayList<>();
        this.horariosConsulta = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
        this.citas = new ArrayList<>();
    }

    @Override
    public void solicitarCita(CitaMedica cita) {
        citas.add(cita);
    }

    @Override
    public void cancelarCita(CitaMedica cita) {
        citas.remove(cita);
    }
    @Override
    public List<CitaMedica> obtenerCitasProgramadas() {
        return citas;
    }

    @Override
    public void reprogramarCita(CitaMedica cita, String nuevaFechaHora) {
        if (citas.contains(cita)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime nuevaFecha = LocalDateTime.parse(nuevaFechaHora, formatter);
            cita.setFechaHora(nuevaFecha);
            notificaciones.add("Cita reprogramada para el día " + nuevaFechaHora);
        }
    }

    @Override
    public void notificarCambioCita(String mensaje) {
        notificaciones.add("Cambio en cita: " + mensaje);
    }

    public List<CitaMedica> getCitas() {
        return citas;
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<Horario> getHorariosConsulta() {
        return horariosConsulta;
    }

    public void setHorariosConsulta(List<Horario> horariosConsulta) {
        this.horariosConsulta = horariosConsulta;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void registrarDiagnostico(Paciente paciente, String diagnostico) {
        paciente.getHistorial().actualizarHistorial("Diagnóstico: " + diagnostico);
    }

    public void registrarTratamiento(Paciente paciente, String tratamiento) {
        paciente.getHistorial().actualizarHistorial("Tratamiento: " + tratamiento);
    }

    public void asignarHorario(String dia, String hora) {
        horariosConsulta.add(new Horario(dia, hora));
    }

    public String consultarHorario(String dia) {
        for (Horario horario : horariosConsulta) {
            if (horario.getDia().equalsIgnoreCase(dia)) {
                return horario.getHora();
            }
        }
        return "Sin horario asignado";
    }

    public void notificarCambioCita(Paciente paciente, String mensaje) {
        notificaciones.add("Cambio en cita: " + mensaje);
    }

    public void verNotificaciones() {
        if (notificaciones.isEmpty()) {
            System.out.println("No hay notificaciones nuevas.");
        } else {
            System.out.println("Notificaciones:");
            for (String nota : notificaciones) {
                System.out.println("- " + nota);
            }
            notificaciones.clear();
        }
    }
}