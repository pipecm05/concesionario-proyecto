package interfaz.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

import BD.ManejardorDB;
import clases.Alimentacion.Diesel;
import clases.Alimentacion.Electrico;
import clases.Alimentacion.Gasolina;
import clases.Alimentacion.Hibrido;
import clases.Alimentacion.IAlimentacion;
import clases.Personas.IPersona;
import clases.Vehiculos.Bus;
import clases.Vehiculos.Van;
import clases.Vehiculos.abstractas.IAutoMotor;
import clases.Vehiculos.abstractas.TipoCaja;
import interfaz.App;
import interfaz.Concesionario;
import javafx.event.ActionEvent;

public class VehicleController {

    // FXML de Bus
    @FXML
    private TextField txtID, txtMarca, txtNuevoUsado, txtCambios, txtVelocidadMaxima, txtCilindrada,
            txtNumeroPasajeros, txtNumeroPuertas, txtCantidadBolsasAire, txtCapacidadMaletero,
            txtNumeroEjes, txtNumeroSalidasEmergencia, txtPrecioVehiculo, txtPrecioRenta;

    @FXML
    private CheckBox chkAireAcondicionado, chkABS, chkCamaraReversa;
    @FXML
    private Button btnGuardarBus;

    // FXML de Van
    @FXML
    private TextField txtIDVan, txtMarcaVan, txtNuevoUsadoVan, txtCambiosVan, txtVelocidadMaximaVan,
            txtCilindradaVan, txtNumeroPasajerosVan, txtNumeroPuertasVan, txtCantidadBolsasAireVan,
            txtCapacidadMaleteroVan, txtPrecioVehiculoVan, txtPrecioRentaVan;

    @FXML
    private CheckBox chkAireAcondicionadoVan, chkABSVan, chkCamaraReversaVan;
    @FXML
    private Button btnGuardarVan;

    @FXML
    private ComboBox<String> cmbAlimentacion;
    @FXML
    private ComboBox<String> cmbTipoCaja;

    @FXML
    private ComboBox<String> cmbAlimentacionSedan;
    @FXML
    private ComboBox<String> cmbTipoCajaSedan;

    @FXML
    private ComboBox<String> cmbAlimentacionVan;
    @FXML
    private ComboBox<String> cmbTipoCajaVan;

    private IAlimentacion alimentacionSeleccionada;
    private TipoCaja tipoCajaSeleccionado;
    private IAlimentacion alimentacionSeleccionadaVan;
    private TipoCaja tipoCajaSeleccionadoVan;

    // Métodos de acción
    @FXML
    private void handleGuardarBus(ActionEvent event) {
        // Recoger datos del formulario de Bus
        int id = Integer.parseInt(txtID.getText());
        String marca = txtMarca.getText();
        String nuevoUsado = txtNuevoUsado.getText();
        int cambios = Integer.parseInt(txtCambios.getText());
        int velocidadMaxima = Integer.parseInt(txtVelocidadMaxima.getText());
        int cilindrada = Integer.parseInt(txtCilindrada.getText());
        int numeroPasajeros = Integer.parseInt(txtNumeroPasajeros.getText());
        int numeroPuertas = Integer.parseInt(txtNumeroPuertas.getText());
        boolean aireAcondicionado = chkAireAcondicionado.isSelected();
        int cantidadBolsasAire = Integer.parseInt(txtCantidadBolsasAire.getText());
        boolean ABS = chkABS.isSelected();
        int capacidadMaletero = Integer.parseInt(txtCapacidadMaletero.getText());
        boolean camaraReversa = chkCamaraReversa.isSelected();
        int numeroEjes = Integer.parseInt(txtNumeroEjes.getText());
        int numeroSalidasEmergencia = Integer.parseInt(txtNumeroSalidasEmergencia.getText());
        double precioVehiculo = Double.parseDouble(txtPrecioVehiculo.getText());
        double precioRenta = Double.parseDouble(txtPrecioRenta.getText());
        IPersona usuario = Concesionario.getInstance().getUser();

        // Crear Bus
        Bus bus = new Bus(id, alimentacionSeleccionada, tipoCajaSeleccionado, marca, nuevoUsado, cambios,
                velocidadMaxima, cilindrada, numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS,
                capacidadMaletero, camaraReversa, numeroEjes, numeroSalidasEmergencia, usuario, precioVehiculo,
                precioRenta);
        ManejardorDB.getInstance().agregarBus(bus);
        System.out.println("Datos del Bus guardados: " + bus);
        try {
            App.setRoot("menu_principal");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    private void handleGuardarVan(ActionEvent event) {
        // Recoger datos del formulario de Van
        int id = Integer.parseInt(txtIDVan.getText());
        String marca = txtMarcaVan.getText();
        String nuevoUsado = txtNuevoUsadoVan.getText();
        int cambios = Integer.parseInt(txtCambiosVan.getText());
        int velocidadMaxima = Integer.parseInt(txtVelocidadMaximaVan.getText());
        int cilindrada = Integer.parseInt(txtCilindradaVan.getText());
        int numeroPasajeros = Integer.parseInt(txtNumeroPasajerosVan.getText());
        int numeroPuertas = Integer.parseInt(txtNumeroPuertasVan.getText());
        boolean aireAcondicionado = chkAireAcondicionadoVan.isSelected();
        int cantidadBolsasAire = Integer.parseInt(txtCantidadBolsasAireVan.getText());
        boolean ABS = chkABSVan.isSelected();
        int capacidadMaletero = Integer.parseInt(txtCapacidadMaleteroVan.getText());
        boolean camaraReversa = chkCamaraReversaVan.isSelected();
        double precioVehiculo = Double.parseDouble(txtPrecioVehiculoVan.getText());
        double precioRenta = Double.parseDouble(txtPrecioRentaVan.getText());
        IPersona usuario = Concesionario.getInstance().getUser();

        // Crear Van
        Van van = new Van(id, alimentacionSeleccionadaVan, tipoCajaSeleccionadoVan, marca, nuevoUsado, cambios,
                velocidadMaxima, cilindrada, numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS,
                capacidadMaletero, camaraReversa, usuario, precioVehiculo, precioRenta);
        System.out.println(van.getAlimentacion().getDescripcion());
        ManejardorDB.getInstance().agregarVan(van);
        System.out.println("Datos de la Van guardados: " + van);
        try {
            App.setRoot("menu_principal");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        // Inicialización de ComboBox para Alimentación
        cmbAlimentacion.getItems().addAll("Diesel", "Gasolina", "Electrico", "Hibrido");
        cmbAlimentacionSedan.getItems().addAll("Diesel", "Gasolina", "Electrico", "Hibrido");
        cmbAlimentacionVan.getItems().addAll("Diesel", "Gasolina", "Electrico", "Hibrido");

        // Inicialización de ComboBox para Tipo de Caja
        cmbTipoCaja.getItems().addAll("Mecanica", "Automatica");
        cmbTipoCajaSedan.getItems().addAll("Mecanica", "Automatica");
        cmbTipoCajaVan.getItems().addAll("Mecanica", "Automatica");

        // Listener para el ComboBox de Alimentación
        cmbAlimentacion.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Diesel":
                    alimentacionSeleccionada = new Diesel(60, "Diesel");
                    break;
                case "Gasolina":
                    alimentacionSeleccionada = new Gasolina(50, "Gasolina");
                    break;
                case "Electrico":
                    alimentacionSeleccionada = new Electrico(350, 6, "Electrico");
                    break;
                case "Hibrido":
                    alimentacionSeleccionada = new Hibrido(true, "Hibrido");
                    break;
                default:
                    alimentacionSeleccionada = null;
                    break;
            }
        });
        cmbAlimentacionVan.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Diesel":
                    alimentacionSeleccionadaVan = new Diesel(60, "Diesel");
                    break;
                case "Gasolina":
                    alimentacionSeleccionadaVan = new Gasolina(50, "Gasolina");
                    break;
                case "Electrico":
                    alimentacionSeleccionadaVan = new Electrico(350, 6, "Electrico");
                    break;
                case "Hibrido":
                    alimentacionSeleccionadaVan = new Hibrido(true, "Hibrido");
                    break;
                default:
                    alimentacionSeleccionadaVan = null;
                    break;
            }
        });

        // Listener para el ComboBox de Tipo de Caja
        cmbTipoCaja.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Mecanica":
                    tipoCajaSeleccionado = TipoCaja.Mecanica;
                    break;
                case "Automatica":
                    tipoCajaSeleccionado = TipoCaja.Automatica;
                    break;
                default:
                    tipoCajaSeleccionado = null;
                    break;
            }
        });
        cmbTipoCajaVan.valueProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Mecanica":
                    tipoCajaSeleccionadoVan = TipoCaja.Mecanica;
                    break;
                case "Automatica":
                    tipoCajaSeleccionadoVan = TipoCaja.Automatica;
                    break;
                default:
                    tipoCajaSeleccionadoVan = null;
                    break;
            }
        });
    }
}
