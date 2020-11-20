package br.com.gs.guns.ps.controller;

import br.com.gs.guns.ps.exception.ResourceNotFoundException;
import br.com.gs.guns.ps.forms.UsuarioForm;
import br.com.gs.guns.ps.model.Usuario;
import br.com.gs.guns.ps.repository.UsuarioRepository;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> index(){
        return this.usuarioRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Usuario create(@RequestBody UsuarioForm usuarioForm){

        System.out.println(usuarioForm.getDataNascimento());

        Usuario usuario = new Usuario(
                usuarioForm.getCpf(),
                usuarioForm.getNome(),
                usuarioForm.getDataNascimento());
        this.usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping("{id}")
    public Usuario getOne(@NotNull @PathVariable int id) {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        return usuario;
    }
}
