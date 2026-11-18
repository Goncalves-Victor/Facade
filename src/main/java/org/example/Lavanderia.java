package org.example;

public class Lavanderia extends Setor {
    private static final Lavanderia INSTANCIA = new Lavanderia();

    private Lavanderia() {
    }

    public static Lavanderia getInstancia() {
        return INSTANCIA;
    }
}
