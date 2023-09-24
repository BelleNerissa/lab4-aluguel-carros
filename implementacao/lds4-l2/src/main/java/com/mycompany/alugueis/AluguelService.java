package com.mycompany.alugueis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {
    @Autowired private AluguelRepository repo;

    public List<Aluguel> listAll() {
        return (List<Aluguel>) repo.findAll();
    }

    public void save(Aluguel aluguel) {
        repo.save(aluguel);
    }

    public Aluguel get(Integer id) throws AluguelNotFoundException {
        Optional<Aluguel> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new AluguelNotFoundException("Não foi possível encontrar " + id);
    }

    public void delete(Integer id) throws AluguelNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new AluguelNotFoundException("Não foi possível encontrar " + id);
        }
        repo.deleteById(id);
    }
}
