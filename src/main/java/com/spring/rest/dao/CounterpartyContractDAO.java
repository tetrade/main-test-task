package com.spring.rest.dao;

import com.spring.rest.entity.CounterpartyContract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CounterpartyContractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<CounterpartyContract> getAllCounterpartyContracts() {
        Session session = sessionFactory.getCurrentSession();
        List<CounterpartyContract> counterpartyContracts =
                session.createQuery("from CounterpartyContract", CounterpartyContract.class)
                        .getResultList();
        return counterpartyContracts;
    }
}
