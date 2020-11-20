package br.com.gs.guns.ps.controller;

import br.com.gs.guns.ps.exception.ResourceNotFoundException;
import br.com.gs.guns.ps.forms.DigitalForm;
import br.com.gs.guns.ps.model.Digital;
import br.com.gs.guns.ps.repository.DigitalRepository;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("digitais")
public class DigitalController {

    private DigitalRepository digitalRepository;

    private DigitalController(DigitalRepository digitalRepository) {
        this.digitalRepository = digitalRepository;
    }

    @GetMapping
    public List<Digital> index(){
        return this.digitalRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Digital create(@RequestBody DigitalForm digitalForm){

        Digital digital = new Digital(
                digitalForm.getDescricao());
        return digital;
    }

    @GetMapping("{id}")
    public Digital getOne(@NotNull @PathVariable int id) {
        Digital digital = this.digitalRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return digital;
    }
}
