package ch.bbw.jl.calendar.controllers;

import ch.bbw.jl.calendar.models.Country;
import ch.bbw.jl.calendar.repositories.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}
