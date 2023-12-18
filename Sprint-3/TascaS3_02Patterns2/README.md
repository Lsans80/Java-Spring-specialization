# TascaS3_02Patterns2

En este Sprint vamos a profundizar en los patrones de construcción de software.

## Nivel 1

En todos los ejercicios, crea un proyecto Gradle con una clase Main que demuestre el uso del patrón (con las invocaciones que se necesiten).

### Observer
Diseña un sistema en el que un Agente de Bolsa (Observable) notifica a varias agencias de Bolsa (Observers) cambios cuando la Bolsa sube o baja.

Es necesario que el objeto Observable mantenga referencias a los Observadores.

## Nivel 2

### Callback

Simula una pasarela de pago que reciba un objeto encapsulador del método de pago a efectuar: tarjeta de crédito, Paypal o deuda en cuenta bancaria.

La pasarela invocará el pago sin conocer la forma y devolviendo el control a la clase de origen.

La clase que invoca la pasarela de pago será una tienda de zapatos.
