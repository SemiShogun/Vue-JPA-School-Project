package ch.bbw.jl.calendar.controllers;

import ch.bbw.jl.calendar.models.Continent;
import ch.bbw.jl.calendar.repositories.ContinentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/continent")
public class ContinentController {

    ContinentRepository continentRepository = new ContinentRepository();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Continent> getAllContinents() {
        return continentRepository.getAllContinent();
    }
}
