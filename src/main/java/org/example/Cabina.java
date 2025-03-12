package org.example;

import java.util.List;

public class Cabina {
    private int codigoCabina;
    private LLamada llamadas;

    public Cabina(int codigoCabina) {
        this.codigoCabina = codigoCabina;
        llamadas = new LLamada();

    }

    public static Cabina crearCabina(int codigoCabina) {
        return new Cabina(codigoCabina);
    }

    public void mostrarUnaCabina() {
        System.out.println("\n\n--------------------------------------");
        System.out.println("Código cabina: " + this.codigoCabina);
        this.llamadas.mostrarDatos();
    }

    public static void mostrarTodasCabinas(List<Cabina> cabinas) {
        for(Cabina cabina: cabinas) {
            cabina.mostrarUnaCabina();
        }
    }

    public void hacerLlamada(short tipoLlamada) {
        llamadas.realizarLlamada(tipoLlamada);
    }

    public static void consolidadoCabinas(List<Cabina> cabinas) {
        double valor=0, tiempo=0;
        int numLlamadas=0;
        for(Cabina cabina: cabinas){
            valor += cabina.llamadas.calcularTotalValor();
            tiempo += cabina.llamadas.calcularTotalTiempo();
            numLlamadas += cabina.llamadas.calcularTotalLlamadas();
        }
        System.out.println("\n\nTotal de Llamadas: " + numLlamadas + ", Valor total: $" + valor + ", Tiempo total: " + tiempo + "min");
    }

    public void reiniciarCabina() {
        llamadas.reiniciarDatos();
    }

}
