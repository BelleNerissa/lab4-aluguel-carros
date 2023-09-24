package com.mycompany.carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired private CarroRepository repo;

    public List<Carro> listAll() {
        return (List<Carro>) repo.findAll();
    }

    public void save(Carro carro) {
        repo.save(carro);
    }

    public Carro get(Integer id) throws CarroNotFoundException {
        Optional<Carro> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new CarroNotFoundException("Could not find any car with ID " + id);
    }

    public void delete(Integer id) throws CarroNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new CarroNotFoundException("Could not find any car with ID " + id);
        }
        repo.deleteById(id);
    }
}
