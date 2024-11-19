package clases.Alimentacion;

public class Electrico extends Renovable {
    int autonomiaCargaMaxima;
    int horasCargando;

    public Electrico(int autonomiaCargaMaxima, int horasCargando, String descripcion) {
        super(descripcion);
        this.autonomiaCargaMaxima = autonomiaCargaMaxima;
        this.horasCargando = horasCargando;
    }

    public int getAutonomiaCargaMaxima() {
        return autonomiaCargaMaxima;
    }

    public int getHorasCargando() {
        return horasCargando;
    }
}
