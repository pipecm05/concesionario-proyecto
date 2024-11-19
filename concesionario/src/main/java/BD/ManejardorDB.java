package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import clases.Alimentacion.Combustion;
import clases.Alimentacion.Diesel;
import clases.Alimentacion.Electrico;
import clases.Alimentacion.Gasolina;
import clases.Alimentacion.Hibrido;
import clases.Alimentacion.IAlimentacion;
import clases.Personas.Cliente;
import clases.Personas.IPersona;
import clases.Personas.Usuario;
import clases.Vehiculos.Bus;
import clases.Vehiculos.Camion;
import clases.Vehiculos.Camioneta;
import clases.Vehiculos.Deportivo;
import clases.Vehiculos.Moto;
import clases.Vehiculos.PickUp;
import clases.Vehiculos.Sedan;
import clases.Vehiculos.Van;
import clases.Vehiculos.abstractas.IAutoMotor;
import clases.Vehiculos.abstractas.TipoCaja;

public class ManejardorDB {
    public static ManejardorDB instance;

    public static ManejardorDB getInstance() {
        if (instance == null) {
            instance = new ManejardorDB();
        }
        return instance;
    }

    private Connection getConnection() throws Exception {
        String url = "jdbc:sqlite:concesionario\\src\\main\\java\\BD\\DB.db";
        return DriverManager.getConnection(url);
    }
    public void agregarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, apellido, cedula, clave, pregunta_recuperacion) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCedula());
            ps.setString(4, usuario.getClave());
            ps.setString(5, usuario.getPreguntaRecuoeracion());
            ps.executeUpdate();
            System.out.println("Usuario agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
        }
    }

    public void agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, cedula, vehiculo) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCedula());
            ps.setInt(4, cliente.getID_vehiculo());
            ps.executeUpdate();
            System.out.println("Cliente agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }
    }

    public void agregarBus(Bus bus) {
        String sql = "INSERT INTO bus (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, "
                +
                "numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, capacidadMaletero, camaraReversa, "
                +
                "numeroEjes, numeroSalidasEmergencia, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bus.getAlimentacion().getDescripcion());

            ps.setString(2, bus.getTipoCaja().getDescripcion());
            ps.setString(3, bus.getMarca());
            ps.setString(4, bus.getNuevo_usado());
            ps.setInt(5, bus.getCambios());
            ps.setInt(6, bus.getVelocidadMaxima());
            ps.setInt(7, bus.getCilindrada());
            ps.setInt(8, bus.getNumeroPasajeros());
            ps.setInt(9, bus.getNumeroPuertas());
            ps.setBoolean(10, bus.isAireAcondicionado());
            ps.setInt(11, bus.getCantidadBolsasAire());
            ps.setBoolean(12, bus.isABS());
            ps.setInt(13, bus.getCapacidadMaletero());
            ps.setBoolean(14, bus.isCamaraReversa());
            ps.setInt(15, bus.getNumeroEjes());
            ps.setInt(16, bus.getNumeroSalidasEmergencia());
            ps.setString(17, bus.getUsuarioCompro().getCedula());
            ps.setDouble(18, bus.getPrecioVehiculo());
            ps.setDouble(19, bus.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("Bus agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar bus: " + e.getMessage());
        }
    }

    public void agregarCamion(Camion camion) {
        String sql = "INSERT INTO camion (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, "
                +
                "numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, capacidadCargaMaxima, frenosAire, "
                +
                "numeroEjes, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, camion.getAlimentacion().getDescripcion());

            ps.setString(2, camion.getTipoCaja().getDescripcion());
            ps.setString(3, camion.getMarca());
            ps.setString(4, camion.getNuevo_usado());
            ps.setInt(5, camion.getCambios());
            ps.setInt(6, camion.getVelocidadMaxima());
            ps.setInt(7, camion.getCilindrada());
            ps.setInt(8, camion.getNumeroPasajeros());
            ps.setInt(9, camion.getNumeroPuertas());
            ps.setBoolean(10, camion.isAireAcondicionado());
            ps.setInt(11, camion.getCantidadBolsasAire());
            ps.setBoolean(12, camion.isABS());
            ps.setInt(13, camion.getCapacidadCargaMaxima());
            ps.setBoolean(14, camion.isFrenosAire());
            ps.setInt(15, camion.getNumeroEjes());
            ps.setString(16, camion.getUsuarioCompro().getCedula());
            ps.setDouble(17, camion.getPrecioVehiculo());
            ps.setDouble(18, camion.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("Camion agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar camion: " + e.getMessage());
        }
    }

    public void agregarCamioneta(Camioneta camioneta) {
        String sql = "INSERT INTO camioneta (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, "
                +
                "numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, capacidadMaletero, camaraReversa, "
                +
                "controlCrucerro, antiColisiones, traficoCruzado, asistentepermanencia, cuatroXcuadro, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, camioneta.getAlimentacion().getDescripcion());

            ps.setString(2, camioneta.getTipoCaja().getDescripcion());
            ps.setString(3, camioneta.getMarca());
            ps.setString(4, camioneta.getNuevo_usado());
            ps.setInt(5, camioneta.getCambios());
            ps.setInt(6, camioneta.getVelocidadMaxima());
            ps.setInt(7, camioneta.getCilindrada());
            ps.setInt(8, camioneta.getNumeroPasajeros());
            ps.setInt(9, camioneta.getNumeroPuertas());
            ps.setBoolean(10, camioneta.isAireAcondicionado());
            ps.setInt(11, camioneta.getCantidadBolsasAire());
            ps.setBoolean(12, camioneta.isABS());
            ps.setInt(13, camioneta.getCapacidadMaletero());
            ps.setBoolean(14, camioneta.isCamaraReversa());
            ps.setBoolean(15, camioneta.isControlCrucerro());
            ps.setBoolean(16, camioneta.isAntiColisiones());
            ps.setBoolean(17, camioneta.isTraficoCruzado());
            ps.setBoolean(18, camioneta.isAssistentepermanencia());
            ps.setBoolean(19, camioneta.isCuatroXcuadro());
            ps.setString(20, camioneta.getUsuarioCompro().getCedula());
            ps.setDouble(21, camioneta.getPrecioVehiculo());
            ps.setDouble(22, camioneta.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("Camioneta agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar camioneta: " + e.getMessage());
        }
    }

    public void agregarDeportivo(Deportivo deportivo) {
        String sql = "INSERT INTO deportivo (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, "
                +
                "numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, caballosFuerza, tiempoEnAlcanzar100Km, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, deportivo.getAlimentacion().getDescripcion());

            ps.setString(2, deportivo.getTipoCaja().getDescripcion());
            ps.setString(3, deportivo.getMarca());
            ps.setString(4, deportivo.getNuevo_usado());
            ps.setInt(5, deportivo.getCambios());
            ps.setInt(6, deportivo.getVelocidadMaxima());
            ps.setInt(7, deportivo.getCilindrada());
            ps.setInt(8, deportivo.getNumeroPasajeros());
            ps.setInt(9, deportivo.getNumeroPuertas());
            ps.setBoolean(10, deportivo.isAireAcondicionado());
            ps.setInt(11, deportivo.getCantidadBolsasAire());
            ps.setBoolean(12, deportivo.isABS());
            ps.setInt(13, deportivo.getCaballosFuerza());
            ps.setInt(14, deportivo.getTiempoEnAlcanzar100Km());
            ps.setString(15, deportivo.getUsuarioCompro().getCedula());
            ps.setDouble(16, deportivo.getPrecioVehiculo());
            ps.setDouble(17, deportivo.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("Deportivo agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar deportivo: " + e.getMessage());
        }
    }

    public void agregarMoto(Moto moto) {
        String sql = "INSERT INTO moto (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, moto.getAlimentacion().getDescripcion());

            ps.setString(2, moto.getTipoCaja().getDescripcion());
            ps.setString(3, moto.getMarca());
            ps.setString(4, moto.getNuevo_usado());
            ps.setInt(5, moto.getCambios());
            ps.setInt(6, moto.getVelocidadMaxima());
            ps.setInt(7, moto.getCilindrada());
            ps.setString(8, moto.getUsuarioCompro().getCedula());
            ps.setDouble(9, moto.getPrecioVehiculo());
            ps.setDouble(10, moto.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("Moto agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar moto: " + e.getMessage());
        }
    }

    public void agregarPickUp(PickUp pickUp) {
        String sql = "INSERT INTO pickup (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, "
                +
                "numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, camaraReversa, cuatroXcuadro, capacidadCargaMaxima, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pickUp.getAlimentacion().getDescripcion());

            ps.setString(2, pickUp.getTipoCaja().getDescripcion());
            ps.setString(3, pickUp.getMarca());
            ps.setString(4, pickUp.getNuevo_usado());
            ps.setInt(5, pickUp.getCambios());
            ps.setInt(6, pickUp.getVelocidadMaxima());
            ps.setInt(7, pickUp.getCilindrada());
            ps.setInt(8, pickUp.getNumeroPasajeros());
            ps.setInt(9, pickUp.getNumeroPuertas());
            ps.setBoolean(10, pickUp.isAireAcondicionado());
            ps.setInt(11, pickUp.getCantidadBolsasAire());
            ps.setBoolean(12, pickUp.isABS());
            ps.setBoolean(13, pickUp.isCamaraReversa());
            ps.setBoolean(14, pickUp.isCuatroXcuadro());
            ps.setInt(15, pickUp.getCapacidadCargaMaxima());
            ps.setString(16, pickUp.getUsuarioCompro().getCedula());
            ps.setDouble(17, pickUp.getPrecioVehiculo());
            ps.setDouble(18, pickUp.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("PickUp agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar pickUp: " + e.getMessage());
        }
    }

    public void agregarSedan(Sedan sedan) {
        String sql = "INSERT INTO sedan (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, "
                +
                "numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, capacidadMaletero, camaraReversa, "
                +
                "controlCrucerro, antiColisiones, traficoCruzado, asistentepermanencia, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sedan.getAlimentacion().getDescripcion());
            ps.setString(2, sedan.getTipoCaja().getDescripcion());
            ps.setString(3, sedan.getMarca());
            ps.setString(4, sedan.getNuevo_usado());
            ps.setInt(5, sedan.getCambios());
            ps.setInt(6, sedan.getVelocidadMaxima());
            ps.setInt(7, sedan.getCilindrada());
            ps.setInt(8, sedan.getNumeroPasajeros());
            ps.setInt(9, sedan.getNumeroPuertas());
            ps.setBoolean(10, sedan.isAireAcondicionado());
            ps.setInt(11, sedan.getCantidadBolsasAire());
            ps.setBoolean(12, sedan.isABS());
            ps.setInt(13, sedan.getCapacidadMaletero());
            ps.setBoolean(14, sedan.isCamaraReversa());
            ps.setBoolean(15, sedan.isControlCrucerro());
            ps.setBoolean(16, sedan.isAntiColisiones());
            ps.setBoolean(17, sedan.isTraficoCruzado());
            ps.setBoolean(18, sedan.isAssistentepermanencia());
            ps.setString(19, sedan.getUsuarioCompro().getCedula());
            ps.setDouble(20, sedan.getPrecioVehiculo());
            ps.setDouble(21, sedan.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("Sedan agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar sedan: " + e.getMessage());
        }
    }

    public void agregarVan(Van van) {
        String sql = "INSERT INTO van (alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, "
                +
                "numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, capacidadMaletero, camaraReversa, usuarioCompro, precioVehiculo, precioRenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, van.getAlimentacion().getDescripcion());
            ps.setString(2, van.getTipoCaja().getDescripcion());
            ps.setString(3, van.getMarca());
            ps.setString(4, van.getNuevo_usado());
            ps.setInt(5, van.getCambios());
            ps.setInt(6, van.getVelocidadMaxima());
            ps.setInt(7, van.getCilindrada());
            ps.setInt(8, van.getNumeroPasajeros());
            ps.setInt(9, van.getNumeroPuertas());
            ps.setBoolean(10, van.isAireAcondicionado());
            ps.setInt(11, van.getCantidadBolsasAire());
            ps.setBoolean(12, van.isABS());
            ps.setInt(13, van.getCapacidadMaletero());
            ps.setBoolean(14, van.isCamaraReversa());
            ps.setString(15, van.getUsuarioCompro().getCedula());
            ps.setDouble(16, van.getPrecioVehiculo());
            ps.setDouble(17, van.getPrecioRenta());
            ps.executeUpdate();
            System.out.println("Van agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar van: " + e.getMessage());
        }
    }

    public ArrayList<IPersona> obtenerClientes() {
        ArrayList<IPersona> clientes = new ArrayList<>();
        String url ="jdbc:sqlite:concesionario\\src\\main\\java\\BD\\DB.db";

        String query = "SELECT * FROM cliente";

        try (Connection conexion = DriverManager.getConnection(url);
                PreparedStatement statement = conexion.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String cedula = resultSet.getString("cedula");
                int vehiculo = resultSet.getInt("vehiculo");
                String tipo_vehiculo = resultSet.getString("tipo_vehiculo");

                // Supongamos que tienes un constructor de una clase que implementa IPersona
                IPersona cliente = new Cliente(nombre, apellido, cedula);
                cliente.setID_vehiculo(vehiculo);
                cliente.setTipo_vehiculo(tipo_vehiculo);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public ArrayList<IAutoMotor> obtenerVehiculos() {
        ArrayList<IAutoMotor> vehiculos = new ArrayList<>();

        String[] tablasVehiculos = {
                "bus", "camion", "camioneta", "deportivo", "moto", "pickup", "sedan", "van"
        };

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:sqlite:concesionario\\src\\main\\java\\BD\\DB.db";

        try {
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();

            for (String tabla : tablasVehiculos) {
                String query = "SELECT * FROM " + tabla;
                rs = stmt.executeQuery(query);

                while (rs.next()) {
                    // Inicializar la variable vehiculo a null
                    IAutoMotor vehiculo = null;

                    if (tabla.equals("bus")) {
                        // Crear Bus con el constructor adecuado
                        vehiculo = new Bus(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                rs.getInt("numeroPasajeros"),
                                rs.getInt("numeroPuertas"),
                                rs.getBoolean("aireAcondicionado"),
                                rs.getInt("cantidadBolsasAire"),
                                rs.getBoolean("ABS"),
                                rs.getInt("capacidadMaletero"),
                                rs.getBoolean("camaraReversa"),
                                rs.getInt("numeroEjes"),
                                rs.getInt("numeroSalidasEmergencia"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    } else if (tabla.equals("camion")) {
                        // Crear Camion con el constructor adecuado
                        vehiculo = new Camion(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                rs.getInt("numeroPasajeros"),
                                rs.getInt("numeroPuertas"),
                                rs.getBoolean("aireAcondicionado"),
                                rs.getInt("cantidadBolsasAire"),
                                rs.getBoolean("ABS"),
                                rs.getInt("capacidadCargaMaxima"),
                                rs.getBoolean("frenosAire"),
                                rs.getInt("numeroEjes"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    } else if (tabla.equals("camioneta")) {
                        // Crear Camioneta con el constructor adecuado
                        vehiculo = new Camioneta(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                rs.getInt("numeroPasajeros"),
                                rs.getInt("numeroPuertas"),
                                rs.getBoolean("aireAcondicionado"),
                                rs.getInt("cantidadBolsasAire"),
                                rs.getBoolean("ABS"),
                                rs.getInt("capacidadMaletero"),
                                rs.getBoolean("camaraReversa"),
                                rs.getBoolean("controlCrucerro"),
                                rs.getBoolean("antiColisiones"),
                                rs.getBoolean("traficoCruzado"),
                                rs.getBoolean("asistentepermanencia"),
                                rs.getBoolean("cuatroXcuadro"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    } else if (tabla.equals("deportivo")) {
                        // Crear Deportivo con el constructor adecuado
                        vehiculo = new Deportivo(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                rs.getInt("numeroPasajeros"),
                                rs.getInt("numeroPuertas"),
                                rs.getBoolean("aireAcondicionado"),
                                rs.getInt("cantidadBolsasAire"),
                                rs.getBoolean("ABS"),
                                rs.getInt("caballosFuerza"),
                                rs.getInt("tiempoEnAlcanzar100Km"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    } else if (tabla.equals("moto")) {
                        // Crear Moto con el constructor adecuado
                        vehiculo = new Moto(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    } else if (tabla.equals("pickup")) {
                        // Crear PickUp con el constructor adecuado
                        vehiculo = new PickUp(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                rs.getInt("numeroPasajeros"),
                                rs.getInt("numeroPuertas"),
                                rs.getBoolean("aireAcondicionado"),
                                rs.getInt("cantidadBolsasAire"),
                                rs.getBoolean("ABS"),
                                rs.getBoolean("camaraReversa"),
                                rs.getBoolean("cuatroXcuadro"),
                                rs.getInt("capacidadCargaMaxima"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    } else if (tabla.equals("sedan")) {
                        // Crear Sedan con el constructor adecuado
                        vehiculo = new Sedan(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                rs.getInt("numeroPasajeros"),
                                rs.getInt("numeroPuertas"),
                                rs.getBoolean("aireAcondicionado"),
                                rs.getInt("cantidadBolsasAire"),
                                rs.getBoolean("ABS"),
                                rs.getInt("capacidadMaletero"),
                                rs.getBoolean("camaraReversa"),
                                rs.getBoolean("controlCrucerro"),
                                rs.getBoolean("antiColisiones"),
                                rs.getBoolean("traficoCruzado"),
                                rs.getBoolean("asistentepermanencia"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    } else if (tabla.equals("van")) {
                        // Crear Van con el constructor adecuado
                        vehiculo = new Van(
                                rs.getInt("id"),
                                obtenerAlimentacion(rs.getString("alimentacion")),
                                obtenerTipoCaja(rs.getString("tipoCaja")),
                                rs.getString("marca"),
                                rs.getString("nuevo_usado"),
                                rs.getInt("cambios"),
                                rs.getInt("velocidadMaxima"),
                                rs.getInt("cilindrada"),
                                rs.getInt("numeroPasajeros"),
                                rs.getInt("numeroPuertas"),
                                rs.getBoolean("aireAcondicionado"),
                                rs.getInt("cantidadBolsasAire"),
                                rs.getBoolean("ABS"),
                                rs.getInt("capacidadMaletero"),
                                rs.getBoolean("camaraReversa"),
                                obtenerPersona(rs.getString("usuarioCompro")),
                                rs.getDouble("precioVehiculo"),
                                rs.getDouble("precioRenta"));
                    }

                    // Agregar el vehículo a la lista si no es nulo
                    if (vehiculo != null) {
                        vehiculos.add(vehiculo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vehiculos;
    }

    private IAlimentacion obtenerAlimentacion(String descripcion) {
        IAlimentacion alimentacion = null;

        if (descripcion.equals("Gasolina")) {
            alimentacion = new Gasolina(10, "Gasolina");
        } else if (descripcion.equals("Diesel")) {
            alimentacion = new Diesel(10, "Diesel");
        } else if (descripcion.equals("Electrico")) {
            alimentacion = new Electrico(10, 10, "Electrico");
        } else if (descripcion.equals("Hibrido")) {
            alimentacion = new Hibrido(true, "Hibrido");
        }

        return alimentacion;
    }

    private TipoCaja obtenerTipoCaja(String tipo) {
        TipoCaja tipoCaja = null;
        if (tipo.equals("Mecanica")) {
            tipoCaja = TipoCaja.Mecanica;
        } else if (tipo.equals("Automatica")) {
            tipoCaja = TipoCaja.Automatica;
        }
        return tipoCaja;

    }

    private IPersona obtenerPersona(String cedula) {
        IPersona usuario = null;

        // Conexión a la base de datos
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
          
            conn = DriverManager.getConnection("jdbc:sqlite:concesionario\\src\\main\\java\\BD\\DB.db");

            // Consulta SQL para buscar al usuario por cédula
            String query = "SELECT * FROM usuario WHERE cedula = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, cedula);

            // Ejecuta la consulta
            rs = stmt.executeQuery();

            // Si encontramos un usuario con la cédula proporcionada
            if (rs.next()) {
                // Crea un nuevo objeto Usuario (o clase que implemente IPersona)
                usuario = new Usuario(
                        rs.getString("nombre"), // Nombre del usuario
                        rs.getString("apellido"), // Apellido del usuario
                        rs.getString("cedula"), // Cédula del usuario
                        rs.getString("clave"), // Clave del usuario
                        rs.getString("pregunta_recuperacion") // Pregunta de recuperación
                );
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (stmt != null)
                    stmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Si no se encontró el usuario, lanzamos una excepción
        if (usuario == null) {
            throw new IllegalArgumentException("Persona con cédula " + cedula + " no encontrada.");
        }

        return usuario;
    }

}
