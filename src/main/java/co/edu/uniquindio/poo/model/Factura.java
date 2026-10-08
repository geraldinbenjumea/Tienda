package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public record Factura(String codigo, LocalDate fecha, double total, EstadoFactura Estadofactura,
                      MetodoPago Metodopago, Cliente cliente, ArrayList<DetalleFactura> listaDetalleFacturas, Tienda ownedByTienda) {

}
