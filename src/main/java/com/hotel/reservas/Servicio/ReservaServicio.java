package com.hotel.reservas.Servicio;

import com.hotel.reservas.Excepcion.ReservaNoEncontradaExcepcion;
import com.hotel.reservas.Modelo.Reserva;
import com.hotel.reservas.Repositorio.ReservaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    public List<Reserva> listarReservas() {
        return reservaRepositorio.findAll(); // Método de MongoRepository
    }

    public Reserva crearReserva(Reserva reserva) {
        return reservaRepositorio.save(reserva); // Método de MongoRepository
    }

    public Reserva actualizarReserva(String id, Reserva nuevaReserva) {
        Reserva reserva = reservaRepositorio.findById(id)
                .orElseThrow(() -> new ReservaNoEncontradaExcepcion("Reserva no encontrada con ID: " + id));

        reserva.setNombreCliente(nuevaReserva.getNombreCliente());
        reserva.setFechaInicio(nuevaReserva.getFechaInicio());
        reserva.setFechaFin(nuevaReserva.getFechaFin());
        reserva.setTipoHabitacion(nuevaReserva.getTipoHabitacion());

        return reservaRepositorio.save(reserva); // Actualiza la reserva existente
    }

    public void cancelarReserva(String id) {
        if (!reservaRepositorio.existsById(id)) {
            throw new ReservaNoEncontradaExcepcion("Reserva no encontrada con ID: " + id);
        }
        reservaRepositorio.deleteById(id); // Método para eliminar
    }
}



