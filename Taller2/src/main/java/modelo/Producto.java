package modelo;

import excepciones.StockInsuficienteException;

import java.util.Objects;

public abstract class Producto implements Comparable<Producto> {

    private final String codigo;
    private final String nombre;
    private final Categoria categoria;
    private final double precioBase;
    private int stock;

    protected Producto(String c, String n, Categoria cat, double p, int s) {
        if (c == null || c.isBlank() || n == null || n.isBlank() || p <= 0 || s < 0) {
            throw new IllegalArgumentException("Datos de producto inválidos");
        }
        codigo = c;
        nombre = n;
        categoria = cat;
        precioBase = p;
        stock = s;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecioConImpuesto() {
        return getPrecioBase() * (1 + categoria.getImpuesto());
    }

    public void descontarStock(int q) {
        if (q <= 0 || q > stock) {
            throw new StockInsuficienteException("Stock insuficiente: " + nombre);
        }
        stock -= q;
    }

    public void aumentarStock(int q) {
        if (q <= 0) {
            throw new IllegalArgumentException();
        }
        stock += q;
    }

    public Producto getProductoBase() {
        return this;
    }

    @Override
    public int compareTo(Producto p) {
        return nombre.compareToIgnoreCase(p.nombre);
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " (" + categoria + ") $"
                + String.format("%.2f", getPrecioConImpuesto())
                + " stock=" + getStock();
    }
}
