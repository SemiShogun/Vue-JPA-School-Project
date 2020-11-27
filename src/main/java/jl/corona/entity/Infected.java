package jl.corona.entity;

import javax.persistence.*;

@Entity
@Table(name="infected")
@NamedQuery(name="Infected.findAll", query="SELECT e FROM Infected e")
public class Infected {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="infected_Id")
    private long Id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="surName", nullable = false)
    private String surName;

    @Column(name="age", nullable = false)
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="country_Id")
    private Country country;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
