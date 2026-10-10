package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.*;

public class Tienda {

    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String, Producto> listaProductos = new HashMap<>();


    public Tienda(String nombre, String nit, String telefono) {
        this.nombre = nombre;
        this.nit = nit;
        this.telefono = telefono;
    }

    // setters y getters

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //CRUD CLIENTE---------
    //Uso de la clase Optional
    public String registrarCliente(Cliente cliente) {
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if (clienteEncontrado.isEmpty()) {
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        } else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }

    //actualizar
    public String actualizarCliente(Cliente clienteActualizado, String documentoIdentidad) {
        return buscarCliente(documentoIdentidad)
                .map(clienteExistente -> {
                    clienteExistente.setNombreCompleto(clienteActualizado.getNombreCompleto());
                    clienteExistente.setTelefono(clienteActualizado.getTelefono());
                    clienteExistente.setCorreo(clienteActualizado.getCorreo());
                    return "El cliente fue actualizado exitosamente.";
                })
                .orElse("No se puede actualizar: no existe un cliente con ese documento.");
    }

    // eliminar
    public String eliminarCliente(String documentoIdentidad) {
        return buscarCliente(documentoIdentidad)
                .map(clienteExistente -> {
                    listaClientes.remove(clienteExistente);
                    return "El cliente fue eliminado exitosamente.";
                })
                .orElse("No se puede eliminar: no existe un cliente con ese documento.");
    }

    //Uso de stream, forma declarativa
    public Optional<Cliente> buscarCliente(String documentoIdentidad) {
        return listaClientes.stream().filter(cliente ->
                documentoIdentidad.equals(cliente.getDocumentoIdentidad())).findFirst();
    }

    public Optional<Factura> obtenerFactura(String codigo) {
        return listaFacturas.stream().filter(f -> f.codigo().equals(codigo)).findFirst();
    }


    //    ----- TALLER -----

    //1. Obtener todos los productos con cantidad disponible mayor a 10
    public List<Producto> obtenerProductosCantidadMayor() {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : listaProductos.values()) {
            if (producto.getCantidadDisponible() >= 10) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }


    //2. obtener lista de codigos>=10 y <50
    public List<String> obtenerCodigos() {
        List<String> resultado = new ArrayList<>();
        for (String codigo : listaProductos.keySet()) {
            Producto producto = listaProductos.get(codigo);
            if (producto.getCantidadDisponible() >= 10 && producto.getCantidadDisponible() < 50) {
                resultado.add(codigo);
            }
        }
        return resultado;
    }

    //3. obtener la lista de clientes que hayan comprado el 7 de octubre 2026
    public ArrayList<Cliente> obtenerClientesCompras2(LocalDate fechaConsulta){
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        for (Factura factura : listaFacturas){
            if(factura.fecha().isEqual(fechaConsulta)){
                listaClientes.add(factura.cliente());
            }
        }
        return listaClientes;
    }

    //4.Obener nombres que empiecen con R

    public ArrayList<Factura> obtenerFacturasClienteConR(){
        ArrayList<Factura> resultado = new ArrayList<>();

        for (Factura factura : listaFacturas){
            if(factura.tieneClienteConR()){
                resultado.add(factura);
            }
        }
        return resultado;
    }

    //punto 5:   Obtener las facturas donde se haya comprado un celular de marca Iphone 16 pro max
    public ArrayList<Factura> obtenerFacturasIphone(){
        ArrayList<Factura> resultado = new ArrayList<>();
        for  (Factura factura : listaFacturas){
            if (factura.compraIphone()){
                resultado.add(factura);
            }
        }
        return resultado;
    }

    //punto 6:   Obtener las facturas que tenga un cliente
    // donde su nombre sea juan y haya comprado un celular de marca Iphone 16 pro max


    // Punto 7: Implementar un método que reciba una categoría
    //  y retorne todos los productos registrados que pertenezcan a ella.

    //punto 8 : Implementar un método que reciba un precio mínimo y un precio máximo, y retorne
    // los productos cuyo precio se encuentre dentro de ese rango, incluyendo ambos límites.

    //punto 9: Implementar un método que retorne todos los productos
    // registrados en la tienda, ordenados de menor a mayor según su precio.

    //punto 10: Implementar un método que identifique el producto con el precio más alto de la tienda.
    // Si no existen productos registrados, el método debe retornar un Optional vacío.

    //Punto 11: Implementar un método que reciba el nombre de una ciudad y retorne
    // todos los clientes que residan en ella.
    // La búsqueda debe realizarse sin diferenciar entre mayúsculas y minúsculas.


}


