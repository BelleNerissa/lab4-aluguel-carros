package com.mycompany.contrato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {
    @Autowired private ContratoRepository repo;

    public List<Contrato> listAll() {
        return (List<Contrato>) repo.findAll();
    }

    public void save(Contrato contrato) {
        repo.save(contrato);
    }

    public Contrato get(Integer id) throws ContratoNotFoundException {
        Optional<Contrato> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ContratoNotFoundException("Não foi possível encontrar " + id);
    }

    public void delete(Integer id) throws ContratoNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new ContratoNotFoundException("Não foi possível encontrar " + id);
        }
        repo.deleteById(id);
    }
}
