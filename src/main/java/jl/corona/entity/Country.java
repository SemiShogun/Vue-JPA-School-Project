package jl.corona.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT e FROM Country e")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="country_Id")
    private long Id;

    @Column(name="countryName", nullable = false)
    private String countryName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="continent_Id")
    private Continent continent;

    @OneToMany(mappedBy="name")
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
