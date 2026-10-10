package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate fecha, double total, EstadoFactura Estadofactura,
                      MetodoPago Metodopago, Cliente cliente, ArrayList<DetalleFactura> listaDetalleFacturas, Tienda ownedByTienda) {

    @Override
    public String codigo() {
        return codigo;
    }

    @Override
    public LocalDate fecha() {
        return fecha;
    }

    @Override
    public double total() {
        return total;
    }

    @Override
    public EstadoFactura Estadofactura() {
        return Estadofactura;
    }

    @Override
    public MetodoPago Metodopago() {
        return Metodopago;
    }

    @Override
    public Cliente cliente() {
        return cliente;
    }

    @Override
    public ArrayList<DetalleFactura> listaDetalleFacturas() {
        return listaDetalleFacturas;
    }

    @Override
    public Tienda ownedByTienda() {
        return ownedByTienda;
    }


    public boolean tieneClienteConR() {

        boolean resultado = false;
        resultado = cliente.verificarNombreConR();
        return resultado ;
    }

    public boolean compraIphone() {
        boolean resultado = false;
        resultado= cliente.compraIphone();
        return resultado;
    }
}
