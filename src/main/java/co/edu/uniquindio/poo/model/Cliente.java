package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {

    private final String documentoIdentidad;
    private  String nombreCompleto;
    private  String telefono;
    private final String ciudadResidencia;
    private  String correo;
    private List<Factura> listaFacturas;
    private final Tienda ownedByTienda;


    public Cliente(String documentoIdentidad, String nombreCompleto, String telefono, String ciudadResidencia,
                   String correo, Tienda ownedByTienda) {
        this.documentoIdentidad = documentoIdentidad;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.ciudadResidencia = ciudadResidencia;
        this.correo = correo;
        this.ownedByTienda= ownedByTienda;
        this.listaFacturas=new ArrayList<>();
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public List<Factura> getListaFacturas() {

        return Collections.unmodifiableList(listaFacturas);
    }

    public Tienda getOwnedByTienda() {
        return ownedByTienda;
    }
}
