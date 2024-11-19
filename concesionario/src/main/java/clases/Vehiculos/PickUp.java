package clases.Vehiculos;

import clases.Vehiculos.abstractas.Vehiculo;
import clases.Alimentacion.IAlimentacion;    
import clases.Vehiculos.abstractas.TipoCaja;
import clases.Personas.IPersona;

public class PickUp extends Vehiculo {
    private boolean camaraReversa;
    private boolean cuatroXcuadro;
    private int capacidadCargaMaxima;

    public PickUp(int ID,IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, int numeroPasajeros, int numeroPuertas, boolean aireAcondicionado, int cantidadBolsasAire, boolean ABS, boolean camaraReversa, boolean cuatroXcuadro, int capacidadCargaMaxima, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        super(ID,alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, usuarioCompro, precioVehiculo, precioRenta);
        this.camaraReversa = camaraReversa;
        this.cuatroXcuadro = cuatroXcuadro;
        this.capacidadCargaMaxima = capacidadCargaMaxima;
    }

    public boolean isCamaraReversa() {
        return camaraReversa;
    }

    public boolean isCuatroXcuadro() {
        return cuatroXcuadro;
    }

    public int getCapacidadCargaMaxima() {
        return capacidadCargaMaxima;
    }

    
}
