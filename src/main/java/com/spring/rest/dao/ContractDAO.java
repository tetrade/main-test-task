package com.spring.rest.dao;

import com.spring.rest.entity.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContractDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Contract> getAllContracts() {
        Session session = sessionFactory.getCurrentSession();
        List<Contract> contracts =
                session.createQuery("from Contract", Contract.class)
                        .getResultList();
        return contracts;
    }
}
