package org.example.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
public class PurchaseOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
    private Payment payment;


    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public PurchaseOrder() {

    }

    public PurchaseOrder(Integer id, Date instante, Client client, Address address) {
        this.id = id;
        this.instante = instante;
        this.client = client;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instante) {
        this.instante = instante;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseOrder purchaseOrder = (PurchaseOrder) o;

        return id.equals(purchaseOrder.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
