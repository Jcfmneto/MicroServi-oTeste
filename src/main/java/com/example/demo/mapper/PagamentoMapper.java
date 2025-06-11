package com.example.demo.mapper;

import com.example.demo.dto.PagamentoDto;
import com.example.demo.model.Pagamento;

public class PagamentoMapper {


    public static PagamentoDto toDTO(Pagamento entity) {
        if (entity == null) return null;

        return new PagamentoDto(
                entity.getId(),
                entity.getValor(),
                entity.getNome(),
                entity.getNumero(),
                entity.getExpiracao(),
                entity.getCodigo(),
                entity.getStatus(),
                entity.getPedidoId(),
                entity.getFormaDePagamentoId()
        );
    }


    public static Pagamento toEntity(PagamentoDto dto) {
        if(dto == null) return null;

        Pagamento entity = new Pagamento();
        entity.setId(dto.id());
        entity.setValor(dto.valor());
        entity.setNome(dto.nome());
        entity.setNumero(dto.numero());
        entity.setExpiracao(dto.expiracao());
        entity.setCodigo(dto.codigo());
        entity.setStatus(dto.status());
        entity.setPedidoId(dto.pedidoId());
        entity.setFormaDePagamentoId(dto.formaDePagamento());

        return entity;

    }
}
