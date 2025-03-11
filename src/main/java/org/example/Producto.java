package org.example;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(int codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static Producto crearProducto(int codigo, String nombre, double precio, int cantidad) {
        boolean isValido = true;
        if(nombre.trim().isEmpty()) {//trim elimina los saltos y isEmpty verifica si está vacio
            System.out.println("\n\nNombre no valido. Registro no realizado");
            isValido=false;
        }
        if (precio<=0) {
            System.out.println("\n\nPrecio no valido. Registo no realizado");
            isValido=false;
        }
        if (cantidad<=0) {
            System.out.println("\n\nCantidad no valida. Registro no realizado");
            isValido=false;
        }
        if(isValido){
            return new Producto(codigo,nombre,precio,cantidad);
        }
        return null;
    }

    public void venderProducto(int cantidad) {
        if(cantidad<=0) {
            System.out.println("\n\nLa cantidad vendida no es válida. Venta no realizada");
        } else if (this.cantidad<cantidad) {
            System.out.println("\n\nLa cantidad en inventario no es suficiente. Venta no realizada");
        } else {
            this.cantidad-=cantidad;
            System.out.println("\n\nVenta completada");
        }
    }

    public void reponerStock(int cantidad){
        if(cantidad<=0){
            System.out.println("\n\nLa cantidad no es valida. Reabastecimiento no realizado");
        } else {
            this.cantidad+=cantidad;
            System.out.println("\n\nReabasteciemiento completado");
        }
    }

    public void aplicarDescuento(int descuento) {
        if(descuento<=0 || descuento>=100){
            System.out.println("\n\nPorcentaje de descuento no válido. Descuento no realizado");
        } else {
            double porcentaje=(double)descuento/100;
            this.precio = this.precio*(1-porcentaje);
            System.out.println("\n\nDescuento completado");
        }
    }

    public void aplicarAumento(int aumento) {
        if(aumento<=0) {
            System.out.println("\n\nPorcentaje de aumento no válido. Aumento no realizado");
        } else {
            double porcentaje=(double)aumento/100;
            this.precio=this.precio*(1+porcentaje);
            System.out.println("Aumento completado");
        }
    }

    public void mostrarDatos(){
        System.out.printf("\n\nCódigo: %d\nNombre: %s\nPrecio: %.2f$\nCantidad: %d\n", this.codigo, this.nombre, this.precio, this.cantidad);
    }

    public void calcularTotal() {
        double total = this.precio * this.cantidad;
        System.out.println("\n\nValor total: " + total+"$");
    }

    public static List<Producto> eliminarProducto(List<Producto> productos, int codigo) {
        int index = -1;

        // Buscar el índice del producto con el código especificado
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == codigo) {
                index = i;
                break;
            }
        }

        // Si se encuentra el producto, eliminarlo y actualizar los códigos
        if (index != -1) {
            productos.remove(index);
            System.out.println("\n\nSe eliminó el producto");

            // Actualizar códigos para que coincidan con el índice
            for (int i = 0; i < productos.size(); i++) {
                productos.get(i).setCodigo(i); // Asignar el nuevo código como el índice
            }
        } else {
            System.out.println("\n\nNo se eliminó ningún producto");
        }

        return productos;
    }

    public static void mostrarLista(List<Producto> productos) {
        for(int i=0; i<productos.toArray().length; i++) {
            productos.get(i).mostrarDatos();
        }
    }

    public static boolean isNull(List<Producto> productos) {
        if(productos==null){
            return true;
        } else {
            return false;
        }
    }
}
