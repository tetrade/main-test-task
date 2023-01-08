package com.spring.rest.dao;

import com.spring.rest.entity.Contract;
import com.spring.rest.entity.ContractStage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractStageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<ContractStage> getAllContractsStages() {
        Session session = sessionFactory.getCurrentSession();
        List<ContractStage> contractsStages =
                session.createQuery("from ContractStage", ContractStage.class)
                        .getResultList();
        return contractsStages;
    }
}
