package com.mycompany.contrato;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContratoController {
    @Autowired private ContratoService service;

    @GetMapping("/contratos")
    public String showContratoList(Model model) {
        List<Contrato> listContratos = service.listAll();
        model.addAttribute("listContratos", listContratos);

        return "contratos";
    }

    @GetMapping("/contratos/new")
    public String showNewForm(Model model) {
        model.addAttribute("contrato", new Contrato());
        model.addAttribute("pageTitle", "Add New Contract");
        return "contrato_form";
    }

    @PostMapping("/contratos/save")
    public String saveContrato(Contrato contrato, RedirectAttributes ra) {
        service.save(contrato);
        ra.addFlashAttribute("message", "The contract has been saved successfully.");
        return "redirect:/contratos";
    }

    @GetMapping("/contratos/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Contrato contrato = service.get(id);
            model.addAttribute("contrato", contrato);
            model.addAttribute("pageTitle", "Edit Contract (ID: " + id + ")");

            return "contrato_form";
        } catch (ContratoNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/contratos";
        }
    }

    @GetMapping("/contratos/delete/{id}")
    public String deleteContrato(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            service.delete(id);
            ra.addFlashAttribute("message", "The contract ID " + id + " has been deleted.");
        } catch (ContratoNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/contratos";
    }
}