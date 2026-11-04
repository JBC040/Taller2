package estrategias;
import compras.Cliente;
@FunctionalInterface public interface EstrategiaDescuento {
    double calcularDescuento(double subtotal, Cliente cliente);
}
