package ch.bbw.jl.calendar.controllers;

import ch.bbw.jl.calendar.models.Infected;
import ch.bbw.jl.calendar.repositories.InfectedRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infected")
public class InfectedController {

    InfectedRepository infectedRepository = new InfectedRepository();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Infected> getAllInfected() {
        return infectedRepository.getAllInfected();
    }
}
