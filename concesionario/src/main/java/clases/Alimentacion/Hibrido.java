package clases.Alimentacion;

public class Hibrido extends Renovable {
    boolean enchufable;

    public Hibrido(boolean enchufable, String descripcion) {
        super(descripcion);
        this.enchufable = enchufable;
    }

    public boolean isEnchufable() {
        return enchufable;
    }
}
