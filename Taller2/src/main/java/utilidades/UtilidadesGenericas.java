package utilidades;

import java.util.*;

import java.util.function.Predicate;

public class UtilidadesGenericas {

    public static int contarElementos(Collection<?> elementos) {
        return elementos.size();
    }

    public static <T> List <T> filtrarElementos (
            Collection <? extends T> elementos,
            Predicate<? super T> condicion) {

        List<T> resultado = new ArrayList<>();

        for (T elemento : elementos) {
            if (condicion.test(elemento)) {
                resultado.add(elemento);
            }
        }

        return resultado;

    }

    public static <T> void agregarElementos(
            Collection<? super T> destino,
            Collection<? extends T> origen) {

        destino.addAll(origen);
    }
}
