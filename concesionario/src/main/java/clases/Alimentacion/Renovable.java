package clases.Alimentacion;

public class Renovable implements IAlimentacion {
    String descripcion;

    public Renovable(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public int getGalonesMaximos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGalonesMaximos'");
    }

    @Override
    public String getDescripcion() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDescripcion'");
    }
    
}
