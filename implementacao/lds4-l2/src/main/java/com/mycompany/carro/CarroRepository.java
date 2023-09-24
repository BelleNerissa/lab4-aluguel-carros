package com.mycompany.carro;

import org.springframework.data.repository.CrudRepository;

public interface CarroRepository extends CrudRepository<Carro, Integer> {
    public Long countById(Integer id);
}
