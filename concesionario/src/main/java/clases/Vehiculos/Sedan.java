package clases.Vehiculos;

import clases.Alimentacion.IAlimentacion;
import clases.Vehiculos.abstractas.TipoCaja;
import clases.Vehiculos.abstractas.Vehiculo;
import clases.Personas.IPersona;


public class Sedan extends Vehiculo {
    private int capacidadMaletero;
    private boolean camaraReversa;
    private boolean controlCrucerro;
    private boolean antiColisiones;
    private boolean traficoCruzado;
    private boolean asistentepermanencia;

    public Sedan(int ID,IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, int numeroPasajeros, int numeroPuertas, boolean aireAcondicionado, int cantidadBolsasAire, boolean ABS, int capacidadMaletero, boolean camaraReversa, boolean controlCrucerro, boolean antiColisiones, boolean traficoCruzado, boolean asistentepermanencia, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        super(ID,alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, usuarioCompro, precioVehiculo, precioRenta);
        this.capacidadMaletero = capacidadMaletero;
        this.camaraReversa = camaraReversa;
        this.controlCrucerro = controlCrucerro;
        this.antiColisiones = antiColisiones;
        this.traficoCruzado = traficoCruzado;
        this.asistentepermanencia = asistentepermanencia;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public boolean isCamaraReversa() {
        return camaraReversa;
    }

    public boolean isControlCrucerro() {
        return controlCrucerro;
    }

    public boolean isAntiColisiones() {
        return antiColisiones;
    }

    public boolean isTraficoCruzado() {
        return traficoCruzado;
    }

    public boolean isAssistentepermanencia() {
        return asistentepermanencia;
    }
    
}
