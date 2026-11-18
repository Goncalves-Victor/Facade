package org.example;

public class Financeiro extends Setor {
    private static final Financeiro INSTANCIA = new Financeiro();

    private Financeiro() {
    }

    public static Financeiro getInstancia() {
        return INSTANCIA;
    }
}
