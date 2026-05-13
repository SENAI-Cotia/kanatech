package com.chamados.demo.controller;

import com.chamados.demo.model.Chamado;
import com.chamados.demo.model.StatusChamado;
import com.chamados.demo.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @GetMapping("/")
    public String formulario(Model model) {
        model.addAttribute("chamado", new Chamado());
        return "formulario";
    }
    @PostMapping("/chamado/novo")
    public String novoChamado(@ModelAttribute Chamado chamado, Model model) {
        chamadoService.salvar(chamado);
        model.addAttribute("sucesso", true);
        model.addAttribute("chamado", new Chamado());
        return "formulario";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/ti/chamados")
    public String listarChamados(Model model) {
        List<Chamado> chamados = chamadoService.listarTodos();
        model.addAttribute("chamados", chamados);
        model.addAttribute("statusList", StatusChamado.values());
        return "chamados";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/ti/chamado/{id}/status")
    @ResponseBody
    public ResponseEntity<?> atualizarStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {

        try {
            StatusChamado novoStatus = StatusChamado.valueOf(body.get("status"));
            chamadoService.atualizarStatus(id, novoStatus);

            return ResponseEntity.ok(Map.of(
                    "sucesso", true
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "erro", e.getMessage()
            ));
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/ti/chamado/{id}")
    @ResponseBody
    public ResponseEntity<?> buscarChamado(@PathVariable Long id) {

        return chamadoService.buscarPorId(id)
                .map(c -> ResponseEntity.ok(Map.of(
                        "id", c.getId(),
                        "status", c.getStatus().name(),
                        "statusDescricao", c.getStatus().getDescricao()
                )))
                .orElse(ResponseEntity.notFound().build());
    }
}