"# intercorp-review" 

Práctica a resolver de microServicios:

Microservicio desarrollado en JAVA Spring boot
*API Rest documentada en Swagger
*Deployado en google CLOUD
*utiliza api de stadísticas poblacional para el calculo de fecha probable de muerte


Endpoint de Entrada POST /creacliente
-Nombre
-Apellido
-Edad
-Fecha de nacimiento

Endpoint de salida GET /kpideclientes
-Promedio edad entre todos los clientes
-Desviación estándar entre las edades de todos los clientes

Endpoint de salida GET /listclientes
-Lista de personas con todos los datos + fecha probable de muerte de cada una
