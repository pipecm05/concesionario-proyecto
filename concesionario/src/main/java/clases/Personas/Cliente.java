package clases.Personas;

import clases.Vehiculos.abstractas.AutoMotor;

public class Cliente extends Persona {
    private int ID_vehiculo;
    private String Tipo_Vehiculo;

    public Cliente(String nombre, String apellido, String cedula) {
        super(nombre, apellido, cedula);
        
    }

    public int getID_vehiculo() {
        return ID_vehiculo;
    }

    public void setID_vehiculo(int ID_vehiculo) {
        this.ID_vehiculo = ID_vehiculo;
        
    }
    
    public void setTipo_vehiculo(String Tipo_Vehiculo) {
        this.Tipo_Vehiculo = Tipo_Vehiculo;
    }
    

}
