package com.spring.dynamic.web.dao.impl;

import com.spring.dynamic.web.dao.HotelDao;
import com.spring.dynamic.web.model.Hotel;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class HotelDaoImpl extends HibernateDaoSupport implements HotelDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    DataSource dataSource;

//    JdbcTemplate jdbcTemplate;
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    public HotelDaoImpl(SessionFactory sessionfactory){
        setSessionFactory(sessionfactory);
    }

    public Hotel get(Long id) {
        return (Hotel) sessionFactory.getCurrentSession().get(Hotel.class, id);
    }

    public void delete(Hotel hotel) {
        sessionFactory.getCurrentSession().delete(hotel);
    }

    @SuppressWarnings("unchecked")
    public List<Hotel> findAll() {
        return sessionFactory.getCurrentSession().createQuery(
                "FROM Hotel ORDER BY id")
                .list();
    }

    public void save(Hotel hotel) {
        sessionFactory.getCurrentSession().merge(hotel);

    }

    public void update(Hotel hotel) {
        getHibernateTemplate().update(hotel);
    }

}
