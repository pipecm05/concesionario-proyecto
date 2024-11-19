package clases.Vehiculos;

import clases.Alimentacion.IAlimentacion;
import clases.Vehiculos.abstractas.AutoMotor;
import clases.Vehiculos.abstractas.TipoCaja;
import clases.Personas.IPersona;

public class Moto extends AutoMotor {

    public Moto(int ID,IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        super(ID,alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, usuarioCompro, precioVehiculo, precioRenta);
    }
    
}
