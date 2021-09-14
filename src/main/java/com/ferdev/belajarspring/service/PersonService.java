package com.ferdev.belajarspring.service;

import com.ferdev.belajarspring.model.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);
    void delete(Person person);
    Long count();
    Person getPerson(Long id);
    List<Person> getPerson();
    List<Person> getPersons(int start, int num);
}
