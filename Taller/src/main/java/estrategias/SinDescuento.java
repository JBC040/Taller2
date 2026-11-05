package estrategias;
import compras.Cliente;
public class SinDescuento implements EstrategiaDescuento {
    public double calcularDescuento(double s, Cliente c) {
        return 0;
    }
}
