package com.spring.rest.service;

import com.spring.rest.dao.ContractDAO;
import com.spring.rest.dao.ContractStageDAO;
import com.spring.rest.dao.CounterpartyContractDAO;
import com.spring.rest.dao.CounterpartyOrganizationDAO;
import com.spring.rest.entity.Contract;
import com.spring.rest.entity.ContractStage;
import com.spring.rest.entity.CounterpartyContract;
import com.spring.rest.entity.CounterpartyOrganization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DBServiceImpl implements DBSevice {

    @Autowired
    private CounterpartyContractDAO counterpartyContractDAO;

    @Autowired
    private CounterpartyOrganizationDAO counterpartyOrganizationDAO;

    @Autowired
    private ContractStageDAO ContractStageDAO;

    @Autowired
    private ContractDAO contractDAO;

    @Transactional
    public List<CounterpartyContract> getAllCounterpartyContracts() {
        return counterpartyContractDAO.getAllCounterpartyContracts();
    }

    @Transactional
    public List<CounterpartyOrganization> getCounterpartyOrganizations() {
        return counterpartyOrganizationDAO.getAllCounterpartyOrganizations();
    }

    @Transactional
    public List<ContractStage> getAllContractsStages() {
        return ContractStageDAO.getAllContractsStages();
    }

    @Transactional
    public List<Contract> getAllContracts() {
        return contractDAO.getAllContracts();
    }
}
