package jl.corona.controller;

import jl.corona.entity.Infected;
import jl.corona.repository.InfectedRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createInfected(@RequestBody Infected infected) {
        infectedRepository.createInfected(infected);
    }
}
