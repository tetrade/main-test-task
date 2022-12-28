package com.spring.rest.dao;

import com.spring.rest.entity.CounterpartyOrganization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CounterpartyOrganizationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<CounterpartyOrganization> getAllCounterpartyOrganizations() {
        Session session = sessionFactory.getCurrentSession();
        List<CounterpartyOrganization> counterpartyOrganizations =
                session.createQuery("from CounterpartyOrganization", CounterpartyOrganization.class)
                        .getResultList();
        return counterpartyOrganizations;
    }
}
