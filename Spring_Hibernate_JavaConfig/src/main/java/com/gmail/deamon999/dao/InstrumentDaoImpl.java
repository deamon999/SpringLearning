package com.gmail.deamon999.dao;

import com.gmail.deamon999.entities.Instrument;
import com.gmail.deamon999.repositories.InstrumentDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("instrumentDao")
public class InstrumentDaoImpl implements InstrumentDao {

    private static final Logger logger = LoggerFactory.getLogger(InstrumentDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public InstrumentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Instrument save(Instrument instrument) {
        sessionFactory.getCurrentSession().saveOrUpdate(instrument);
        logger.info("Instrument saved with id: " + instrument.getInstrumentName());
        return instrument;
    }
}