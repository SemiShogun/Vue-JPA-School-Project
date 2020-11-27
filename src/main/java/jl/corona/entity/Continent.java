package jl.corona.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="continent")
@NamedQuery(name="Continent.findAll", query="SELECT e FROM Continent e")
public class Continent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="continent_Id")
    private Long Id;

    @Column(name="continentName", nullable = false)
    private String continentName;

    @OneToMany(mappedBy = "countryName")
    private List<Country> countries;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
