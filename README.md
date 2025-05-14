#  API de Gestión de Empleados

Este proyecto es una API RESTful desarrollada con Java 8 y Spring Boot, que permite gestionar empleados 
en una base de datos PostgreSQL.

##  Tecnologías utilizadas

- Java 8
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger 
- JUnit + Mockito (tests)
- SLF4J + Logback (logs)
- Maven
- Docker (opcional)
- Postman (pruebas manuales)

## Endpoints 

| Método | Endpoint           | Descripción                     |
|--------|--------------------|---------------------------------|
| GET    | `/api/empleados`   | Lista todos los empleados       |
| GET    | `/api/empleados/{id}` | Obtiene un empleado por ID   |
| POST   | `/api/empleados`   | Crea un nuevo empleado          |
| POST   | `/api/empleados/bulk` | Crea múltiples empleados     |
| PUT    | `/api/empleados/{id}` | Actualiza un empleado existente |
| DELETE | `/api/empleados/{id}` | Elimina un empleado          |

## 📘 Cómo ejecutar el proyecto

### 1. Configura la base de datos

Asegúrate de que PostgreSQL esté corriendo y crea una base de datos:

```sql
CREATE DATABASE gestion_empleados;
```

### 2. Configura `application.properties`

Ya debe contener:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/gestion_empleados
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Compilar y ejecutar la aplicación

1. Compilar y empaquetar el .jar
   mvn clean package

2. Ejecutar el archivo .jar
   java -jar target/empleados-1.0.0.jar

La API se iniciará en http://localhost:8080


## Documentación Swagger

Una vez ejecutado el proyecto, accede a:

```
http://localhost:8080/swagger-ui/
```

## Bitácora de eventos

Los eventos importantes del sistema se registran en consola con el logger `SLF4J`, 
en el archivo `application.properties`.


## Pruebas en Postman
Endpoints disponibles

** Obtener todos los empleados
GET /api/empleados
 Respuesta exitosa: lista de empleados con código 200.


** Obtener empleado por ID
GET /api/empleados/{id}
Respuesta exitosa: empleado con ID existente (código 200).
Error: empleado no existe (código 404).


**Crear nuevo empleado
POST /api/empleados
Empleado creado con éxito (código 201).
Error de validación (nombre o email vacío, formato email incorrecto) → código 400.


**Actualizar empleado existente
PUT /api/empleados/{id}
Actualización exitosa de empleado existente (código 200).
Error: empleado no encontrado (código 404).
Error de validación en campos (código 400).

**Eliminar empleado
DELETE /api/empleados/{id}
Eliminación exitosa de empleado existente (código 204).
Error: empleado no encontrado (código 404).




Evidencias de pruebas

**Pruebas exitosas

GET /api/empleados → 200 OK con lista de 10 empleados.

GET /api/empleados/1 → 200 OK con datos del empleado.

POST /api/empleados con datos válidos → 201 Created.

PUT /api/empleados/1 con actualización válida → 200 OK.

DELETE /api/empleados/1 → 204 No Content.



** Pruebas con errores

GET /api/empleados/1000 → 404 Not Found (no existe).

PUT /api/empleados/1000 → 404 Not Found (no existe).

DELETE /api/empleados/1000 → 404 Not Found (no existe).

POST /api/empleados con email inválido → 400 Bad Request.

POST /api/empleados con campos vacíos → 400 Bad Request.




## Contacto
Desarrollado por Manuel Reyes Varela
