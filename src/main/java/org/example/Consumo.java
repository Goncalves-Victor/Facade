package org.example;

public class Consumo extends Setor {
    private static final Consumo INSTANCIA = new Consumo();

    private Consumo() {
    }

    public static Consumo getInstancia() {
        return INSTANCIA;
    }
}
