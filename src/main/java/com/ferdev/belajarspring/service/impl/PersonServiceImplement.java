package com.ferdev.belajarspring.service.impl;

import com.ferdev.belajarspring.dao.PersonDao;
import com.ferdev.belajarspring.model.Person;
import com.ferdev.belajarspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personService")
@Transactional(readOnly = true)
public class PersonServiceImplement implements PersonService {

    @Autowired
    private PersonDao personDao;


    @Transactional(readOnly = false)
    public void save(Person person) {
        personDao.save(person);
    }

    @Transactional(readOnly = false)
    public void delete(Person person) {
        personDao.delete(person);
    }


    public Long count() {
        return personDao.count();
    }


    public Person getPerson(Long id) {
        return personDao.getById(id);
    }


    public List<Person> getPerson() {
        return personDao.getAll();
    }

    @Override
    public List<Person> getPersons(int start, int num) {
        return personDao.getAll(start, num);
    }
}
