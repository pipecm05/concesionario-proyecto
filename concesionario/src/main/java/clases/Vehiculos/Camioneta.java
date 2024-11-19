package clases.Vehiculos;
import clases.Vehiculos.abstractas.Vehiculo;
import clases.Alimentacion.IAlimentacion;    
import clases.Vehiculos.abstractas.TipoCaja;
import clases.Personas.IPersona;

public class Camioneta  extends Vehiculo {
    private int capacidadMaletero;
    private boolean camaraReversa;
    private boolean controlCrucerro;
    private boolean antiColisiones;
    private boolean traficoCruzado;
    private boolean asistentepermanencia;
    private boolean cuatroXcuadro;

    public Camioneta(int ID,IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, int numeroPasajeros, int numeroPuertas, boolean aireAcondicionado, int cantidadBolsasAire, boolean ABS, int capacidadMaletero, boolean camaraReversa, boolean controlCrucerro, boolean antiColisiones, boolean traficoCruzado, boolean asistentepermanencia, boolean cuatroXcuadro, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        super(ID,alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, usuarioCompro, precioVehiculo, precioRenta);
        this.capacidadMaletero = capacidadMaletero;
        this.camaraReversa = camaraReversa;
        this.controlCrucerro = controlCrucerro;
        this.antiColisiones = antiColisiones;
        this.traficoCruzado = traficoCruzado;
        this.asistentepermanencia = asistentepermanencia;
        this.cuatroXcuadro = cuatroXcuadro;
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

    public boolean isCuatroXcuadro() {
        return cuatroXcuadro;
    }
}
