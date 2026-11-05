package estrategias;
public class ResumenPrecio {
    private final double subtotal, descuento, envio, total;
    public ResumenPrecio(double s, double d, double e) {
        subtotal = s;
        descuento = d;
        envio = e;
        total = s - d + e;
    }
    public double getSubtotal() {
        return subtotal;
    }
    public double getValorDescuento() {
        return descuento;
    }
    public double getCostoEnvio() {
        return envio;
    }
    public double getTotal() {
        return total;
    }
}
