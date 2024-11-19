package clases.Vehiculos.abstractas;

import clases.Alimentacion.IAlimentacion;
import clases.Personas.IPersona;

public interface IAutoMotor {

    String getMarca();

    String toString();

    IAlimentacion getAlimentacion();

    

}
