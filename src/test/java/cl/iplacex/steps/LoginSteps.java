
package cl.iplacex.steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private String correoIngresado;
    private String contrasenaIngresada;
    private boolean accesoPermitido;
    private boolean sistemaDisponible;

    @Dado("que el sistema de inicio de sesión está disponible")
    public void sistemaDisponible() {
        sistemaDisponible = true;
    }

    @Dado("que el usuario tiene el correo {string}")
    public void usuarioTieneCorreo(String correo) {
        // El correo representa al usuario registrado para esta simulación.
        correoIngresado = correo;
    }

    @Cuando("ingresa el correo {string} y la contraseña {string}")
    public void ingresarCredenciales(String correo, String contrasena) {
        correoIngresado = correo;
        contrasenaIngresada = contrasena;

        // Simulación: solo estas credenciales permiten el acceso.
        accesoPermitido = sistemaDisponible
                && "usuario@empresa.cl".equals(correoIngresado)
                && "Clave123".equals(contrasenaIngresada);
    }

    @Entonces("el sistema debe permitir el acceso")
    public void sistemaPermiteAcceso() {
        assertEquals(true, accesoPermitido,
                "Se esperaba que el sistema permitiera el acceso");
    }

    @Entonces("el sistema debe rechazar el acceso")
    public void sistemaRechazaAcceso() {
        assertEquals(false, accesoPermitido,
                "Se esperaba que el sistema rechazara el acceso");
    }
}
