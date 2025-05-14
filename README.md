#   API de Gestión de Empleados

Este proyecto es una API RESTful desarrollada con Java 8 y Spring Boot, que permite gestionar empleados 
en una base de datos PostgreSQL.

##  Tecnologías utilizadas

- Java 8
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Swagger 
- SLF4J (logs)
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


###1. Clona el repositorio:
   ```bash
   git clone https://github.com/ManuRV/gestion-empleados.git
   ```

2. Navega al directorio del proyecto:
   ```bash
   cd gestion-empleados
   ```

3. Compila el proyecto:
   ```bash
   mvn clean install
   ```

4. Ejecuta el proyecto:
   ```bash
   mvn spring-boot:run
   ```

### 2. Configura la base de datos

Asegúrate de que PostgreSQL esté corriendo y crea una base de datos:

```sql
CREATE DATABASE gestion_empleados;
```

##  Script SQL de la Tabla Empleado

Para crear la tabla `empleado` usada en este proyecto, puedes ejecutar el script que se encuentra en el archivo (./schema.sql).

Este script incluye las validaciones de edad y sexo, así como la definición completa de columnas como nombres, apellidos, fecha de nacimiento y puesto.


### 3. Configura `application.properties`

Ya debe contener:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/gestion_empleados
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 4. Compilar y ejecutar la aplicación

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

# Obtener todos los empleados
**Método**:GET /api/empleados
**URL**: `http://localhost:8080/api/empleados`
 Respuesta exitosa: lista de empleados con código 200.


# Obtener empleado por ID
**Método** GET /api/empleados/{id}
**URL**: `http://localhost:8080/api/empleados/{id}`
Respuesta exitosa: empleado con ID existente (código 200).
Error: empleado no existe (código 404).


# Crear nuevo empleado
**Método** POST /api/empleados
**URL**: `http://localhost:8080/api/empleados`
**Cuerpo**:
```json
{
  "primerNombre": "Sara",
  "segundoNombre": "Gabriela",
  "apellidoPaterno": "Luna",
  "apellidoMaterno": "Muñoz",
  "edad": 33,
  "sexo": "F",
  "fchNacimiento": "1991-05-10",
  "puesto": "QA Manual",
  "nombreCompleto": "Nora Beatriz Luna Salas"
}
```
Empleado creado con éxito (código 201).
Error de validación (nombre o email vacío, formato email incorrecto) → código 400.


# Actualizar empleado existente
**Método** PUT /api/empleados/{id}
URL: http://localhost:8080/api/empleados/{id}
**Cuerpo**:
```json
{
"primerNombre": "Sara",
"segundoNombre": "Gabriela",
"apellidoPaterno": "Luna",
"apellidoMaterno": "Muñoz",
"edad": 15,
"sexo": "F",
"fchNacimiento": "1991-05-10",
"puesto": "QA Senior",
"nombreCompleto": "Nora Beatriz Luna Salas"
}
```
Actualización exitosa de empleado existente (código 200).
Error: empleado no encontrado (código 404).
Error de validación en campos (código 400).

# Eliminar empleado
**Método** DELETE /api/empleados/{id}
URL: http://localhost:8080/api/empleados/{id}
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
