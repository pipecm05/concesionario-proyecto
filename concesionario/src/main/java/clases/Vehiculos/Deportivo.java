package clases.Vehiculos;
import clases.Vehiculos.abstractas.Vehiculo;
import clases.Alimentacion.IAlimentacion;
import clases.Vehiculos.abstractas.TipoCaja;
import clases.Personas.IPersona;


public class Deportivo extends Vehiculo {
    private int caballosFuerza;
    private int tiempoEnAlcanzar100Km;

    public Deportivo(int ID,IAlimentacion alimentacion, TipoCaja tipoCaja, String marca, String nuevo_usado, int cambios, int velocidadMaxima, int cilindrada, int numeroPasajeros, int numeroPuertas, boolean aireAcondicionado, int cantidadBolsasAire, boolean ABS, int caballosFuerza, int tiempoEnAlcanzar100Km, IPersona usuarioCompro, double precioVehiculo, double precioRenta) {
        super(ID,alimentacion, tipoCaja, marca, nuevo_usado, cambios, velocidadMaxima, cilindrada, numeroPasajeros, numeroPuertas, aireAcondicionado, cantidadBolsasAire, ABS, usuarioCompro, precioVehiculo, precioRenta);
        this.caballosFuerza = caballosFuerza;
        this.tiempoEnAlcanzar100Km = tiempoEnAlcanzar100Km;
    }

    public int getCaballosFuerza() {
        return caballosFuerza;
    }

    public int getTiempoEnAlcanzar100Km() {
        return tiempoEnAlcanzar100Km;
    }
    
}
