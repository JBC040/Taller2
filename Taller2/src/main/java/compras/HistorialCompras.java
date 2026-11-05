package compras;
import java.util.*;
import java.util.stream.Collectors;
public class HistorialCompras {
    private final List<Compra> compras = new ArrayList<>();
    public void registrar(Compra c) {
        compras.add(Objects.requireNonNull(c));
    }
    public List<Compra> obtenerTodas() {
        return List.copyOf(compras);
    }
    public List<Compra> porCliente(String id) {
        return compras.stream().filter(c -> c.getCliente().getIdentificacion().equals(id)).collect(Collectors.toList());
    }
}
