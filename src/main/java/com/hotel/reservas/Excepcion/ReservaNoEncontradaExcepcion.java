package com.hotel.reservas.Excepcion;

public class ReservaNoEncontradaExcepcion extends RuntimeException {
    public ReservaNoEncontradaExcepcion(String mensaje) {
        super(mensaje);
    }
}
