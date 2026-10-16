# Configuración de alertas de calidad

## 1. Alerta por fallos funcionales

- **Herramienta:** GitHub Actions.
- **Condición:** si falla un paso anterior del pipeline, se ejecuta el paso `Alertar si fallan las pruebas`.
- **Acción:** se registra una alerta en el resumen de la ejecución para indicar que deben revisarse las pruebas unitarias, los escenarios BDD y los registros del pipeline.

## 2. Alertas por degradación del rendimiento

**Herramienta:** k6.

Se consideran los siguientes umbrales para la prueba de rendimiento:

| Indicador                 | Umbral         | Acción si no se cumple |
|---------------------------|----------------|------------------------|
| Latencia p95              | Menor a 500 ms | La prueba falla        |
| Solicitudes HTTP fallidas | Menos del 1 %  | La prueba falla        |

Si alguno de estos umbrales no se cumple, k6 marca la prueba como fallida por la configuración de `thresholds` en `performance/login-load.js`.

## 3. Revisión y respuesta

1. Revisar el resumen y los registros de GitHub Actions.
2. Identificar qué prueba o umbral falló.
3. Corregir el problema.
4. Volver a ejecutar las pruebas y verificar que el pipeline finalice correctamente.

## 4. Estado de la configuración

El workflow con la alerta por fallos fue subido a la rama `feature/prueba2`. La ejecución comprobada más reciente finalizó correctamente.

**Limitación:** la alerta configurada escribe un aviso en el resumen de GitHub Actions; no envía automáticamente correos ni mensajes a servicios externos.