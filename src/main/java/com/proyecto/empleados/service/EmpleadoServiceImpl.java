package com.proyecto.empleados.service;

import com.proyecto.empleados.excepcion.EmpleadoNoEncontradoException;
import com.proyecto.empleados.modelo.Empleado;
import com.proyecto.empleados.repository.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    private static final Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);

    //Recuperar la lista de empleados
    @Override
    public List <Empleado> getAllEmpleados(){
        logger.info("Recuperando todos los empleados...");
        return empleadoRepository.findAll();
    }

    //Recuperar un empleado por Id
    @Override
    public Empleado getEmpleadoById(Long id){
        logger.debug("Buscando empleado con ID: {}", id);
        return empleadoRepository.findById(id).orElseThrow(()->{
            logger.warn("Empleado con ID {} no encontrado", id);
            return new EmpleadoNoEncontradoException("Empleado no encontrado con ID: " + id);
        });
    }

    //Crear un nuevo empleado
    @Override
    public  Empleado crearEmpleado(Empleado empleado){
        logger.info("Creando nuevo empleado: {}", empleado.getPrimerNombre());
        return empleadoRepository.save(empleado);
    }


    //Crear una lista  de empleados
    @Override
    public List <Empleado> crearlistaEmpleados(List<Empleado> empleados){
        logger.info("Creando lista de {} empleados", empleados.size());
        return empleadoRepository.saveAll(empleados);
    }


    //Actualizar Empleado
    @Override
    public Empleado actualizarEmpleado(Long id, Empleado acttualizarEmpleado){
        logger.info("Actualizando empleado con ID: {}", id);
        Empleado existeEmpleado = getEmpleadoById(id);
        existeEmpleado.setPrimerNombre(acttualizarEmpleado.getPrimerNombre());
        existeEmpleado.setSegundoNombre(acttualizarEmpleado.getSegundoNombre());
        existeEmpleado.setApellidoPaterno(acttualizarEmpleado.getApellidoPaterno());
        existeEmpleado.setApellidoMaterno(acttualizarEmpleado.getApellidoMaterno());
        existeEmpleado.setEdad(acttualizarEmpleado.getEdad());
        existeEmpleado.setSexo(acttualizarEmpleado.getSexo());
        existeEmpleado.setFchNacimiento(acttualizarEmpleado.getFchNacimiento());
        existeEmpleado.setPuesto(acttualizarEmpleado.getPuesto());
        return empleadoRepository.save(existeEmpleado);

    }


    //Eliminar empleado
    @Override
    public void  borrarEmpleados(Long id){
        logger.info("Eliminando empleado con ID: {}", id);
        Empleado empleados = getEmpleadoById(id);
        empleadoRepository.delete(empleados);
    }


}
