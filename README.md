Proyecto de Pruebas de Software — IPLACEX

1- Objetivo

Implementar y documentar pruebas automatizadas utilizando Java 17, Maven, JUnit 5 y Cucumber. El proyecto integra control de versiones con Git, ejecución continua con GitHub Actions y una prueba básica de rendimiento con k6.

2- Tecnologías utilizadas

- **Java 17:** lenguaje de programación.
- **Apache Maven:** compilación y administración de dependencias.
- **JUnit 5:** pruebas unitarias.
- **Cucumber:** pruebas de comportamiento mediante escenarios BDD escritos en Gherkin.
- **Git y GitHub:** control de versiones y alojamiento del código.
- **GitHub Actions:** integración continua y publicación de reportes.
- **k6:** prueba de rendimiento HTTP.

3- Estructura del proyecto

- `.github/workflows/maven.yml`: pipeline de integración continua.
- `src/main/java/cl/iplacex/Calculadora.java`: operaciones de suma y resta.
- `src/test/java/cl/iplacex/CalculadoraTest.java`: pruebas unitarias.
- `src/main/java/cl/iplacex/performance/LoginServer.java`: servidor HTTP de inicio de sesión simulado.
- `src/test/resources/features/login.feature`: escenarios BDD de inicio de sesión.
- `src/test/java/cl/iplacex/steps/LoginSteps.java`: definiciones de pasos Cucumber.
- `src/test/java/cl/iplacex/runners/RunCucumberTest.java`: ejecución de escenarios BDD.
- `performance/login-load.js`: script de rendimiento k6.
- `evidencias/`: capturas y documentación de resultados.
- `pom.xml`: dependencias y configuración Maven.
- `.gitignore`: exclusión de archivos generados.

4- Pruebas unitarias con JUnit 5

La clase `Calculadora.java` contiene dos operaciones:

- `sumar(int a, int b)`: suma dos números enteros.
- `restar(int a, int b)`: resta el segundo número al primero.

| Prueba | Entrada | Resultado esperado |
|--------|---------|-------------------:|
| Suma   | 2 + 3   | 5                  |
| Resta  | 10 - 4  | 6                  |

Para ejecutar las pruebas:

```bash
mvn test
```

Los resultados de Maven se generan en `target/surefire-reports/`.

5- Pruebas BDD con Cucumber

Se simuló una sesión Three Amigos con los roles de negocio, desarrollo y QA para definir los criterios de aceptación del inicio de sesión.

Los escenarios contemplan:

- Acceso exitoso con credenciales válidas.
- Rechazo de una contraseña incorrecta.
- Rechazo de un correo no registrado.
- Rechazo de una contraseña vacía.

El archivo `login.feature` utiliza Gherkin en español e incluye un Esquema del escenario con una tabla de ejemplos.

Las definiciones de pasos implementan una simulación del comportamiento de autenticación; no corresponden a un sistema real con base de datos.

6- Integración continua con GitHub Actions

El workflow `.github/workflows/maven.yml`:

1. Descarga el código.
2. Configura Java 17.
3. Ejecuta las pruebas unitarias y los escenarios BDD mediante Maven.
4. Publica el reporte de pruebas JUnit/Surefire.
5. Publica el reporte HTML de Cucumber como artefacto.
6. Registra una alerta en el resumen si falla un paso anterior.

El pipeline se ejecuta con cambios en las ramas `main` y `feature/prueba2`, y en solicitudes de integración dirigidas a `main`.

Los reportes se consultan desde la pestaña **Actions**, entrando en la ejecución correspondiente y descargando sus artefactos.

7- Prueba básica de rendimiento con k6

La prueba utiliza un servidor HTTP local simulado, implementado en `LoginServer.java`, y el script `performance/login-load.js`.

### Ejecución

Primero, compilar el proyecto:

```bash
mvn compile
```

En una terminal, iniciar el servidor:

```bash
java -cp target/classes cl.iplacex.performance.LoginServer
```

Mantener el servidor en ejecución. En otra terminal, desde la carpeta del proyecto, ejecutar:

```bash
k6 run performance/login-load.js
```

### Umbrales configurados

- Latencia p95 inferior a 500 ms.
- Solicitudes HTTP fallidas por debajo del 1 %.

### Resultados registrados

| Indicador                           | Resultado observado |
|-------------------------------------|--------------------:|
| Usuarios virtuales                  | 5                   |
| Duración                            | 30 segundos         |
| Solicitudes HTTP                    | 150                 |
| Solicitudes por segundo aproximadas | 4,99                |
| Latencia promedio                   | 1,07 ms             |
| Latencia p95                        | 2,26 ms             |
| Solicitudes fallidas                | 0 %                 |
| Verificaciones exitosas             | 300/300             |

Estos valores corresponden a una ejecución local de referencia y pueden variar. No representan una garantía de rendimiento en producción.

8- Métricas y alertas de calidad

El archivo `evidencias/dashboard-metricas.md` documenta los resultados funcionales y de rendimiento.

El archivo `evidencias/alertas-calidad.md` describe las condiciones de alerta y el procedimiento de revisión.

- **Alerta funcional:** GitHub Actions registra un aviso en el resumen cuando falla un paso anterior.
- **Alerta de rendimiento:** k6 marca la prueba como fallida si no se cumplen los umbrales configurados.
- **Respuesta:** revisar los registros, identificar el fallo, corregirlo y volver a ejecutar las pruebas.

La alerta del workflow no envía por sí sola correos ni mensajes externos.

9- Control de versiones

El trabajo se desarrolló en la rama `feature/prueba2`, manteniendo también `main`.

Comandos habituales:

```bash
git status
git add .
git commit -m "Descripción del cambio"
git push origin feature/prueba2
git log --oneline
```

El archivo `.gitignore` excluye `target/` para evitar subir archivos generados por Maven.

10- Evidencias

La carpeta `evidencias/` incluye capturas y documentos de apoyo:

- `pruebas-junit.png`: pruebas unitarias.
- `historial-git.png`: historial de Git.
- `pipeline-github-actions.png`: ejecución del pipeline.
- `prueba-rendimiento-k6.png`: resultados de k6.
- `dashboard-metricas.md`: tabla de métricas funcionales y de rendimiento.
- `dashboard-metricas.png`: captura del dashboard.
- `alertas-calidad.md`: documentación de alertas.

11- Resultados y conclusión

Las pruebas unitarias y los escenarios BDD finalizaron correctamente en la ejecución local registrada. La prueba k6 también cumplió los umbrales configurados en la ejecución documentada. El pipeline de GitHub Actions se verificó con resultado exitoso.

El proyecto demuestra el uso de pruebas unitarias, BDD, integración continua, reportes de ejecución, métricas básicas de rendimiento y documentación de alertas. Las pruebas de autenticación y rendimiento utilizan un servicio simulado, por lo que sus resultados no deben interpretarse como validación de un sistema de producción.