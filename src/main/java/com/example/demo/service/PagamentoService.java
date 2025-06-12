package com.example.demo.service;


import com.example.demo.dto.PagamentoDto;
import com.example.demo.mapper.PagamentoMapper;
import com.example.demo.model.Pagamento;
import com.example.demo.model.Status;
import com.example.demo.repository.PagamentosRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;

@Service
public class PagamentoService {

    private final PagamentosRepository repository;

    public PagamentoService(PagamentosRepository repository) {
        this.repository = repository;
    }

    public Page<PagamentoDto> obterTodosPagamentos(Pageable paginacao){
        return repository.findAll(paginacao).map(PagamentoMapper::toDTO);
    }

    @Transactional
    public PagamentoDto criarPagamento(PagamentoDto dto){
        Pagamento entity = PagamentoMapper.toEntity(dto);
        entity.setStatus(Status.CRIADO);
        repository.save(entity);
        return PagamentoMapper.toDTO(entity);
    }
    public PagamentoDto obterPorId(Long id){
        return repository.findById(id).map(PagamentoMapper::toDTO).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public PagamentoDto atualizarPagamento(PagamentoDto dto, Long id){
        Pagamento entity = PagamentoMapper.toEntity(dto);
        entity.setId(id);
        repository.save(entity);
        return PagamentoMapper.toDTO(entity);
    }
    @Transactional
    public void deletarPagamento(Long id){
        repository.deleteById(id);
    }


}
