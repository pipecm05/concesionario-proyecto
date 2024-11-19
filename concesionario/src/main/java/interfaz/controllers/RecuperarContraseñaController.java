package interfaz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaz.App;

public class RecuperarContraseñaController {

    @FXML
    private TextField cedulaField;

    @FXML
    private TextField respuestaField;

   @FXML
void recuperarContraseña(ActionEvent event) throws IOException {
    String cedula = cedulaField.getText();
    String respuesta = respuestaField.getText();
    
    // Verificamos si los campos no están vacíos
    if (cedula.isEmpty() || respuesta.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Campos Vacíos");
        alert.setHeaderText(null);
        alert.setContentText("Por favor, llena ambos campos.");
        alert.showAndWait();
        App.setRoot("inicio_sesion");
        return;
    }

    // Establecer conexión con la base de datos
    String url = "jdbc:sqlite:src\\main\\java\\BD\\DB.db";
    String query = "SELECT clave FROM usuario WHERE cedula = ? AND pregunta_recuperacion = ?";

    // Realizamos la consulta a la base de datos
    try (Connection conn = DriverManager.getConnection(url);
         PreparedStatement stmt = conn.prepareStatement(query)) {

        // Seteamos los valores de la consulta
        stmt.setString(1, cedula);
        stmt.setString(2, respuesta);

        // Ejecutamos la consulta
        ResultSet rs = stmt.executeQuery();

        // Verificamos si se encuentra un resultado
        if (rs.next()) {
            String clave = rs.getString("clave");
            // Si la contraseña es encontrada
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Contraseña Recuperada");
            alert.setHeaderText(null);
            alert.setContentText("Tu contraseña es: " + clave);
            alert.showAndWait();
            App.setRoot("inicio_sesion");
        } else {
            // Si no se encuentra la cédula o la respuesta es incorrecta
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Cédula o respuesta incorrecta.");
            alert.showAndWait();
            App.setRoot("inicio_sesion");

        }

    } catch (SQLException e) {
        // Manejo de excepciones si ocurre un error en la conexión o consulta
        e.printStackTrace();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error de Conexión");
        alert.setHeaderText(null);
        alert.setContentText("Hubo un problema con la base de datos.");
        alert.showAndWait();
        App.setRoot("inicio_sesion");

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

}
