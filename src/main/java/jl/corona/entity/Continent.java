package jl.corona.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="continent")
@NamedQuery(name="Continent.findAll", query="SELECT e FROM Continent e")
public class Continent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="continentName", nullable = false)
    private String continentName;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "continent", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Country> countries;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
