package com.pds.pdssr.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Service
public class EtlFileService {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private EtlFileService etlFileService;

    public SessionFactory getSessionFactory() {
        if (this.entityManagerFactory == null) {
            throw new IllegalStateException("EntityManagerFactory is null");
        }
        return this.entityManagerFactory.unwrap(SessionFactory.class);
    }

    // Client that call this method should be inside spring's transaction boundaries. No, this method could not start
    // its own transaction (well I guess it can, but with further tweak and configuration).
    public void doSomethingWithSessionFactory() {
        Session session = this.getSessionFactory().getCurrentSession();
        session.createQuery("from EtlFile ef").getResultList();
    }
}
