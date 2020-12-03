package jl.corona.controller;

import jl.corona.entity.Country;
import jl.corona.repository.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    CountryRepository countryRepository = new CountryRepository();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Country> getAllCountries() {
        return countryRepository.getAllCountry();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCountries(@RequestBody Country country) {
        countryRepository.createCountry(country);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCountry(@RequestBody Country country) {
        countryRepository.updateCountry(country);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCountry(@PathVariable int id) {
        countryRepository.deleteCountry(id);
    }

}
