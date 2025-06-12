package com.example.demo.controller;


import com.example.demo.dto.PagamentoDto;
import com.example.demo.mapper.PagamentoMapper;
import com.example.demo.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService pagamentoService) {
        this.service = pagamentoService;
    }

    @GetMapping
   public ResponseEntity<Page<PagamentoDto>> obterTodosPagamentos(@PageableDefault(size = 10) Pageable paginacao){
        Page<PagamentoDto> pagamentos = service.obterTodosPagamentos(paginacao);
        return ResponseEntity.ok(pagamentos);
    }

    @GetMapping("/id")
    public ResponseEntity<PagamentoDto> obterPagamentoPorId(@RequestParam @NotNull Long id){
        PagamentoDto pagamento = service.obterPorId(id);
        return ResponseEntity.ok(pagamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagamentoDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PagamentoDto dto) {
        PagamentoDto atualizado = service.atualizarPagamento(dto, id);
        return ResponseEntity.ok(atualizado);
    }

    @PostMapping
    public ResponseEntity<PagamentoDto> cadastrar(@RequestBody @Valid PagamentoDto dto) {
        PagamentoDto pagamento = service.criarPagamento(dto);
        URI endereco = URI.create("/pagamentos/" + pagamento.id());
        return ResponseEntity.created(endereco).body(pagamento);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NotNull Long id){
        service.deletarPagamento(id);
        return  ResponseEntity.noContent().build();
    }


}
