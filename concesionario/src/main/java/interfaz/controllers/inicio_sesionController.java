package interfaz.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import BD.ManejardorDB;
import clases.Personas.IPersona;
import clases.Personas.Usuario;
import interfaz.App;
import interfaz.Concesionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class inicio_sesionController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnIngresar;

    @FXML
    private Button btnRecuperarContraseña;

    @FXML
    private Button btnRegresar;

    @FXML
    private PasswordField txtconstraseña;

    @FXML
    private TextField txtusuario;

    @FXML
    void ingresar(ActionEvent event) {
        // Obtener los valores de los campos de usuario y contraseña
        String usuarioInput = txtusuario.getText();
        String contraseñaInput = txtconstraseña.getText();

        // Verificar si los campos están vacíos
        if (usuarioInput.isEmpty() || contraseñaInput.isEmpty()) {
            // Mostrar mensaje de error o advertencia si algún campo está vacío
            System.out.println("Por favor ingrese ambos campos.");
            return;
        }
        String url = "jdbc:sqlite:src\\main\\java\\BD\\DB.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            // Consulta SQL para verificar si el usuario y la contraseña coinciden
            String query = "SELECT * FROM usuario WHERE cedula = ? AND clave = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, usuarioInput); // Establecer el valor del usuario (cedula)
            stmt.setString(2, contraseñaInput); // Establecer el valor de la contraseña

            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();

            // Si el resultado tiene datos, es que el usuario y la contraseña son correctos
            if (rs.next()) {
                System.out.println(usuarioInput);
                Concesionario.getInstance().setUser(obtenerUsuario(usuarioInput));
                System.out.println(obtenerUsuario(usuarioInput).toString());
                App.setRoot("menu_principal");
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
                // Opcional: Mostrar un mensaje al usuario indicando que las credenciales son
                // incorrectas
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Opcional: Manejar errores de la base de datos, como problemas de conexión.
        } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
    }

    public IPersona obtenerUsuario(String cedula) {
        IPersona usuario = null;
        String url = "jdbc:sqlite:src\\main\\java\\BD\\DB.db";
        String query = "SELECT * FROM usuario WHERE cedula = ?";
        
        try (Connection conn = DriverManager.getConnection(url); // Conexión a la base de datos
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cedula); // Establece la cedula en la consulta SQL
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // Si se encuentra un resultado, se crea el objeto Usuario
                usuario = new Usuario(
                        
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("cedula"),
                        rs.getString("clave"),
                        rs.getString("pregunta_recuperacion")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Imprime el error en caso de que falle la conexión o la consulta
        }

        return usuario; // Retorna el Usuario, o null si no se encuentra
    }


    @FXML
    void recuperarContraseña(ActionEvent event) {
        try {
            App.setRoot("recuperar_contraseña");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void registrar() {
        try {
            App.setRoot("registro_usuario");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert btnIngresar != null
                : "fx:id=\"btnIngresar\" was not injected: check your FXML file 'inicio_sesion.fxml'.";
        assert btnRecuperarContraseña != null
                : "fx:id=\"btnRecuperarContraseña\" was not injected: check your FXML file 'inicio_sesion.fxml'.";
        assert btnRegresar != null
                : "fx:id=\"btnRegresar\" was not injected: check your FXML file 'inicio_sesion.fxml'.";
        assert txtconstraseña != null
                : "fx:id=\"txtconstraseña\" was not injected: check your FXML file 'inicio_sesion.fxml'.";
        assert txtusuario != null : "fx:id=\"txtusuario\" was not injected: check your FXML file 'inicio_sesion.fxml'.";

    }

}
