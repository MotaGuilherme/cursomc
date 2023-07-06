package org.example.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.example.domain.enums.ClientType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String cpfOuCnpj;
    private Integer type;

    @JsonManagedReference
    @OneToMany(mappedBy = "client")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "telephone")
    private Set<String> telefones = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private List<PurchaseOrder> purchaseOrders = new ArrayList<>();

    public Client() {

    }

    public Client(Integer id, String name, String email, String cpfOuCnpj, ClientType type) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.type = type.getCod();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public ClientType getType() {
        return ClientType.toEnum(type);
    }

    public void setType(ClientType type) {
        this.type = type.getCod();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public List<PurchaseOrder> getOrders() {
        return purchaseOrders;
    }

    public void setOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
