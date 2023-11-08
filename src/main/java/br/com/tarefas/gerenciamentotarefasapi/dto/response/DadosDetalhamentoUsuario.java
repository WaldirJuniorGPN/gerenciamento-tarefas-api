package br.com.tarefas.gerenciamentotarefasapi.dto.response;

import br.com.tarefas.gerenciamentotarefasapi.model.Usuario;

public record DadosDetalhamentoUsuario(Long id, String nome, String cpf) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(usuario.getId(), usuario.getNome(), usuario.getCpf());
    }
}
