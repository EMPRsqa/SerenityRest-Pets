#language: es
Característica: Gestión de usuarios en la API de Petstore
  Como usuario de la automatización
  Quiero gestionar un usuario consumiendo los servicios de Petstore
  Para validar el ciclo de vida de creación, consulta y actualización

  Escenario: Crear, consultar y actualizar un usuario exitosamente
    Dado que el usuario automatizado se conecta a la API de Petstore
    Cuando lee los datos del usuario desde el archivo Excel
    Y realiza la solicitud para crear el usuario
    Entonces el código de respuesta HTTP debe ser 200
    Cuando realiza la solicitud para consultar el usuario creado
    Entonces el código de respuesta HTTP debe ser 200
    Cuando realiza la solicitud para actualizar el usuario
    Entonces el código de respuesta HTTP debe ser 200