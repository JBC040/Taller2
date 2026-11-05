package estrategias;
import compras.Cliente;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class CalculadoraPrecios {

    private static final Logger LOG = Logger.getLogger(CalculadoraPrecios.class.getName());

    private final Supplier<EstrategiaEnvio> envioDefault;

    public CalculadoraPrecios(Supplier<EstrategiaEnvio> s) {
        envioDefault = Objects.requireNonNull(s);
    }

    public ResumenPrecio calcular(double subtotal, EstrategiaDescuento d, EstrategiaEnvio e, Cliente c) {

        if (subtotal<0) throw new IllegalArgumentException();

        double desc = d.calcularDescuento(subtotal, c);

        if (desc<0 || desc> subtotal) throw new IllegalArgumentException("Descuento inválido");

        EstrategiaEnvio envio = e == null?envioDefault.get(): e;

        double costo = envio.calcularCosto(subtotal - desc);

        LOG.info("Precio calculado");

        return new ResumenPrecio(subtotal, desc, costo);
    }
}
