package estrategias;
public class EnvioExpress implements EstrategiaEnvio {
    private final double tarifa;
    public EnvioExpress(double t) {
        if (t<0) throw new IllegalArgumentException();
        tarifa = t;
    }
    public double calcularCosto(double s) {
        return tarifa;
    }
}
