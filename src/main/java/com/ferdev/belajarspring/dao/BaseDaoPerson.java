package com.ferdev.belajarspring.dao;


import com.ferdev.belajarspring.model.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class BaseDaoPerson<T> {
    @SuppressWarnings("uncheked")
    protected Class domainClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @SuppressWarnings("uncheked")
    public BaseDaoPerson() {
        this.domainClass = (Class) ((ParameterizedType)
                getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public T save(T domain) {
        return (T) sessionFactory.getCurrentSession().save(domain);
    }

    @SuppressWarnings("uncheked")
    public T getById(long id){
        return (T) sessionFactory.getCurrentSession().get(domainClass, id);
    }

    public void delete(T domain){
        sessionFactory.getCurrentSession().delete(domain);
    }

    @SuppressWarnings("uncheked")
    public Long count(){
        List list = sessionFactory.getCurrentSession().createQuery(
                "select count(id) from " + domainClass.getName() + " x").list();
        Long count = (Long) list.get(0);
        return count;
    }

    @SuppressWarnings("uncheked")
    public List<T> getAll(){
        return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName())
                .list();
    }

    @SuppressWarnings("uncheked")
    public List<T> getAll(int start, int num){
        return sessionFactory.getCurrentSession()
                .createQuery("from " + domainClass.getName())
                .setFirstResult(start).setMaxResults(num)
                .list();
    }


}
