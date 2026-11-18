package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospedeTest {
    private final Hospede hospede = new Hospede();

    @AfterEach
    void removerPendencias() {
        Consumo.getInstancia().removerHospedePendente(hospede);
        Lavanderia.getInstancia().removerHospedePendente(hospede);
        Financeiro.getInstancia().removerHospedePendente(hospede);
    }

    @Test
    void devePermitirCheckoutSemPendencias() {
        assertTrue(hospede.realizarCheckout());
    }

    @Test
    void naoDevePermitirCheckoutComPendenciaDeConsumo() {
        Consumo.getInstancia().addHospedePendente(hospede);
        assertFalse(hospede.realizarCheckout());
    }

    @Test
    void naoDevePermitirCheckoutComPendenciaNaLavanderia() {
        Lavanderia.getInstancia().addHospedePendente(hospede);
        assertFalse(hospede.realizarCheckout());
    }

    @Test
    void naoDevePermitirCheckoutComPendenciaFinanceira() {
        Financeiro.getInstancia().addHospedePendente(hospede);
        assertFalse(hospede.realizarCheckout());
    }

    @Test
    void devePermitirCheckoutSomenteAposResolverTodasAsPendencias() {
        Consumo.getInstancia().addHospedePendente(hospede);
        Lavanderia.getInstancia().addHospedePendente(hospede);
        Financeiro.getInstancia().addHospedePendente(hospede);
        assertFalse(hospede.realizarCheckout());

        Consumo.getInstancia().removerHospedePendente(hospede);
        assertFalse(hospede.realizarCheckout());

        Lavanderia.getInstancia().removerHospedePendente(hospede);
        assertFalse(hospede.realizarCheckout());

        Financeiro.getInstancia().removerHospedePendente(hospede);
        assertTrue(hospede.realizarCheckout());
    }

    @Test
    void pendenciaNaoDeveAfetarOutroHospede() {
        Financeiro.getInstancia().addHospedePendente(hospede);
        Hospede outroHospede = new Hospede();

        assertFalse(hospede.realizarCheckout());
        assertTrue(outroHospede.realizarCheckout());
    }
}
