package com.spring.rest.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Table(name="contracts")
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="planned_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date plannedStartDate;

    @Column(name="planned_end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date plannedEndDate;

    @Column(name="actual_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualStartDate;

    @Column(name="actual_end_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date actualEndDate;

    @Column(name="user_id")
    private int userId;

    @Column(name="contract_amount")
    private BigDecimal contractAmount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract2", targetEntity = CounterpartyContract.class)
    private List<CounterpartyContract> counterpartyContracts;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contract1", targetEntity = ContractStage.class)
    private List<ContractStage> contractStages;

    public Contract() {
    }

    public void addCounterpartyContract(CounterpartyContract counterpartyContract) {
        if (counterpartyContracts == null) {
            counterpartyContracts = new ArrayList();
        }
        counterpartyContracts.add(counterpartyContract);
    }

    public void addContractStage(ContractStage contractStage) {
        if (contractStages == null) {
            contractStages = new ArrayList();
        }
        contractStages.add(contractStage);
    }

    public Contract(int id, String name, String type, Date plannedStartDate, Date plannedEndDate, Date actualStartDate, Date actualEndDate, int userId, BigDecimal contractAmount) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.actualStartDate = actualStartDate;
        this.actualEndDate = actualEndDate;
        this.userId = userId;
        this.contractAmount = contractAmount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BigDecimal getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(BigDecimal contractAmount) {
        this.contractAmount = contractAmount;
    }

    public List<CounterpartyContract> getCounterpartyContracts() {
        return counterpartyContracts;
    }

    public void setCounterpartyContracts(List<CounterpartyContract> counterpartyContracts) {
        this.counterpartyContracts = counterpartyContracts;
    }

    public List<ContractStage> getContractStages() {
        return contractStages;
    }

    public void setContractStages(List<ContractStage> contractStages) {
        this.contractStages = contractStages;
    }
}
