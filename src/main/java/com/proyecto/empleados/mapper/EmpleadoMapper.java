package com.proyecto.empleados.mapper;

import com.proyecto.empleados.api.request.EmpleadoRequest;
import com.proyecto.empleados.api.response.EmpleadoResponse;
import com.proyecto.empleados.modelo.Empleado;

public final class EmpleadoMapper {


    public EmpleadoMapper() {
    }

    // Convierte un EmpleadoRequest en una entidad Empleado
    public static Empleado toEntity(EmpleadoRequest request){
        Empleado emp = new Empleado();

        emp.setPrimerNombre(request.getPrimerNombre());
        emp.setSegundoNombre(request.getSegundoNombre());
        emp.setApellidoPaterno(request.getApellidoPaterno());
        emp.setApellidoMaterno(request.getApellidoMaterno());
        emp.setEdad(request.getEdad());
        emp.setSexo(request.getSexo());
        emp.setFchNacimiento(request.getFchNacimiento());
        emp.setPuesto(request.getPuesto());
        return emp;
    }


    // Convierte una entidad Empleado en un EmpleadoResponse
    public static EmpleadoResponse toResponse(Empleado empleado) {
        EmpleadoResponse resp = new EmpleadoResponse();
        resp.setId(empleado.getId());
        resp.setPrimerNombre(empleado.getPrimerNombre());
        resp.setSegundoNombre(empleado.getSegundoNombre());
        resp.setApellidoPaterno(empleado.getApellidoPaterno());
        resp.setApellidoMaterno(empleado.getApellidoMaterno());
        resp.setEdad(empleado.getEdad());
        resp.setSexo(empleado.getSexo());
        resp.setFchNacimiento(empleado.getFchNacimiento());
        resp.setPuesto(empleado.getPuesto());

        // Opcional: agregar nombre completo
        String nombreCompleto = empleado.getPrimerNombre() + " " +
                (empleado.getSegundoNombre() != null ? empleado.getSegundoNombre() + " " : "") +
                empleado.getApellidoPaterno() + " " +
                (empleado.getApellidoMaterno() != null ? empleado.getApellidoMaterno() : "");
        resp.setNombreCompleto(nombreCompleto.trim());

        return resp;
    }

}
