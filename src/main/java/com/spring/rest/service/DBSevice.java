package com.spring.rest.service;

import com.spring.rest.entity.Contract;
import com.spring.rest.entity.ContractStage;
import com.spring.rest.entity.CounterpartyContract;
import com.spring.rest.entity.CounterpartyOrganization;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DBSevice {

    public List<CounterpartyContract> getAllCounterpartyContracts();

    public List<CounterpartyOrganization> getCounterpartyOrganizations();

    public List<ContractStage> getAllContractsStages();

    public List<Contract> getAllContracts();
}
