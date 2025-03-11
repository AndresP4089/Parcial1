package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        Producto pro1 = new Producto();
        Scanner scn = new Scanner(System.in);
        Scanner scn2 = new Scanner(System.in);
        int opcion1;

        do {
            do {
                System.out.println("\n\n\tMenu principal\n\n1)Crear producto\n2)Vender producto\n3)Reponer stock\n4)Aplicar descuento\n5)Aplicar aumento\n6)Mostrar lista\n7)Calcular total\n8)Eliminar producto");
                System.out.print("Digite la opcion: ");
                opcion1 = scn.nextInt();
            } while(opcion1<=0 || opcion1>8);
            switch(opcion1) {
                case 1:
                    String nombre;
                    double precio;
                    int cantidad;
                    System.out.print("\n\nIngrese el nombre:");
                    //pro1.setNombre(scn.next());
                    nombre = scn2.next();
                    System.out.println();
                    System.out.print("Ingrese el precio:");
                    //pro1.setPrecio(scn.nextDouble());
                    precio = scn.nextDouble();
                    System.out.println();
                    System.out.print("Ingrese la cantidad:");
                    //pro1.setCantidad(scn.nextInt());
                    cantidad = scn.nextInt();
                    System.out.println();
                    //pro1.setCodigo(productos.toArray().length);

                    productos.add(Producto.crearProducto(productos.toArray().length, nombre, precio, cantidad));
                    System.out.println("\n\n\tLista actual");
                    Producto.mostrarLista(productos);
                    break;
                case 2:
                    System.out.println("\n\n\tLista actual");
                    Producto.mostrarLista(productos);
                    int codigo;
                    System.out.print("\n\nIngrese el codigo de producto que desea vender:");
                    codigo = scn.nextInt();
                    System.out.println();
                    System.out.println("Ingrese la cantidad a vender:");
                    productos.get(codigo).venderProducto(scn.nextInt());
                    System.out.println();
                    break;
                case 3:
                    System.out.println("\n\n\tLista actual");
                    Producto.mostrarLista(productos);
                    codigo = 0;
                    System.out.print("\n\nIngrese el codigo de producto que desea reabastecer:");
                    codigo = scn.nextInt();
                    System.out.println();
                    System.out.println("Ingrese la cantidad a reabastecer:");
                    productos.get(codigo).reponerStock(scn.nextInt());
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\n\n\tLista actual");
                    Producto.mostrarLista(productos);
                    codigo = 0;
                    System.out.print("\n\nIngrese el codigo de producto que desea aplicar descuento:");
                    codigo = scn.nextInt();
                    System.out.println();
                    System.out.println("Ingrese el porcentaje:");
                    productos.get(codigo).aplicarDescuento(scn.nextInt());
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\n\n\tLista actual");
                    Producto.mostrarLista(productos);
                    codigo = 0;
                    System.out.print("\n\nIngrese el codigo de producto que desea aplicar aumento:");
                    codigo = scn.nextInt();
                    System.out.println();
                    System.out.println("Ingrese el porcentaje:");
                    productos.get(codigo).aplicarAumento(scn.nextInt());
                    System.out.println();
                    break;
                case 6:
                    Producto.mostrarLista(productos);
                    break;
                case 7:
                    System.out.println("\n\n\tLista actual");
                    Producto.mostrarLista(productos);
                    codigo = 0;
                    System.out.print("\n\nIngrese el codigo de producto que desea conocer el total:");
                    codigo = scn.nextInt();
                    System.out.println();
                    productos.get(codigo).calcularTotal();
                    System.out.println();
                    break;
                case 8:
                    System.out.println("\n\n\tLista actual");
                    Producto.mostrarLista(productos);
                    codigo = 0;
                    System.out.print("\n\nIngrese el codigo de producto que desea eliminar:");
                    codigo = scn.nextInt();
                    Producto.eliminarProducto(productos, codigo);
                    break;
            }

        } while(true);

    }
}