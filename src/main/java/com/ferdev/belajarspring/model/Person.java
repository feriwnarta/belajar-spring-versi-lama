package com.ferdev.belajarspring.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_Person")
public class Person implements Serializable {
    // mapping kedatabase
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true, length = 100)
    private String nama;
    @Column(length = 100)
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
