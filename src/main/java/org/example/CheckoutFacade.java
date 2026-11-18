package org.example;

// Facade: oferece uma única operação para consultar os setores do hotel.
public class CheckoutFacade {
    public static boolean verificarPendencias(Hospede hospede) {
        if (Consumo.getInstancia().verificarHospedeComPendencia(hospede)) {
            return false;
        }
        if (Lavanderia.getInstancia().verificarHospedeComPendencia(hospede)) {
            return false;
        }
        if (Financeiro.getInstancia().verificarHospedeComPendencia(hospede)) {
            return false;
        }
        return true;
    }
}
