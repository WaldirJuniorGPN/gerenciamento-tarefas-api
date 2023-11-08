package br.com.tarefas.gerenciamentotarefasapi.repository;

import br.com.tarefas.gerenciamentotarefasapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
