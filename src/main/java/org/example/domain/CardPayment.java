package org.example.domain;

import jakarta.persistence.Entity;
import org.example.domain.enums.StatePayment;


@Entity
public class CardPayment extends Payment {

    private Integer numeroParcelas;

    public CardPayment() {

    }

    public CardPayment(Integer id, StatePayment statePayment, PurchaseOrder purchaseOrder, Integer numeroParcelas) {
        super(id, statePayment, purchaseOrder);
        this.numeroParcelas = numeroParcelas;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }
}
