package cl.iplacex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();

    @Test
    void debeSumarDosNumeros() {
        assertEquals(5, calculadora.sumar(2, 3));
    }

    @Test
    void debeRestarDosNumeros() {
        assertEquals(6, calculadora.restar(10, 4));
    }
}
