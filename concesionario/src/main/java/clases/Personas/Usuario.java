package clases.Personas;

public class Usuario extends Persona {
    private String clave;
    private String preguntaRecuoeracion;

    public Usuario(String nombre, String apellido, String cedula, String clave, String preguntaRecuoeracion) {
        super(nombre, apellido, cedula);
        this.clave = clave;
        this.preguntaRecuoeracion = preguntaRecuoeracion;
    }

    public String getClave() {
        return clave;
    }   

    public String getPreguntaRecuoeracion() {
        return preguntaRecuoeracion;
    }

    @Override
    public void setID_vehiculo(int vehiculo) {
    }

    @Override
    public void setTipo_vehiculo(String tipo_vehiculo) {
       
    }
}
