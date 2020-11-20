package br.com.gs.guns.ps.repository;

import br.com.gs.guns.ps.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
