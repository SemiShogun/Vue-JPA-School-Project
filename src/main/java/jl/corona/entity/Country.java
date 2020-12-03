package jl.corona.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT e FROM Country e")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="countryName", nullable = false)
    private String countryName;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonBackReference
    private Continent continent;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Infected> infections;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<Infected> getInfections() {
        return infections;
    }

    public void setInfections(List<Infected> infections) {
        this.infections = infections;
    }
}
