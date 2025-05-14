package com.proyecto.empleados.controlador;

import com.proyecto.empleados.api.request.EmpleadoRequest;
import com.proyecto.empleados.api.response.EmpleadoResponse;
import com.proyecto.empleados.excepcion.EmpleadoNoEncontradoException;
import com.proyecto.empleados.mapper.EmpleadoMapper;
import com.proyecto.empleados.modelo.Empleado;
import com.proyecto.empleados.service.EmpleadoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {


        private final EmpleadoServiceImpl empleadoServiceImpl;

        @Autowired
        public EmpleadoController(EmpleadoServiceImpl empleadoServiceImpl) {
        this.empleadoServiceImpl = empleadoServiceImpl;
        }


    private static final Logger logger = LoggerFactory.getLogger(EmpleadoController.class);


    //Obtener la lista de empleados
        @GetMapping
        public ResponseEntity<List<EmpleadoResponse>>obtenerListaEmpleados(){
            logger.info("GET /api/empleados - Obtener todos los empleados");
            List<Empleado> empleados = empleadoServiceImpl.getAllEmpleados();
            List<EmpleadoResponse> response = empleados.stream()
                    .map(EmpleadoMapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(response);
        }


        // Obtener un empleado por ID
        @GetMapping("{id}")
        public ResponseEntity<EmpleadoResponse> getEmpleadoById(@PathVariable Long id) {
            logger.info("GET /api/empleados/{} - Obtener empleado por ID", id);
            try {
                Empleado empleado = empleadoServiceImpl.getEmpleadoById(id);
                return ResponseEntity.ok(EmpleadoMapper.toResponse(empleado));
            }catch (EmpleadoNoEncontradoException e) {
                // Captura la excepción personalizada y devuelve un error 404
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null);
            } catch (Exception e) {
                // Captura cualquier otra excepción y devuelve un error 500
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(null);
            }

        }

        //Crear un nuevo empleado
        @PostMapping
        public ResponseEntity<EmpleadoResponse> crearEmpleado(@RequestBody @Valid EmpleadoRequest request) {
            logger.info("POST /api/empleados - Crear empleado: {}", request.getPrimerNombre());
            Empleado empleado = EmpleadoMapper.toEntity(request);
            Empleado creado = empleadoServiceImpl.crearEmpleado(empleado);
            return new ResponseEntity<>(EmpleadoMapper.toResponse(creado), HttpStatus.CREATED);
        }

        //Crear varios empleados
        @PostMapping("/bulk")
        public ResponseEntity<List<EmpleadoResponse>> crearListaEmpleados(@RequestBody @Valid List<EmpleadoRequest> requests) {
            logger.info("POST /api/empleados/bulk - Crear lista de empleados, total: {}", requests.size());
            List<Empleado> empleados = requests.stream()
                    .map(EmpleadoMapper::toEntity)
                    .collect(Collectors.toList());
            List<Empleado> creados = empleadoServiceImpl.crearlistaEmpleados(empleados);
            List<EmpleadoResponse> responses = creados.stream()
                    .map(EmpleadoMapper::toResponse)
                    .collect(Collectors.toList());
            return new ResponseEntity<>(responses, HttpStatus.CREATED);
        }

        //Actualizar empleado
        @PutMapping("{id}")
        public ResponseEntity<EmpleadoResponse> actualizarEmpleado(@PathVariable Long id, @RequestBody @Valid EmpleadoRequest request) {
            logger.info("PUT /api/empleados/{} - Actualizar empleado", id);
            Empleado actualizar = EmpleadoMapper.toEntity(request);
            Empleado actualizado = empleadoServiceImpl.actualizarEmpleado(id, actualizar);
            return ResponseEntity.ok(EmpleadoMapper.toResponse(actualizado));
        }

        //Eliminar empleado
        @DeleteMapping("{id}")
        public ResponseEntity<Void> borrarEmpleado(@PathVariable Long id) {
            logger.info("DELETE /api/empleados/{} - Eliminar empleado", id);
            empleadoServiceImpl.borrarEmpleados(id);
            return ResponseEntity.noContent().build();
        }

}
