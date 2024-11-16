package com.hotel.reservas.Controlador;

import com.hotel.reservas.Modelo.Reserva;
import com.hotel.reservas.Servicio.ReservaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaControlador {

    @Autowired
    private ReservaServicio reservaServicio;

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaServicio.listarReservas();
    }

    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaServicio.crearReserva(reserva);
    }

    @PutMapping("/{id}")
    public Reserva actualizarReserva(@PathVariable String id, @RequestBody Reserva reserva) {
        return reservaServicio.actualizarReserva(id, reserva);
    }

    @DeleteMapping("/{id}")
    public void cancelarReserva(@PathVariable String id) {
        reservaServicio.cancelarReserva(id);
    }
}

