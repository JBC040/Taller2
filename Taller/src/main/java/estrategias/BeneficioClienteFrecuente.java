package estrategias;
import compras.Cliente;
public class BeneficioClienteFrecuente implements EstrategiaDescuento {
    private final double porcentaje;
    public BeneficioClienteFrecuente(double p) {
        if (p<0 || p>1) throw new IllegalArgumentException();
        porcentaje = p;
    }
    public double calcularDescuento(double s, Cliente c) {
        return c.esFrecuente()?s * porcentaje: 0;
    }
}
