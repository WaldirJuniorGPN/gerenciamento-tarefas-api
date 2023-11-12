package br.com.tarefas.gerenciamentotarefasapi.model;

import br.com.tarefas.gerenciamentotarefasapi.dto.request.DadosAtualizacaoUsuario;
import br.com.tarefas.gerenciamentotarefasapi.dto.request.DadosCadastroUsuario;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private boolean ativo;

    public Usuario(DadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.ativo = true;
    }

    public void atualizarDados(DadosAtualizacaoUsuario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
