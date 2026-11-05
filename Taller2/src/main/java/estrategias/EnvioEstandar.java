package estrategias;
public class EnvioEstandar implements EstrategiaEnvio {
    private final double tarifa, minimoGratis;
    public EnvioEstandar(double t, double m) {
        if (t<0 || m<0) throw new IllegalArgumentException();
        tarifa = t;
        minimoGratis = m;
    }
    public double calcularCosto(double s) {
        return s>= minimoGratis?0: tarifa;
    }
}
