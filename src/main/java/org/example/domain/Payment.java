package org.example.domain;

import jakarta.persistence.*;
import org.example.domain.enums.StatePayment;

import java.io.Serializable;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {

    @Id
    private Integer id;
    private Integer statePayment;

    @OneToOne
    @JoinColumn(name = "purchaseOrder_id")
    @MapsId
    private PurchaseOrder purchaseOrder;

    public Payment() {

    }

    public Payment(Integer id, StatePayment statePayment, PurchaseOrder purchaseOrder) {
        this.id = id;
        this.statePayment = statePayment.getCod();
        this.purchaseOrder = purchaseOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StatePayment getStatePayment() {
        return StatePayment.toEnum(statePayment);
    }

    public void setStatePayment(StatePayment statePayment) {
        this.statePayment = statePayment.getCod();
    }

    public PurchaseOrder getOrder() {
        return purchaseOrder;
    }

    public void setOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Payment payment = (Payment) o;

        return id.equals(payment.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
