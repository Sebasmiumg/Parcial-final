package com.hotel.reservas.Modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "reservas") // Indica la colección en MongoDB
public class Reserva {

    @Id
    private String id; // ID generado automáticamente por MongoDB

    private String nombreCliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tipoHabitacion;

    // Constructor vacío
    public Reserva() {
    }

    // Constructor con parámetros
    public Reserva(String nombreCliente, LocalDate fechaInicio, LocalDate fechaFin, String tipoHabitacion) {
        this.nombreCliente = nombreCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoHabitacion = tipoHabitacion;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                '}';
    }
}
