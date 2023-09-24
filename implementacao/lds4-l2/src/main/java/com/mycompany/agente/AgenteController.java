package com.mycompany.agente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AgenteController {
    @Autowired private AgenteService service;

    @GetMapping("/agentes")
    public String showAgentList(Model model) {
        List<Agente> listAgentes = service.listAll();
        model.addAttribute("listAgentes", listAgentes);

        return "agentes";
    }

    @GetMapping("/agentes/new")
    public String showNewForm(Model model) {
        model.addAttribute("agente", new Agente());
        model.addAttribute("pageTitle", "Add New Agent");
        return "agente_form";
    }

    @PostMapping("/agentes/save")
    public String saveAgent(Agente agente, RedirectAttributes ra) {
        service.save(agente);
        ra.addFlashAttribute("message", "The agent has been saved successfully.");
        return "redirect:/agentes";
    }

    @GetMapping("/agentes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Agente agente = service.get(id);
            model.addAttribute("agente", agente);
            model.addAttribute("pageTitle", "Edit Agent (ID: " + id + ")");

            return "agente_form";
        } catch (AgenteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/agentes";
        }
    }

    @GetMapping("/agentes/delete/{id}")
    public String deleteAgent(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The agent ID " + id + " has been deleted.");
        } catch (AgenteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/agentes";
    }
}