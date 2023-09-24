package com.mycompany.agente;

import org.springframework.data.repository.CrudRepository;

public interface AgenteRepository extends CrudRepository<Agente, Integer> {
    public Long countById(Integer id);
}