package com.ferdev.belajarspring;

import com.ferdev.belajarspring.model.Person;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MainHibernate {
    public static void main(String[] args) {
        // bikin session factory terlebih dahulu
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        // bikin objek untuk dimasukan kedalam database
        Person p1 = new Person();
        p1.setNama("feri");
        p1.setPassword("winartapwd@123");

        Person p2 = new Person();
        p2.setNama("joko");
        p2.setPassword("jko1@23");

        Session session = sessionFactory.openSession(); // buka sesi untuk session

        try {
            session.beginTransaction(); // mulai transaksi
            session.save(p1); // menyimpan / insert ke database
            session.save(p2); // menyimpan / insert ke database
            session.getTransaction().commit(); // jika berhasil transcation commit
        } catch (HibernateException hibernateException) {
            session.getTransaction().rollback(); // jika terjadi error rollback transcaation
        }

        session.close(); // tutup sesi
        sessionFactory.close(); // tutup sesion factory
    }
}







