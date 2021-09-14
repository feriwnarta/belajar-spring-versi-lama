package com.ferdev.belajarspring.dao;

import com.ferdev.belajarspring.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// ini kurang maksimal
// lebih baik menggunakan dao dalam bentuk class generic
@Component
public class PersonDaoTanpaGeneric {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(Person person) {
        sessionFactory.getCurrentSession().saveOrUpdate(person);
    }

    public Long count() {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select count(id) from T_Person")
                .uniqueResult();
    }

    public Person getBydId(long id) {
        return (Person) sessionFactory.getCurrentSession()
                .createQuery("from T_Person where id = value")
                .setParameter("value", id)
                .uniqueResult();
    }

    public List<Person> getByAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from T_Person")
                .list();
    }

    public List<Person> getByAll(int start, int num) {
        return sessionFactory.getCurrentSession()
                .createQuery("from T_Person")
                .setFirstResult(start)
                .setFetchSize(num)
                .list();
    }



}
