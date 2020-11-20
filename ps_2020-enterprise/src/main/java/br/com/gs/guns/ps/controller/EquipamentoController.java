package br.com.gs.guns.ps.controller;

import br.com.gs.guns.ps.exception.ResourceNotFoundException;
import br.com.gs.guns.ps.forms.EquipamentoForm;
import br.com.gs.guns.ps.model.Equipamento;
import br.com.gs.guns.ps.repository.EquipamentoRepository;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipamentos")
public class EquipamentoController {

    private EquipamentoRepository equipamentoRepository;

    private EquipamentoController(EquipamentoRepository equipamentoRepository){
        this.equipamentoRepository = equipamentoRepository;
    }

    @GetMapping
    public List<Equipamento> index(){
        return this.equipamentoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Equipamento create(@RequestBody EquipamentoForm equipamentoForm){

        Equipamento equipamento = new Equipamento(
                equipamentoForm.getDataCadastro(),
                equipamentoForm.getModelo());
        return equipamento;
    }

    @GetMapping("{id}")
    public Equipamento getOne(@NotNull @PathVariable int id) {
        Equipamento equipamento = this.equipamentoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return equipamento;
    }
}
