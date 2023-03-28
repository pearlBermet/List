package com.webtest.testt.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "students")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "password")
    private Integer password;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "absence")
    private Integer absence;
    @Column(name = "bonus")
    private Integer bonus;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> role;

    public User(){
    }

    public User(String name, String surname, Integer password, Integer grade,Integer absence, Integer bonus) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.grade = grade;
        this.absence = absence;
        this.bonus = bonus;
    }

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

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getAbsence() {
        return absence;
    }

    public void setAbsence(Integer absence) {
        this.absence = absence;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public Collection<Role> getRole() {
        return Role;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }
}
