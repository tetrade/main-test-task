package com.spring.rest.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "counterparty_contracts")
@Entity
public class CounterpartyContract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "counterparty_organization_id")
    private CounterpartyOrganization organization;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contract_id")
    @JsonIgnore
    private Contract contract2;

    @Column(name="amount")
    private int amount;

    @Column(name= "actual_start_date")
    private Date actualStartDate;

    @Column(name= "actual_end_date")
    private Date actualEndDate;

    @Column(name= "planned_start_date")
    private Date plannedStartDate;

    @Column(name= "planned_end_date")
    private Date plannedEndDate;


    public CounterpartyContract() {
    }

    public Contract getContract2() {
        return contract2;
    }

//    public void setContract2(Contract contract) {
//        this.contract2 = contract;
//        contract.addCounterpartyContract(this);
//    }

    public CounterpartyContract(int id, String name, String type, CounterpartyOrganization organization, Contract contract, int amount, Date actualStartDate, Date actualEndDate, Date plannedStartDate, Date plannedEndDate) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.organization = organization;
        this.contract2 = contract;
        this.amount = amount;
        this.actualStartDate = actualStartDate;
        this.actualEndDate = actualEndDate;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
    }

//    public void setCounterpartyOrganization(CounterpartyOrganization organization) {
//        this.organization = organization;
//        organization.addContract(this);
//    }


    public void setContract2(Contract contract2) {
        this.contract2 = contract2;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CounterpartyOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(CounterpartyOrganization organization) {
        this.organization = organization;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    @Override
    public String toString() {
        return "CounterpartyContract{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", organization=" + organization +
                ", contract=" + contract2 +
                ", amount=" + amount +
                ", actualStartDate=" + actualStartDate +
                ", actualEndDate=" + actualEndDate +
                ", plannedStartDate=" + plannedStartDate +
                ", plannedEndDate=" + plannedEndDate +
                '}';
    }
}
