package com.gmail.deamon999.dao;

import java.util.List;

import com.gmail.deamon999.entities.Singer;
import com.gmail.deamon999.repositories.SingerDao;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("singerDao")
@SuppressWarnings("unchecked")
public class SingerDaoImpl implements SingerDao {

    private static final Logger logger = LoggerFactory.getLogger(SingerDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public SingerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Transactional(readOnly = true)
    public List<Singer> findAllWithAlbum() {
        return sessionFactory.getCurrentSession().
                getNamedQuery("Singer.findAllWithAlbum").list();
    }

    @Transactional(readOnly = true)
    public Singer findById(Long id) {
        return (Singer) sessionFactory.getCurrentSession().
                getNamedQuery("Singer.findById").
                setParameter("id", id).uniqueResult();
    }

    public Singer save(Singer singer) {
        sessionFactory.getCurrentSession().saveOrUpdate(singer);
        logger.info("Singer saved with id: " + singer.getId());
        return singer;
    }

    public void delete(Singer singer) {
        sessionFactory.getCurrentSession().delete(singer);
        logger.info("Singer deleted with id: " + singer.getId());
    }
}
