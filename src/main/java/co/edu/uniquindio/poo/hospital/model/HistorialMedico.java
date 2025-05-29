package co.edu.uniquindio.poo.hospital.model;

import java.util.ArrayList;
import java.util.List;

public class HistorialMedico implements IHistorialMedico {
    private final List<String> registros = new ArrayList<>();

    @Override
    public void agregarRegistro(String registro) {
        registros.add(registro);
    }

    @Override
    public void actualizarRegistro(int indice, String nuevoRegistro) {
        if (indice >= 0 && indice < registros.size()) {
            registros.set(indice, nuevoRegistro);
        }
    }

    @Override
    public List<String> obtenerRegistros() {
        return new ArrayList<>(registros);
    }

    public List<String> getAntecedentes() {
        return obtenerRegistros();
    }

    @Override
    public void actualizarHistorial(String registro) {
        if (!registros.isEmpty()) {
            registros.set(registros.size() - 1, registro);
        } else {
            registros.add(registro);
        }
    }
}