package co.edu.uniquindio.poo.hospital.model;

import java.util.List;

public interface IGestionCitas {
    void solicitarCita(CitaMedica cita);
    void cancelarCita(CitaMedica cita);
    List<CitaMedica> obtenerCitasProgramadas();
    void reprogramarCita(CitaMedica cita, String nuevaFechaHora);
    void notificarCambioCita(String mensaje);
}