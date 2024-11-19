package clases.Vehiculos.abstractas;

import clases.Alimentacion.IAlimentacion;
import clases.Personas.IPersona;

public abstract class Vehiculo extends AutoMotor {
    protected int numeroPasajeros;
    protected int numeroPuertas;
    protected boolean aireAcondicionado;
    protected int cantidadBolsasAire;
    protected boolean ABS;

    public Vehiculo(int ID,IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, int numeroPasajeros, int numeroPuertas, boolean aireAcondicionado, int cantidadBolsasAire, boolean ABS, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        super(ID,alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, usuarioCompro, precioVehiculo, precioRenta);
        this.numeroPasajeros = numeroPasajeros;
        this.numeroPuertas = numeroPuertas;
        this.aireAcondicionado = aireAcondicionado;
        this.cantidadBolsasAire = cantidadBolsasAire;
        this.ABS = ABS;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public int getCantidadBolsasAire() {
        return cantidadBolsasAire;
    }

    public boolean isABS() {
        return ABS;
    }

    
    
}
