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

    @FXML
    private void handleLogin(ActionEvent event) {
        String userId = userIdField.getText();
        String password = passwordField.getText();

        if (userId.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Por favor, ingrese todos los campos.");
            return;
        }

        if (radioAdmin.isSelected()) {
            cargarVista("/co/edu/uniquindio/poo/hospital/Admin.fxml");
        } else if (radioMedico.isSelected()) {
            cargarVista("/co/edu/uniquindio/poo/hospital/Medico.fxml");
        } else if (radioPaciente.isSelected()) {
            cargarVista("/co/edu/uniquindio/poo/hospital/Paciente.fxml");
        } else {
            showAlert("Error", "Por favor, seleccione un rol.");
        }
    }

    private void cargarVista(String rutaFXML) {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource(rutaFXML));
            javafx.scene.Parent root = loader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) loginButton.getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(root));
        } catch (Exception e) {
            showAlert("Error", "No se pudo cargar la vista: " + e.getMessage());
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