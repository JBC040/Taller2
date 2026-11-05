# Tienda en Línea

## Descripción
Aplicación de consola en Java con Maven que simula una tienda de tecnología, ropa y alimentos. Maneja inventario, compras, impuestos, descuentos, envíos, historial y reportes.

## Integrantes
- **Londo:** Productos y excepciones.
- **Juan Andrés:** Inventario y decoradores.
- **El Negro:** Estrategias de descuento, envío y precios.
- **Juanes:** Genéricos, ordenamiento y wildcards

## Funcionamiento
El cliente agrega productos al carrito, donde se valida el stock y el vencimiento. Se aplican descuentos, envíos y extras. Al confirmar la compra, se calcula el total, se actualiza el inventario y se guarda el historial.

## Tabla de trazabilidad
**POO:** `Producto`, `Tecnologia`, `Ropa`, `Alimento`
**Strategy:** `EstrategiaDescuento`, `EstrategiaEnvio`, `CalculadoraPrecios`
**Decorator:** `ProductoDecorador`, `EmpaqueRegalo`, `GarantiaExtendida`
**Excepciones:** Paquete `excepciones`
**Comparable y Comparator:** `Producto`, `Catalogo`, `ComparadorPorPrecio`
**Ordenamiento:** `Ordenamiento`
**Genéricos y Wildcards:** `Repositorio`, `Caja`, `Buscable`, `UtilidadesGenericas`
**Predicate, Function, Consumer y Supplier:** `Repositorio`, `UtilidadesGenericas`, `CalculadoraPrecios`
**Streams y Optional:** `Repositorio`, `GestorReportes`, `Caja`
**Reportes:** `GestorReportes`
**Pruebas JUnit 5:** Clases de prueba en `src/test/java`
**Logger:** `GestorReportes`
**SOLID:** Paquetes `estrategias`, `decoradores`, `modelo` y `servicios`

# UML 
Producto abstracto tiene Tecnologia, Ropa y Alimento. ProductoDecorador hereda de Producto y contiene otro Producto; EmpaqueRegalo y GarantiaExtendida heredan de ProductoDecorador. EstrategiaDescuento tiene tres implementaciones; EstrategiaEnvio tiene dos. CalculadoraPrecios usa ambas interfaces. Carrito conecta Inventario, CalculadoraPrecios e HistorialCompras. Compra contiene DetalleCompra.


## Reglas de cálculo
El precio incluye extras e impuestos. Después se aplica el descuento y finalmente el costo del envío. El stock se descuenta al confirmar la compra y los reportes conservan los precios históricos.

## Pruebas
Lo tests se encuentran en `src/test/java`.

