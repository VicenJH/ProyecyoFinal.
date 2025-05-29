package co.edu.uniquindio.poo.hospital.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario implements IGestionCitas {

    private List<CitaMedica> citasProgramadas;
    private List<String> notificaciones;
    private IHistorialMedico historial;

    public Paciente(int id, String nombre, String email, LocalDate fechaNacimiento, String contrasena) {
        super(id, nombre, email, fechaNacimiento, contrasena);
        this.historial = new HistorialMedico();
        this.citasProgramadas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    @Override
    public void solicitarCita(CitaMedica cita) {
        citasProgramadas.add(cita);
        notificaciones.add("Cita médica programada para el día " + cita.getFechaHora());
    }

    @Override
    public void cancelarCita(CitaMedica cita) {
        if (citasProgramadas.remove(cita)) {
            notificaciones.add("La cita médica para el día " + cita.getFechaHora() + " ha sido cancelada.");
        }
    }
    @Override
    public List<CitaMedica> obtenerCitasProgramadas() {
        return citasProgramadas;
    }

    @Override
    public void reprogramarCita(CitaMedica cita, String nuevaFechaHora) {
        if (citasProgramadas.contains(cita)) {
            LocalDateTime nuevaFecha = LocalDateTime.parse(nuevaFechaHora, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            cita.setFechaHora(nuevaFecha);
            notificaciones.add("Cita reprogramada para el día " + nuevaFechaHora);
        }
    }

    @Override
    public void notificarCambioCita(String mensaje) {
        notificaciones.add("Cambio en cita: " + mensaje);
    }
    public void actualizarDatos(String nuevoNombre, String nuevoEmail) {
        setNombre(nuevoNombre);
        setEmail(nuevoEmail);
    }

    public IHistorialMedico getHistorial() {
        return historial;
    }

    public void setHistorial(IHistorialMedico historial) {
        this.historial = historial;
    }

    public List<CitaMedica> getCitasProgramadas() {
        return citasProgramadas;
    }

    public void setCitasProgramadas(List<CitaMedica> citasProgramadas) {
        this.citasProgramadas = citasProgramadas;
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void notificarCita(String mensaje) {
        notificaciones.add("Notificación de cita: " + mensaje);
    }

    public void verNotificaciones() {
        if (notificaciones.isEmpty()) {
            System.out.println("No tienes notificaciones nuevas.");
        } else {
            System.out.println("Tus notificaciones:");
            for (String nota : notificaciones) {
                System.out.println("- " + nota);
            }
            notificaciones.clear();
        }
    }
}