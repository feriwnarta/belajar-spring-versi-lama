package com.ferdev.belajarspring;

import com.ferdev.belajarspring.model.Person;
import com.ferdev.belajarspring.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext appContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService =
                (PersonService) appContext.getBean("personService");

        Person person = new Person();
        person.setNama("asdad");
        person.setPassword("123@");

        personService.save(person);


    }
}
