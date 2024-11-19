package BD;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

public class createBD {
        public static createBD instance;

        public static createBD getInstance() {
                if (instance == null) {
                        instance = new createBD();
                }
                return instance;
        }

        public void crear() {

                String tablaUsuario = "CREATE TABLE IF NOT EXISTS usuario (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"nombre\" TEXT NOT NULL,\r\n" +
                                "\t\"apellido\" TEXT NOT NULL,\r\n" +
                                "\t\"cedula\" TEXT NOT NULL UNIQUE,\r\n" +
                                "\t\"clave\" TEXT NOT NULL,\r\n" +
                                "\t\"pregunta_recuperacion\" TEXT NOT NULL\r\n" +
                                ");";

                String tablaCliente = "CREATE TABLE IF NOT EXISTS cliente (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"nombre\" TEXT NOT NULL,\r\n" +
                                "\t\"apellido\" TEXT NOT NULL,\r\n" +
                                "\t\"cedula\" TEXT NOT NULL UNIQUE,\r\n" +
                                "\t\"vehiculo\" INTEGER , \r\n" +
                                "\t\"tipo_vehiculo\" TEXT\r\n" +
                                ");";

                String tablaBus = "CREATE TABLE IF NOT EXISTS bus (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPasajeros\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPuertas\" INTEGER NOT NULL,\r\n" +
                                "\t\"aireAcondicionado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cantidadBolsasAire\" INTEGER NOT NULL,\r\n" +
                                "\t\"ABS\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"capacidadMaletero\" INTEGER NOT NULL,\r\n" +
                                "\t\"camaraReversa\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"numeroEjes\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroSalidasEmergencia\" INTEGER NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";

                String tablaCamion = "CREATE TABLE IF NOT EXISTS camion (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPasajeros\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPuertas\" INTEGER NOT NULL,\r\n" +
                                "\t\"aireAcondicionado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cantidadBolsasAire\" INTEGER NOT NULL,\r\n" +
                                "\t\"ABS\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"capacidadCargaMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"frenosAire\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"numeroEjes\" INTEGER NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";

                String tablaCamioneta = "CREATE TABLE IF NOT EXISTS camioneta (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPasajeros\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPuertas\" INTEGER NOT NULL,\r\n" +
                                "\t\"aireAcondicionado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cantidadBolsasAire\" INTEGER NOT NULL,\r\n" +
                                "\t\"ABS\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"capacidadMaletero\" INTEGER NOT NULL,\r\n" +
                                "\t\"camaraReversa\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"controlCrucerro\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"antiColisiones\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"traficoCruzado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"asistentePermanencia\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cuatroXcuadro\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";

                String tablaDeportivo = "CREATE TABLE IF NOT EXISTS deportivo (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPasajeros\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPuertas\" INTEGER NOT NULL,\r\n" +
                                "\t\"aireAcondicionado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cantidadBolsasAire\" INTEGER NOT NULL,\r\n" +
                                "\t\"ABS\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"caballosFuerza\" INTEGER NOT NULL,\r\n" +
                                "\t\"tiempoEnAlcanzar100Km\" INTEGER NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";

                String tablaMoto = "CREATE TABLE IF NOT EXISTS moto (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";

                String tablaPickUp = "CREATE TABLE IF NOT EXISTS pickup (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPasajeros\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPuertas\" INTEGER NOT NULL,\r\n" +
                                "\t\"aireAcondicionado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cantidadBolsasAire\" INTEGER NOT NULL,\r\n" +
                                "\t\"ABS\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"camaraReversa\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cuatroXcuadro\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"capacidadCargaMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";
                String tablaSedan = "CREATE TABLE IF NOT EXISTS sedan (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPasajeros\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPuertas\" INTEGER NOT NULL,\r\n" +
                                "\t\"aireAcondicionado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cantidadBolsasAire\" INTEGER NOT NULL,\r\n" +
                                "\t\"ABS\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"capacidadMaletero\" INTEGER NOT NULL,\r\n" +
                                "\t\"camaraReversa\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"controlCrucerro\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"antiColisiones\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"traficoCruzado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"asistentepermanencia\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";
                String tablaVan = "CREATE TABLE IF NOT EXISTS van (\r\n"
                                + "\t\"id\" INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                "\t\"alimentacion\" TEXT NOT NULL,\r\n" +
                                "\t\"tipoCaja\" TEXT NOT NULL,\r\n" +
                                "\t\"marca\" TEXT NOT NULL,\r\n" +
                                "\t\"nuevo_usado\" TEXT NOT NULL,\r\n" +
                                "\t\"cambios\" INTEGER NOT NULL,\r\n" +
                                "\t\"velocidadMaxima\" INTEGER NOT NULL,\r\n" +
                                "\t\"cilindrada\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPasajeros\" INTEGER NOT NULL,\r\n" +
                                "\t\"numeroPuertas\" INTEGER NOT NULL,\r\n" +
                                "\t\"aireAcondicionado\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"cantidadBolsasAire\" INTEGER NOT NULL,\r\n" +
                                "\t\"ABS\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"capacidadMaletero\" INTEGER NOT NULL,\r\n" +
                                "\t\"camaraReversa\" BOOLEAN NOT NULL,\r\n" +
                                "\t\"usuarioCompro\" TEXT NOT NULL,\r\n" +
                                "\t\"precioVehiculo\" REAL NOT NULL,\r\n" +
                                "\t\"precioRenta\" REAL NOT NULL\r\n" +
                                ");";

                String url = "jdbc:sqlite:concesionario\\src\\main\\java\\BD\\DB.db";
        

                try (Connection con = DriverManager.getConnection(url)) {
                        Statement st = con.createStatement();

                        st.executeUpdate(tablaUsuario);
                        st.executeUpdate(tablaCliente);
                        st.executeUpdate(tablaBus);
                        st.executeUpdate(tablaCamion);
                        st.executeUpdate(tablaCamioneta);
                        st.executeUpdate(tablaDeportivo);
                        st.executeUpdate(tablaMoto);
                        st.executeUpdate(tablaPickUp);
                        st.executeUpdate(tablaSedan);
                        st.executeUpdate(tablaVan);
                        System.out.println("La base de datos se creo correctamente");

                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}
