package interfaz.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import BD.ManejardorDB;
import clases.Vehiculos.abstractas.IAutoMotor;
import interfaz.App;

public class MostrarController {

    @FXML
    private ListView<String> listViewVehiculos;

    public void initialize() {
        // Obtener los vehículos desde la base de datos
        ArrayList<IAutoMotor> vehiculos = ManejardorDB.getInstance().obtenerVehiculos();

        // Crear una lista para almacenar las representaciones en cadena
        ArrayList<String> vehiculosStrings = new ArrayList<>();

        // Convertir cada IAutoMotor a String y agregarlo a la lista
        for (IAutoMotor iAutoMotor : vehiculos) {
            vehiculosStrings.add(iAutoMotor.toString());
        }

        // Cargar los vehículos convertidos a String en el ListView
        listViewVehiculos.getItems().setAll(vehiculosStrings);
    }

    @FXML
    void regresar(ActionEvent event) throws IOException {
        App.setRoot("menu_principal");
    }

}
