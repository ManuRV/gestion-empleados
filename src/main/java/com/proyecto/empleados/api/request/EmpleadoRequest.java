package com.proyecto.empleados.api.request;

import lombok.Data;


import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
public class EmpleadoRequest {


    @NotNull(message = "El primer nombre es obligatorio")
    private String primerNombre;


    private String segundoNombre;


    @NotNull(message = "El apellido paterno es obligatorio")
    private String apellidoPaterno;


    private String apellidoMaterno;


    @Min(value = 18, message = "La edad mínima permitida es 18")
    @Max(value = 70, message = "La edad máxima permitida es 70")
    private int edad;


    @NotBlank(message = "El sexo es obligatorio")
    private String sexo;


    @NotNull(message = "La fecha de nacimiento es obligatoria")
    private LocalDate fchNacimiento;


    @NotNull(message = "El puesto es obligatoria")
    private String puesto;


    //getters & setters


    public @NotNull(message = "El primer nombre es obligatorio") String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(@NotNull(message = "El primer nombre es obligatorio") String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public @NotNull(message = "El apellido paterno es obligatorio") String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(@NotNull(message = "El apellido paterno es obligatorio") String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Min(value = 18, message = "La edad mínima permitida es 18")
    @Max(value = 70, message = "La edad máxima permitida es 70")
    public int getEdad() {
        return edad;
    }

    public void setEdad(@Min(value = 18, message = "La edad mínima permitida es 18") @Max(value = 70, message = "La edad máxima permitida es 70") int edad) {
        this.edad = edad;
    }

    public @NotBlank(message = "El sexo es obligatorio") String getSexo() {
        return sexo;
    }

    public void setSexo(@NotBlank(message = "El sexo es obligatorio") String sexo) {
        this.sexo = sexo;
    }

    public @NotNull(message = "La fecha de nacimiento es obligatoria") LocalDate getFchNacimiento() {
        return fchNacimiento;
    }

    public void setFchNacimiento(@NotNull(message = "La fecha de nacimiento es obligatoria") LocalDate fchNacimiento) {
        this.fchNacimiento = fchNacimiento;
    }

    public @NotNull(message = "El puesto es obligatoria") String getPuesto() {
        return puesto;
    }

    public void setPuesto(@NotNull(message = "El puesto es obligatoria") String puesto) {
        this.puesto = puesto;
    }
}
