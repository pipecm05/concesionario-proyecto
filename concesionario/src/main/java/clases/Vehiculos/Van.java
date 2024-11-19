package clases.Vehiculos;
import clases.Vehiculos.abstractas.Vehiculo;
import clases.Alimentacion.IAlimentacion;    
import clases.Vehiculos.abstractas.TipoCaja;
import clases.Personas.IPersona;


public class Van extends Vehiculo {
    private int capacidadMaletero;
    private boolean camaraReversa;

    public Van(int ID,IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, int numeroPasajeros, int numeroPuertas, boolean aireAcondicionado, int cantidadBolsasAire, boolean ABS, int capacidadMaletero, boolean camaraReversa, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        super(ID,alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, usuarioCompro, precioVehiculo, precioRenta);
        this.capacidadMaletero = capacidadMaletero;
        this.camaraReversa = camaraReversa;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public boolean isCamaraReversa() {
        return camaraReversa;
    }

    @Override
    public String toString() {
        return "Van [numeroPasajeros=" + numeroPasajeros + ", numeroPuertas=" + numeroPuertas + ", capacidadMaletero="
                + capacidadMaletero + ", aireAcondicionado=" + aireAcondicionado + ", camaraReversa=" + camaraReversa
                + ", cantidadBolsasAire=" + cantidadBolsasAire + ", ABS=" + ABS + ", getCapacidadMaletero()="
                + getCapacidadMaletero() + ", getNumeroPasajeros()=" + getNumeroPasajeros() + ", isCamaraReversa()="
                + isCamaraReversa() + ", getNumeroPuertas()=" + getNumeroPuertas() + ", getAlimentacion()="
                + getAlimentacion() + ", isAireAcondicionado()=" + isAireAcondicionado() + ", getTipoCaja()="
                + getTipoCaja() + ", getCantidadBolsasAire()=" + getCantidadBolsasAire() + ", getMarca()=" + getMarca()
                + ", isABS()=" + isABS() + ", getNuevo_usado()=" + getNuevo_usado() + ", getCambios()=" + getCambios()
                + ", getVelocidadMaxima()=" + getVelocidadMaxima() + ", getCilindrada()=" + getCilindrada()
                + ", getUsuarioCompro()=" + getUsuarioCompro() + ", getPrecioVehiculo()=" + getPrecioVehiculo()
                + ", getPrecioRenta()=" + getPrecioRenta() + ", getID()=" + getID() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
    