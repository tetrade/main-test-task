package com.spring.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "counterparty_organizations")
@Entity
public class CounterpartyOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;


    @Column(name="inn")
    private String inn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    @JsonIgnore
    private List<CounterpartyContract> counterpartyContracts;

    public CounterpartyOrganization() {
    }

    public CounterpartyOrganization(int id, String name, String address, String inn) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "CounterpartyOrganization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inn=" + inn +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CounterpartyContract> getCounterpartyContracts() {
        return counterpartyContracts;
    }

    public void addContract(CounterpartyContract contract){
        if (counterpartyContracts == null) {
            counterpartyContracts = new ArrayList();
        }
        counterpartyContracts.add(contract);
    }
    public void setCounterpartyContracts(List<CounterpartyContract> organizations) {
        this.counterpartyContracts = organizations;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
