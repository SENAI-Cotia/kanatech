package com.chamados.demo.controller;

import com.chamados.demo.repositorio.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/usuarios/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario";
    }




    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public String salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
        return "Salvo com sucesso!";
    }


}