package modelo;

public enum Categoria {

    TECNOLOGIA(.19),
    ROPA(.05),
    ALIMENTO(0);

    private final double impuesto;

    Categoria(double i) {
        impuesto = i;
    }

    public double getImpuesto() {
        return impuesto;
    }
}
