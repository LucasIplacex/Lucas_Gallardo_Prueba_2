Proyecto de Pruebas de Software

1- Objetivo del proyecto

El objetivo de este proyecto es implementar pruebas unitarias automatizadas utilizando Java, Maven y JUnit 5. 
Además, se utiliza Git para el control de versiones y GitHub Actions para ejecutar las pruebas automáticamente mediante un pipeline de integración continua.

2- Tecnologías utilizadas

- Java 17: lenguaje de programación.
- Apache Maven: administración del proyecto y ejecución de pruebas.
- JUnit 5: framework para crear y ejecutar pruebas unitarias.
- Git: control de versiones y seguimiento de cambios.
- GitHub: alojamiento del repositorio remoto.
- GitHub Actions: automatización de la compilación y ejecución de pruebas.

3- Estructura del proyecto

Lucas_Gallardo_Prueba_2/
├── .github/
│   └── workflows/
│       └── maven.yml
├── evidencias/
│   ├── pruebas-junit.png
│   └── historial-git.png
├── src/
│   ├── main/
│   │   └── java/
│   │       └── cl/
│   │           └── iplacex/
│   │               └── Calculadora.java
│   └── test/
│       └── java/
│           └── cl/
│               └── iplacex/
│                   └── CalculadoraTest.java
├── .gitignore
├── pom.xml
└── README.md

4- Funcionalidad implementada

Se creó la clase Calculadora.java, que contiene dos operaciones independientes:

-sumar(int a, int b): suma dos números enteros.
-restar(int a, int b): resta el segundo número al primero.

5- Pruebas unitarias

Las pruebas están implementadas en CalculadoraTest.java utilizando JUnit 5.

|Prueba | Entrada | Resultado esperado |
| Suma  | 2 + 3   | 5                  |
| Resta | 10 - 4  | 6                  |

Ambas pruebas se ejecutan de forma independiente mediante el framework JUnit.

6- Configuración de Maven

El archivo pom.xml define las propiedades del proyecto, utiliza Java 17 e incorpora la dependencia JUnit Jupiter para ejecutar las pruebas unitarias.

También configura los complementos Maven Compiler y Maven Surefire.

Para validar el proyecto y ejecutar las pruebas se utilizan los siguientes comandos:

bash
mvn validate
mvn test

El comando mvn test ejecuta las pruebas y genera los resultados en target/surefire-reports/.

7- Control de versiones con Git

Se inicializó un repositorio Git y se trabajó en la rama feature/prueba2, manteniendo también la rama main.

Se realizaron commits con mensajes descriptivos para registrar los avances del proyecto y se subieron los cambios al repositorio remoto de GitHub.

Comandos principales utilizados:

bash
git init
git switch -c feature/prueba2
git add .
git commit -m "Mensaje descriptivo"
git push -u origin feature/prueba2
git push
git status
git log --oneline

8- Archivo .gitignore

El archivo .gitignore contiene la siguiente regla:

text
target/

Esto evita incluir en el repositorio los archivos generados automáticamente por Maven durante la compilación y ejecución de pruebas.

9- Pipeline de integración continua

El archivo .github/workflows/maven.yml configura un pipeline de GitHub Actions.

El pipeline realiza las siguientes tareas:

1. Descarga el código del repositorio.
2. Configura el entorno con Java 17.
3. Ejecuta las pruebas unitarias mediante mvn --batch-mode test.
4. Publica los reportes generados por Maven como un artefacto descargable llamado reporte-pruebas-junit.

El pipeline se activa al realizar cambios mediante push en las ramas main y feature/prueba2, 
y también ante solicitudes de integración (pull_request) dirigidas a main.

10- Evidencias

La carpeta evidencias/ contiene capturas de pantalla que documentan la ejecución local de las pruebas unitarias y el historial de commits de Git.

La ejecución del pipeline y el artefacto de resultados se pueden consultar en la pestaña Actions del repositorio de GitHub.

11- Resultados

Las dos pruebas unitarias se ejecutaron correctamente en el entorno local, sin fallos ni errores. 
Además, se verificó la ejecución satisfactoria del pipeline de GitHub Actions y la publicación del reporte de pruebas.

12- Conclusión

El proyecto permite demostrar el uso de pruebas unitarias automatizadas con Java, Maven y JUnit 5, 
el control de versiones mediante Git y la integración continua con GitHub Actions. 
La documentación y las evidencias facilitan la revisión del proceso y de sus resultados.
