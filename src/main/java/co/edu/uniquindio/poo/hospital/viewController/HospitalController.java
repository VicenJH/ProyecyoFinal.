package co.edu.uniquindio.poo.hospital.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HospitalController {

    @FXML
    private RadioButton radioAdmin;

    @FXML
    private RadioButton radioMedico;

    @FXML
    private RadioButton radioPaciente;

    @FXML
    private TextField userIdField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    private final ToggleGroup roleGroup = new ToggleGroup();

    @FXML
    public void initialize() {
        radioAdmin.setToggleGroup(roleGroup);
        radioMedico.setToggleGroup(roleGroup);
        radioPaciente.setToggleGroup(roleGroup);
    }

    public void handleLogin(ActionEvent event) {
        String userId = userIdField.getText();
        String password = passwordField.getText();

        if (userId.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Por favor, ingrese todos los campos.");
            return;
        }

        if (radioAdmin.isSelected()) {
            // cargarVista("AdminPanel.fxml");
        } else if (radioMedico.isSelected()) {
            // cargarVista("MedicoPanel.fxml");
        } else if (radioPaciente.isSelected()) {
            // cargarVista("PacientePanel.fxml");
        } else {
            showAlert("Error", "Por favor, seleccione un rol.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}