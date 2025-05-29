package co.edu.uniquindio.poo.hospital.model;

import java.util.List;

public interface IHistorialMedico {
    void agregarRegistro(String registro);
    void actualizarRegistro(int indice, String nuevoRegistro);
    List<String> obtenerRegistros();
    void actualizarHistorial(String registro);
}