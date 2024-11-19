package interfaz;


import java.util.ArrayList;

import BD.ManejardorDB;
import clases.Personas.IPersona;
import clases.Personas.Usuario;
import clases.Vehiculos.abstractas.IAutoMotor;


public class Concesionario {
    private String nombre;
    private IPersona user;
    private ArrayList<IPersona> clientes;
    private ArrayList<IAutoMotor> vehiculos;
    public static Concesionario instance;

    public static Concesionario getInstance() {
        if (instance == null) {
            instance = new Concesionario();
            instance.nombre = "Tu Carro UQ";
            instance.clientes = ManejardorDB.getInstance().obtenerClientes();
            instance.vehiculos = ManejardorDB.getInstance().obtenerVehiculos();
            instance.mostrarClientes();
            instance.mostrarVehiculos();
        }
        return instance;
    }

    private Concesionario() {
    }

    public String getNombre() {
        return nombre;
    }

    @SuppressWarnings("exports")
    public IPersona getUser() {
        return user;
    }

    public void setUser(IPersona user) {
        this.user = user;
    }

    public void mostrarClientes() {
        for (IPersona cliente : clientes) {
            System.out.println(cliente.getNombre() + " " + cliente.getApellido() + " " + cliente.getCedula());
        }
    }
    public void mostrarVehiculos() {
        for (IAutoMotor vehiculo : vehiculos) {
            System.out.println(vehiculo.getMarca() + " " +  " " + vehiculo.getAlimentacion().getDescripcion());
        }
    }

   
}
