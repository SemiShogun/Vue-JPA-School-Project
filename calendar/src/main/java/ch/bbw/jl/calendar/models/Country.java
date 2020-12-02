package ch.bbw.jl.calendar.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT e FROM Country e")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Id")
    private long Id;

    @Column(name="countryName")
    private String countryName;

    @OneToOne
    private Continent continent;

    @OneToMany
    private List<Infected> infections;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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
