package com.spring.rest.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Table(name="contract_stages")
@Entity
public class ContractStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

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

    @Column(name="stage_amount")
    private BigDecimal stageAmount;

    @Column(name="actual_material_costs")
    private BigDecimal actualMaterialCosts;

    @Column(name="planned_material_costs")
    private BigDecimal plannedMaterialCosts;

    @Column(name="actual_salary_expenses")
    private BigDecimal actualSalaryExpenses;

    @Column(name="planned_salary_expenses")
    private BigDecimal plannedSalaryExpenses;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contract_id")
    @JsonIgnore
    private Contract contract1;

//    public void setContract1(Contract contract) {
//        this.contract1 = contract;
//        contract.addContractStage(this);
//    }

    public ContractStage() {
    }

    public ContractStage(int id, String name, Date plannedStartDate, Date plannedEndDate, Date actualStartDate, Date actualEndDate, BigDecimal stageAmount, BigDecimal actualMaterialCosts, BigDecimal plannedMaterialCosts, BigDecimal actualSalaryExpenses, BigDecimal plannedSalaryExpenses, Contract contract) {
        this.id = id;
        this.name = name;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.actualStartDate = actualStartDate;
        this.actualEndDate = actualEndDate;
        this.stageAmount = stageAmount;
        this.actualMaterialCosts = actualMaterialCosts;
        this.plannedMaterialCosts = plannedMaterialCosts;
        this.actualSalaryExpenses = actualSalaryExpenses;
        this.plannedSalaryExpenses = plannedSalaryExpenses;
        this.contract1 = contract;
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

    public BigDecimal getStageAmount() {
        return stageAmount;
    }

    public void setStageAmount(BigDecimal stageAmount) {
        this.stageAmount = stageAmount;
    }

    public BigDecimal getActualMaterialCosts() {
        return actualMaterialCosts;
    }

    public void setActualMaterialCosts(BigDecimal actualMaterialCosts) {
        this.actualMaterialCosts = actualMaterialCosts;
    }

    public BigDecimal getPlannedMaterialCosts() {
        return plannedMaterialCosts;
    }

    public void setPlannedMaterialCosts(BigDecimal plannedMaterialCosts) {
        this.plannedMaterialCosts = plannedMaterialCosts;
    }

    public BigDecimal getActualSalaryExpenses() {
        return actualSalaryExpenses;
    }

    public void setActualSalaryExpenses(BigDecimal actualSalaryExpenses) {
        this.actualSalaryExpenses = actualSalaryExpenses;
    }

    public BigDecimal getPlannedSalaryExpenses() {
        return plannedSalaryExpenses;
    }

    public void setPlannedSalaryExpenses(BigDecimal plannedSalaryExpenses) {
        this.plannedSalaryExpenses = plannedSalaryExpenses;
    }

    public void setContract1(Contract contract1) {
        this.contract1 = contract1;
    }

    public Contract getContract1() {
        return contract1;
    }
}
