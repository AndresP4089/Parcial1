package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Cabina> cabinas = new ArrayList<>();

        Scanner scn1 = new Scanner(System.in);
        short opcion1, opcion2;

        do {
            System.out.println("\n\n\tMenú principal");
            System.out.print("\n\n1) Crear cabina\n2) Escoger cabina\n3) Mostrar info por cabina\n4) Mostrar consolidado\n5) Reiniciar cabina\nDigite opcion:");
            opcion1 = scn1.nextShort();

            switch(opcion1) {
                case 1:
                    int codigo = cabinas.toArray().length;
                    System.out.println("\n\n\tCrear cabina");
                    cabinas.add(Cabina.crearCabina(codigo));
                    System.out.println("\n\nCabina creada:");
                    cabinas.get(codigo).mostrarUnaCabina();
                    break;
                case 2:
                    System.out.println("\n\n\tRegistrar llamada");
                    System.out.println("\n\nLista de cabinas disponibles:");
                    //Cabina.mostrarTodasCabinas(cabinas);
                    for(int i=0; i<cabinas.toArray().length; i++){
                        System.out.println("Codigo: "+i);
                    }
                    System.out.print("\n\nDigite el codigo de la cabina por usar: ");
                    opcion1 = scn1.nextShort();
                    System.out.print("\n\nTipo de llamada:\n1) Local\n2) Distancia \n3) Celular\nDigite opcion: ");
                    opcion2 = scn1.nextShort();
                    System.out.println();
                    cabinas.get(opcion1).hacerLlamada(opcion2);
                    cabinas.get(opcion1).mostrarUnaCabina();
                    break;
                case 3:
                    System.out.println("\n\n\tMostrar datos de cabina");
                    System.out.println("\n\nLista de cabinas disponibles:");
                    //Cabina.mostrarTodasCabinas(cabinas);
                    for(int i=0; i<cabinas.toArray().length; i++){
                        System.out.println("Codigo: "+i);
                    }
                    System.out.print("\n\nDigite el codigo de la cabina: ");
                    opcion1 = scn1.nextShort();
                    System.out.println();
                    System.out.print("\n\nDatos de la cabina: ");
                    cabinas.get(opcion1).mostrarUnaCabina();
                    break;
                case 4:
                    System.out.println("\n\n\tConsolidado de cabinas");
                    Cabina.consolidadoCabinas(cabinas);
                    Cabina.mostrarTodasCabinas(cabinas);
                    break;
                case 5:
                    System.out.println("\n\n\tReiniciar cabina");
                    System.out.print("\n\n1) Reiniciar una cabina\n2) Reiniciar todas las cabinas\nDigite opcion: ");
                    opcion2 = scn1.nextShort();
                    System.out.println();
                    switch (opcion2) {
                        case 1:
                            System.out.println("\n\nLista de cabinas disponibles:");
                            //Cabina.mostrarTodasCabinas(cabinas);
                            for(int i=0; i<cabinas.toArray().length; i++){
                                System.out.println("Codigo: "+i);
                            }
                            System.out.print("\n\nDigite el codigo de la cabina a reiniciar: ");
                            opcion1 = scn1.nextShort();
                            System.out.println();
                            cabinas.get(opcion1).reiniciarCabina();
                            System.out.println("\n\nCabina reiniciada:");
                            cabinas.get(opcion1).mostrarUnaCabina();
                            break;
                        case 2:
                            cabinas = Cabina.reiniciarTodasCabinas(cabinas);
                            System.out.println("\n\nCabinas reiniciadas");
                            Cabina.mostrarTodasCabinas(cabinas);
                            break;
                    }
                    break;
                default:
                    System.out.println("Eliga una opcion valida.");
            }

        }while(true);

    }
}