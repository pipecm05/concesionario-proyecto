package interfaz.controllers;

import BD.ManejardorDB;
import clases.Personas.Cliente;
import interfaz.App;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class ClienteController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtVehiculo;
    @FXML
    private Button btnAgregar;

    @FXML
    private void initialize() {
        btnAgregar.setOnAction(event -> agregarCliente());
    }

    private void agregarCliente() {
        try {
            // Capturar datos de los campos
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            String cedula = txtCedula.getText();
            int vehiculo =  0;
            // Crear instancia del cliente
            Cliente cliente = new Cliente(nombre, apellido, cedula);

            // Invocar método de base de datos
            ManejardorDB.getInstance().agregarCliente(cliente);

            System.out.println("Cliente agregado correctamente.");
            App.setRoot("menu_principal");
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
    }
}

