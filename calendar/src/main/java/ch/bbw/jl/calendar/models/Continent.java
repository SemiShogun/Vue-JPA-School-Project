package ch.bbw.jl.calendar.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="continent")
@NamedQuery(name="Continent.findAll", query="SELECT e FROM Continent e")
public class Continent {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="Id")
    private Long Id;

    @Column(name="continentName")
    private String continentName;

    @OneToMany
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
