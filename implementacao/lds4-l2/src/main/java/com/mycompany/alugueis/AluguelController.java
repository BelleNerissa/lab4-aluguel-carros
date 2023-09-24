package com.mycompany.alugueis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AluguelController {
    @Autowired private AluguelService service;

    @GetMapping("/alugueis")
    public String showAluguelList(Model model) {
        List<Aluguel> listAlugueis = service.listAll();
        model.addAttribute("listAlugueis", listAlugueis);

        return "alugueis";
    }

    @GetMapping("/alugueis/new")
    public String showNewForm(Model model) {
        model.addAttribute("aluguel", new Aluguel());
        model.addAttribute("pageTitle", "Add New Aluguel");
        return "aluguel_form";
    }

    @PostMapping("/alugueis/save")
    public String saveAluguel(Aluguel aluguel, RedirectAttributes ra) {
        service.save(aluguel);
        ra.addFlashAttribute("message", "The aluguel has been saved successfully.");
        return "redirect:/alugueis";
    }

    @GetMapping("/alugueis/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Aluguel aluguel = service.get(id);
            model.addAttribute("aluguel", aluguel);
            model.addAttribute("pageTitle", "Edit Aluguel (ID: " + id + ")");

            return "aluguel_form";
        } catch (AluguelNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/alugueis";
        }
    }

    @GetMapping("/alugueis/delete/{id}")
    public String deleteAluguel(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The aluguel ID " + id + " has been deleted.");
        } catch (AluguelNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/alugueis";
    }
}