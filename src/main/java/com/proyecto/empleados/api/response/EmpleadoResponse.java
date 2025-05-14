package com.proyecto.empleados.api.response;

import java.io.Serializable;
import java.time.LocalDate;

public class EmpleadoResponse implements Serializable {

    private Long id;

    private String primerNombre;

    private String segundoNombre;

    private String apellidoPaterno;

    private String apellidoMaterno;

    private int edad;

    private String sexo;

    private LocalDate fchNacimiento;

    private String puesto;

    // Campo extra opcional si se devuelve el nombre completo ya armado
    private String nombreCompleto;

        //Getters & Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFchNacimiento() {
        return fchNacimiento;
    }

    public void setFchNacimiento(LocalDate fchNacimiento) {
        this.fchNacimiento = fchNacimiento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}
