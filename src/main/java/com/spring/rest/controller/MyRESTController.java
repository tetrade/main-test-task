package com.spring.rest.controller;

import com.spring.rest.entity.Contract;
import com.spring.rest.entity.ContractStage;
import com.spring.rest.entity.CounterpartyContract;
import com.spring.rest.entity.CounterpartyOrganization;
import com.spring.rest.service.DBSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MyRESTController {

    @Autowired
    private DBSevice dbSevice;

    @GetMapping("/counterparty_contracts")
    public List<CounterpartyContract> showAllCounterpartyContracts() {
        List<CounterpartyContract> allCounterpartyContracts = dbSevice.getAllCounterpartyContracts();
        return allCounterpartyContracts;
    }

    @GetMapping("/counterparty_organizations")
    public List<CounterpartyOrganization> showAllCounterpartyOrganization() {
        List<CounterpartyOrganization> allCounterpartyOrganization = dbSevice.getCounterpartyOrganizations();
        return allCounterpartyOrganization;
    }

    @GetMapping("/contracts")
    public List<Contract> showAllContracts() {
        List<Contract> allContracts = dbSevice.getAllContracts();
        return allContracts;
    }

    @GetMapping("/contracts_stages")
    public List<ContractStage> showAllContractStages() {
        return dbSevice.getAllContractsStages();
    }
}
