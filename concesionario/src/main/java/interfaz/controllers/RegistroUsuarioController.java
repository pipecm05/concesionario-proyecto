package interfaz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import BD.ManejardorDB;
import clases.Personas.Usuario;
import interfaz.App;

public class RegistroUsuarioController {

    @FXML
    private TextField txtCedula;

    @FXML
    private Button regresar;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private PasswordField txtContraseña;

    @FXML
    private TextField txtPreguntaRecuperacion;

    // Método que se ejecuta cuando el botón "Registrar" es presionado
    @FXML
    void registrarUsuario(ActionEvent event) {
        // Obtener los datos ingresados por el usuario
        String cedula = txtCedula.getText();
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String contraseña = txtContraseña.getText();
        String preguntaRecuperacion = txtPreguntaRecuperacion.getText();

        // Verificar si algún campo está vacío
        if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || contraseña.isEmpty()
                || preguntaRecuperacion.isEmpty()) {
            mostrarAlerta("Error", "Todos los campos deben ser llenados.");
            return;
        }

        ManejardorDB.getInstance()
                .agregarUsuario(new Usuario(nombre, apellido, cedula, contraseña, preguntaRecuperacion));
        try {
            App.setRoot("inicio_sesion");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Insertar en la base de datos
    }

    @FXML
    void regresar(ActionEvent event) throws IOException {
        App.setRoot("inicio_sesion");
    }

    // Método para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
