package br.com.tarefas.gerenciamentotarefasapi.controller;

import br.com.tarefas.gerenciamentotarefasapi.dto.request.DadosAtualizacaoUsuario;
import br.com.tarefas.gerenciamentotarefasapi.dto.request.DadosCadastroUsuario;
import br.com.tarefas.gerenciamentotarefasapi.dto.response.DadosDetalhamentoUsuario;
import br.com.tarefas.gerenciamentotarefasapi.dto.response.DadosListagemUsuario;
import br.com.tarefas.gerenciamentotarefasapi.model.Usuario;
import br.com.tarefas.gerenciamentotarefasapi.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = new Usuario(dados);
        var uri = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        this.usuarioRepository.save(usuario);
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listar(Pageable pageable) {
        var page = this.usuarioRepository.findAllByAtivoTrue(pageable).map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {
        var usuario = this.usuarioRepository.getReferenceById(dados.id());
        usuario.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id) {
        var usuario = this.usuarioRepository.getReferenceById(id);
        usuario.desativar();
        return ResponseEntity.noContent().build();
    }

}
