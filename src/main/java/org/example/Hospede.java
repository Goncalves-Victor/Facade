package org.example;

public class Hospede {
    public boolean realizarCheckout() {
        return CheckoutFacade.verificarPendencias(this);
    }
}
