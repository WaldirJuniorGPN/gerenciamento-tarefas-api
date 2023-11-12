package br.com.tarefas.gerenciamentotarefasapi.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String nome,
        @Pattern(regexp = "^(\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$", message = "O CPF deve estar no formato XXX.XXX.XXX-XX.")
        String cpf
) {
}
