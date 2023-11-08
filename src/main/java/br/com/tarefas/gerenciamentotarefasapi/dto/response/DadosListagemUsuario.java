package br.com.tarefas.gerenciamentotarefasapi.dto.response;

import br.com.tarefas.gerenciamentotarefasapi.model.Usuario;

public record DadosListagemUsuario(Long id, String nome) {
    public DadosListagemUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome());
    }
}
