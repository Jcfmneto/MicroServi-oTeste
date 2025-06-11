package com.example.demo.repository;

import com.example.demo.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentosRepository extends JpaRepository<Pagamento, Long> {

}
