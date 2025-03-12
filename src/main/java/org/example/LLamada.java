package org.example;

import java.util.Random;

public class LLamada {
    private int numLlamadaLocal;
    private int numLLamadaDistancia;
    private int numLlamadaCelular;
    final private double precioLocal = 50;
    final private double precioDistancia = 350;
    final private double precioCelular = 150;
    private double duracionLocal;
    private double duracionDistancia;
    private double duracionCelular;
    private double totalLocal;
    private double totalDistancia;
    private double totalCelular;
    private Random random;

    public LLamada() {
        this.numLlamadaLocal = 0;
        this.numLLamadaDistancia = 0;
        this.numLlamadaCelular = 0;
        this.duracionLocal = 0;
        this.duracionDistancia = 0;
        this.duracionCelular = 0;
        this.totalLocal = 0;
        this.totalDistancia = 0;
        this.totalCelular = 0;
        random = new Random();
    }

    public void mostrarDatos() {

        actualizarTotalValor();

        System.out.println("Detalles de las llamadas:");
        System.out.println("Llamadas Locales: " + numLlamadaLocal + ", Precio: $" + precioLocal + ", Duración: " + duracionLocal + " min, Total: $" + totalLocal);
        System.out.println("Llamadas de Larga Distancia: " + numLLamadaDistancia + ", Precio: $" + precioDistancia + ", Duración: " + duracionDistancia + " min, Total: $" + totalDistancia);
        System.out.println("Llamadas a Celular: " + numLlamadaCelular + ", Precio: $" + precioCelular + ", Duración: " + duracionCelular + " min, Total: $" + totalCelular);
    }

    public void realizarLlamada (short tipoLlamada){
        boolean realizada = false;
        double tiempoLlamada = Math.round((1 + (random.nextDouble() * 59)) * 1000.0) / 1000.0;
        switch(tipoLlamada) {
            case 1:
                this.numLlamadaLocal++;
                this.duracionLocal+=tiempoLlamada;
                realizada = true;
                break;
            case 2:
                this.numLLamadaDistancia++;
                this.duracionDistancia+=tiempoLlamada;
                realizada = true;
                break;
            case 3:
                this.numLlamadaCelular++;
                this.duracionCelular+=tiempoLlamada;
                realizada = true;
                break;
            default:
                System.out.println("\n\nOpcion invalida. Intente otra vez.");
        }

        if(realizada) {
            System.out.printf("\n\nLlamada completada\nDuracion: %.2fmin",tiempoLlamada);
        }

        actualizarTotalValor();
    }

    public void actualizarTotalValor() {
        totalLocal = numLlamadaLocal * precioLocal;
        totalDistancia = numLLamadaDistancia * precioDistancia;
        totalCelular = numLlamadaCelular * precioCelular;
    }

    public int calcularTotalLlamadas() {
        return numLlamadaCelular+numLlamadaLocal+numLLamadaDistancia;
    }

    public double calcularTotalValor() {
        actualizarTotalValor();
        return totalCelular+totalDistancia+totalLocal;
    }

    public double calcularTotalTiempo() {
        return duracionCelular+duracionLocal+duracionDistancia;
    }

    public void reiniciarDatos() {
        this.numLlamadaLocal = 0;
        this.numLLamadaDistancia = 0;
        this.numLlamadaCelular = 0;
        this.duracionLocal = 0;
        this.duracionDistancia = 0;
        this.duracionCelular = 0;
        this.totalLocal = 0;
        this.totalDistancia = 0;
        this.totalCelular = 0;
    }

}
