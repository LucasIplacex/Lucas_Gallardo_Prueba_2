Dashboard de métricas de calidad

1- Métricas funcionales

| Indicador               | Resultado  | Estado   |
|-------------------------|-----------:|----------|
| Pruebas unitarias JUnit | 2 exitosas | Aprobado |
| Escenarios BDD Cucumber | 4 exitosos | Aprobado |
| Total de pruebas        | 6 exitosas | Aprobado |
| Fallos funcionales      | 0          | Aprobado |

2- Métricas de rendimiento (k6)

| Indicador                                | Resultado       | Umbral         | Estado     |
|------------------------------------------|----------------:|----------------|------------|
| Solicitudes HTTP                         | 150             | Informativo    | Registrado |
| Solicitudes por segundo (TPS aproximado) | 4,99            | Informativo    | Registrado |
| Latencia promedio                        | 1,07 ms         | Informativo    | Registrado |
| Latencia p95                             | 2,26 ms         | Menor a 500 ms | Aprobado   |
| Solicitudes HTTP fallidas                | 0 %             | Menor al 1 %   | Aprobado   |
| Verificaciones exitosas                  | 300/300 (100 %) | 100 % esperado | Aprobado   |

3- Interpretación

Las pruebas unitarias y los escenarios BDD finalizaron sin fallos. 
En la prueba de rendimiento del servicio HTTP simulado, 
el percentil 95 de latencia fue inferior al umbral de 500 ms y no se registraron solicitudes HTTP fallidas.

Estos resultados corresponden a una prueba local con cinco usuarios virtuales durante 30 segundos. 
No representan una garantía de rendimiento en producción.

4- Frecuencia de revisión

- Métricas funcionales: en cada ejecución del pipeline de integración continua.
- Métricas de rendimiento: en cada ejecución de la prueba k6.
- Tendencias: comparar resultados entre ejecuciones para detectar aumentos de latencia o errores.