package com.company;

import java.io.Serializable;

public class Employee implements Serializable {
    String name;
    String surname;
    Email email;

    /**
     * klasa reprezentujaca pracownika
     * @param name imie pracownika
     * @param surname nazwisko pracownika
     * @param email utworzony meila pracownika
     */
    public Employee (String name, String surname, Email email){
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        this.email = email;
    }

    /**
     * konstruktory do zmiennych klasy pracownika
     * @return umozliwia pobieranie prywatnych zmiennych z klasy
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
