package com.mycompany.carro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CarroController {
    @Autowired private CarroService service;

    @GetMapping("/carros")
    public String showCarroList(Model model) {
        List<Carro> listCarros = service.listAll();
        model.addAttribute("listCarros", listCarros);

        return "carros";
    }

    @GetMapping("/carros/new")
    public String showNewForm(Model model) {
        model.addAttribute("carro", new Carro());
        model.addAttribute("pageTitle", "Add New Car");
        return "carro_form";
    }

    @PostMapping("/carros/save")
    public String saveCarro(Carro carro, RedirectAttributes ra) {
        service.save(carro);
        ra.addFlashAttribute("message", "The car has been saved successfully.");
        return "redirect:/carros";
    }

    @GetMapping("/carros/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Carro carro = service.get(id);
            model.addAttribute("carro", carro);
            model.addAttribute("pageTitle", "Edit car (ID: " + id + ")");

            return "carro_form";
        } catch (CarroNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/carros";
        }
    }

    @GetMapping("/carros/delete/{id}")
    public String deleteCarro(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The car ID " + id + " has been deleted.");
        } catch (CarroNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/carros";
    }
}