package co.edu.uniquindio.poo.model;

import java.util.*;

public class Tienda {

    private final String nombre;
    private final String nit;
    private String telefono;

    private final ArrayList<Cliente> listaClientes = new ArrayList<>();
    private final List<Factura> listaFacturas = new LinkedList<>();
    private Map<String,Producto> listaProductos = new HashMap<>();


    public Tienda(String nombre, String nit,String telefono){
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
    public String registrarCliente(Cliente cliente){
        Optional<Cliente> clienteEncontrado = buscarCliente(cliente.getDocumentoIdentidad());
        if(clienteEncontrado.isEmpty()){
            listaClientes.add(cliente);
            return "El cliente fue registrado exitosamente";
        }else return "No se puede registrar, ya existe un cliente con esa informacion registrado anteriormente.";
    }
    public String actualizarCliente(Cliente clienteActualizado) {
        return buscarCliente(documentoIdentidad)
                .map(clienteExistente -> {
                    clienteExistente.setNombreCompleto(clienteActualizado.getNombreCompleto());
                    clienteExistente.setTelefono(clienteActualizado.getTelefono());
                    clienteExistente.setCorreo(clienteActualizado.getCorreo());
                    return "El cliente fue actualizado exitosamente.";
                })
                .orElse("No se puede actualizar: no existe un cliente con ese documento.");
    }

    // 4. DELETE (Eliminar)
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
    public Optional<Factura> obtenerFactura(String codigo){
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
    public List<String> obtenerCodigos(){
        List<String> resultado = new ArrayList<>();
        for(String codigo: listaProductos.keySet()){
            Producto producto = listaProductos.get(codigo);
            if(producto.getCantidadDisponible()>=10 && producto.getCantidadDisponible()<50){
                resultado.add(codigo);
            }
        }
        return resultado;
    }

    //3. obtener la lista de clientes que hayan comprado el 7 de octubre 2026




    }



