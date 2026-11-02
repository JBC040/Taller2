package utilidades;

import java.util.Collections;

import java.util.List;

public class Ordenamiento {

    public static <T extends Comparable <? super T>>
    void ordenar (List<T> lista) {

        for (int i = 0; i < lista.size() - 1; i++) {

            for (int j = 0; j < lista.size() - 1 - i; j++) {

                if (lista.get(j).compareTo(lista.get(j + 1)) > 0) {

                    Collections.swap(lista, j, j + 1);

                }
            }
        }
    }
}
