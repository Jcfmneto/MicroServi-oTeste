package com.example.demo.model;

import com.example.demo.model.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pagamentos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 19)
    private String numero;

    @Size(max = 7)
    private String expiracao;
    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotNull
    private Long pedidoId;
    @NotNull
    private Long formaDePagamentoId;
}