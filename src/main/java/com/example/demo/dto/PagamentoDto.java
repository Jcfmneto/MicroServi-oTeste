package com.example.demo.dto;

import com.example.demo.model.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record PagamentoDto(

        @NotNull
        Long id,

        @NotNull
        @Positive
        BigDecimal valor,

        @NotBlank
        String nome,

        @NotBlank
        @Size(max = 19)
        String numero,

        @Size(max = 7)
        String expiracao,

        @NotBlank
        @Size(min = 3, max = 3)
        String codigo,

        @NotNull
        Status status,

        @NotNull
        Long formaDePagamento,

        @NotNull
        Long pedidoId){

}
