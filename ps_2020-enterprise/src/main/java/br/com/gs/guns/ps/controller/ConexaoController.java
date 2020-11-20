package br.com.gs.guns.ps.controller;


import br.com.gs.guns.ps.exception.ResourceNotFoundException;
import br.com.gs.guns.ps.forms.ConexaoForm;
import br.com.gs.guns.ps.model.Conexao;
import br.com.gs.guns.ps.repository.ConexaoRepository;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("conexoes")
public class ConexaoController {
    private ConexaoRepository conexaoRepository;

    private ConexaoController(ConexaoRepository conexaoRepository) {
        this.conexaoRepository = conexaoRepository;
    }

    @GetMapping
    public List<Conexao> index(){
        return this.conexaoRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Conexao create(@RequestBody ConexaoForm conexaoForm){

        Conexao conexao = new Conexao(
                conexaoForm.getDataConmexao(),
                conexaoForm.getStatus());
        return conexao;
    }

    @GetMapping("{id}")
    public Conexao getOne(@NotNull @PathVariable int id) {
        Conexao conexao = this.conexaoRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return conexao;
    }
}
