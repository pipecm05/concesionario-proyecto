package clases.Vehiculos.abstractas;

import clases.Alimentacion.IAlimentacion;
import clases.Personas.IPersona;

public abstract class AutoMotor implements IAutoMotor {
    private int ID;
    private IAlimentacion alimentacion;
    private double precioVehiculo;
    private double precioRenta;
    private TipoCaja tipoCaja;
    private String marca;
    private String nuevo_usado;
    private int cambios;
    private int velocidadMaxima;
    private int cilindrada;
    private IPersona usuarioCompro;

    public AutoMotor(int ID, IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        this.ID = ID;
        this.alimentacion = alimentacion;
        this.tipoCaja = tipoCaja;
        this.marca = marca;
        this.nuevo_usado = nuevo_usado;
        this.cambios = cambios;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindrada = cilindrada;
        this.usuarioCompro = usuarioCompro;
        this.precioVehiculo = precioVehiculo;
        this.precioRenta = precioRenta;
    }

    public IAlimentacion getAlimentacion() {
        return alimentacion;
    }

    public TipoCaja getTipoCaja() {
        return tipoCaja;
    }

    public String getMarca() {
        return marca;
    }

    public String getNuevo_usado() {
        return nuevo_usado;
    }

    public int getCambios() {
        return cambios;
    }

    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public int getCilindrada() {
        return cilindrada;
    }  
    
    public IPersona getUsuarioCompro() {
        return usuarioCompro;
    }           

    public double getPrecioVehiculo() {
        return precioVehiculo;
    }

    public double getPrecioRenta() {
        return precioRenta;
    }
    public int getID() {
        return ID;
    }

}
