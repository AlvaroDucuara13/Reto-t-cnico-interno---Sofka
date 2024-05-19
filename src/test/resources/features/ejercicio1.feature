# language:es

Característica: consultar usuario por id
  Yo como analista de calidad
  Deseo realizar una consulta al servicio get_users_id
  Para obtener un usuario por id

  Escenario: CP01 - Realizar consulta de usuario por id
    Dado que el analista de calidad desea consultar el usuario 2
    Cuando el analista de calidad consume el servicio de get_user
    Entonces el analista de calidad podrá visualizar los datos del usuario con codigo de respuesta 200


  Escenario: CP02 - Actualizar datos del usuario
    Dado que el analista de calidad desea actualizar los datos del usuario:
    |usuario    | 2                                       |
    |email      | jorge12@mailsac.com                     |
    |first_name | Jorge                                   |
    |last_name  | Mendez                                  |
    |avatar     |"https://reqres.in/img/faces/2-image.jpg |
    Cuando el analista de calidad consume el servicio para actualizar los datos del usuario
    Entonces el analista de calidad podrá visualizar los datos del usuario actualizados con codigo de respuesta 200

  Escenario: CP03 - Eliminar un usuario del sistema
    Dado que el analista de calidad desea eliminar el usuario 7
    Cuando el analista de calidad consume el servicio para eliminar al usuario del sistema
    Entonces el analista de calidad podrá visualizar el codigo de respuesta 204
    Y el analista de calidad debera validar que el usuario no exista en la lista de usuarios
