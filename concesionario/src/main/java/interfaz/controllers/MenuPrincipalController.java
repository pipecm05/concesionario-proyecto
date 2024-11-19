package interfaz.controllers;

import java.io.IOException;
import java.util.ArrayList;

import BD.ManejardorDB;
import clases.Personas.IPersona;
import interfaz.App;
import interfaz.Concesionario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class MenuPrincipalController {

    @FXML
    private Label usuarioLabel;

    @FXML
    private Label rolLabel;

    @FXML
    private Button comprarButton;

    @FXML
    private Button cerrar;

    @FXML
    private Button venderButton;

    @FXML
    private Button alquilarButton;

    @FXML
    private Button mostrarButton;

    @FXML
    private ListView<String> clientesListView;

    private ArrayList<IPersona> clientes;

    // Este método se ejecuta al cargar la vista
    public void initialize() {
        try {
            // Verificar si el usuario está correctamente cargado
            if (Concesionario.getInstance().getUser() != null) {
                // Obtener los datos del usuario desde Concesionario.getInstance().getUser()
                String usuario = Concesionario.getInstance().getUser().getNombre();
                String rol = Concesionario.getInstance().getUser().getCedula();

                // Actualiza las etiquetas con los datos del usuario
                usuarioLabel.setText("Usuario: " + usuario);
                rolLabel.setText("Cedula: " + rol);
                iniciarActualizacionAutomatica();
            } else {
                usuarioLabel.setText("Usuario: No disponible");
                rolLabel.setText("Cedula: No disponible");
            }
        } catch (Exception e) {
            System.err.println("Error al inicializar el usuario: " + e.getMessage());
            usuarioLabel.setText("Usuario: Error");
            rolLabel.setText("Cedula: Error");
        }
    }

    // Métodos para manejar los clics de los botones
    @FXML
    private void handleComprar() {
       try {
        App.setRoot("comprar");
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }

    @FXML
    private void handleVender() {
        System.out.println("Botón Vender presionado");
        // Lógica para el botón de vender
    }

    @FXML
    private void handleAlquilar() {
        System.out.println("Botón Alquilar presionado");
        // Lógica para el botón de alquilar
    }

    @FXML
    private void handleMostrar() throws IOException {
        App.setRoot("mostrar_vehiculo");
    }

    @FXML
    void cerrar(ActionEvent event) throws IOException {
        App.setRoot("inicio_sesion");
        Concesionario.getInstance().setUser(null);
    }

    @FXML
    void AgregarCliente(ActionEvent event) throws IOException {
        App.setRoot("agregar_cliente");
    }

    private void iniciarActualizacionAutomatica() {
        // Crear un Timeline que actualice la lista cada 2 segundos
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> actualizarListaClientes()));

        timeline.setCycleCount(Timeline.INDEFINITE); // Repetir indefinidamente
        timeline.play(); // Iniciar el Timeline
    }

    private void actualizarListaClientes() {
        try {
            // Obtener la lista actualizada desde la base de datos
            clientes = ManejardorDB.getInstance().obtenerClientes();

            // Convertir la lista de clientes a un formato observable para el ListView
            ObservableList<String> clientesNombres = FXCollections.observableArrayList();
            for (IPersona cliente : clientes) {
                // Ajusta este formato según los atributos disponibles de IPersona
                clientesNombres.add(cliente.getNombre() + " " + cliente.getApellido());
            }

            // Configurar el ListView con los nombres de los clientes
            clientesListView.setItems(clientesNombres);
        } catch (Exception e) {
            System.err.println("Error al actualizar la lista de clientes: " + e.getMessage());
        }
    }

}
