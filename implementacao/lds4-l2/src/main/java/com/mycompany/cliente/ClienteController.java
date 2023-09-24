package com.mycompany.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClienteController {
    @Autowired private ClienteService service;

    @GetMapping("/clientes")
    public String showClienteList(Model model) {
        List<Cliente> listClientes = service.listAll();
        model.addAttribute("listClientes", listClientes);

        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String showNewForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("pageTitle", "Add New Client");
        return "cliente_form";
    }

    @PostMapping("/clientes/save")
    public String saveCliente(Cliente cliente, RedirectAttributes ra) {
        service.save(cliente);
        ra.addFlashAttribute("message", "The client has been saved successfully.");
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Cliente cliente = service.get(id);
            model.addAttribute("cliente", cliente);
            model.addAttribute("pageTitle", "Edit Client (ID: " + id + ")");

            return "cliente_form";
        } catch (ClienteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/clientes";
        }
    }

    @GetMapping("/clientes/delete/{id}")
    public String deleteCliente(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The client ID " + id + " has been deleted.");
        } catch (ClienteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/clientes";
    }
}