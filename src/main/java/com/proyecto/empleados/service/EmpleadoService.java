package com.proyecto.empleados.service;

import com.proyecto.empleados.modelo.Empleado;

import java.util.List;

public interface EmpleadoService {

        List<Empleado> getAllEmpleados();
        Empleado getEmpleadoById(Long id);
        Empleado crearEmpleado(Empleado empleado);
        List<Empleado> crearlistaEmpleados(List<Empleado> empleados);
        Empleado actualizarEmpleado(Long id, Empleado empleado);
        void borrarEmpleados(Long id);
    }

