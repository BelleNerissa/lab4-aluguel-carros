package com.mycompany.agente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgenteService {
    @Autowired private AgenteRepository repo;

    public List<Agente> listAll() {
        return (List<Agente>) repo.findAll();
    }

    public void save(Agente agente) {
        repo.save(agente);
    }

    public Agente get(Integer id) throws AgenteNotFoundException {
        Optional<Agente> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new AgenteNotFoundException("Não foi possível encontrar " + id);
    }

    public void delete(Integer id) throws AgenteNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new AgenteNotFoundException("Não foi possível encontrar " + id);
        }
        repo.deleteById(id);
    }
}
