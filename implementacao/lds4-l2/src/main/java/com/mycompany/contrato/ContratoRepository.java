package com.mycompany.contrato;

import org.springframework.data.repository.CrudRepository;

public interface ContratoRepository extends CrudRepository<Contrato, Integer> {
    public Long countById(Integer id);
}