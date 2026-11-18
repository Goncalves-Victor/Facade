package org.example;

import java.util.HashSet;
import java.util.Set;

public abstract class Setor {
    private final Set<Hospede> hospedesComPendencia = new HashSet<>();

    public void addHospedePendente(Hospede hospede) {
        hospedesComPendencia.add(hospede);
    }

    public void removerHospedePendente(Hospede hospede) {
        hospedesComPendencia.remove(hospede);
    }

    public boolean verificarHospedeComPendencia(Hospede hospede) {
        return hospedesComPendencia.contains(hospede);
    }
}
