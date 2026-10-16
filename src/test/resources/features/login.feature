
# language: es
Característica: Inicio de sesión
  Como usuario registrado
  Quiero iniciar sesión
  Para acceder al sistema de la empresa

  Antecedentes:
    Dado que el sistema de inicio de sesión está disponible

  Escenario: Inicio de sesión exitoso
    Dado que el usuario tiene el correo "usuario@empresa.cl"
    Cuando ingresa el correo "usuario@empresa.cl" y la contraseña "Clave123"
    Entonces el sistema debe permitir el acceso

  Esquema del escenario: Rechazar credenciales inválidas
    Dado que el usuario tiene el correo "usuario@empresa.cl"
    Cuando ingresa el correo "<correo>" y la contraseña "<contrasena>"
    Entonces el sistema debe rechazar el acceso

    Ejemplos:
      | correo                 | contrasena |
      | usuario@empresa.cl     | Incorrecta |
      | desconocido@empresa.cl | Clave123   |
      | usuario@empresa.cl     |            |
