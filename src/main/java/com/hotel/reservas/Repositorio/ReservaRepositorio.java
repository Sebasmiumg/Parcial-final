package com.hotel.reservas.Repositorio;

import com.hotel.reservas.Modelo.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservaRepositorio extends MongoRepository<Reserva, String> {
    // Aquí podrías añadir consultas personalizadas si es necesario
}

