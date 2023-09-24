package com.mycompany.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired private ClienteRepository repo;

    public List<Cliente> listAll() {
        return (List<Cliente>) repo.findAll();
    }

    public void save(Cliente cliente) {
        repo.save(cliente);
    }

    public Cliente get(Integer id) throws ClienteNotFoundException {
        Optional<Cliente> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new ClienteNotFoundException("Could not find any clients with ID " + id);
    }

    public void delete(Integer id) throws ClienteNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new ClienteNotFoundException("Could not find any clients with ID " + id);
        }
        repo.deleteById(id);
    }
}
