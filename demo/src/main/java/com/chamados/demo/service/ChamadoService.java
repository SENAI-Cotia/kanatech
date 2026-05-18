package com.chamados.demo.service;

import com.chamados.demo.repository.ChamadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chamados.demo.model.Chamado;
import com.chamados.demo.model.StatusChamado;

import java.util.List;
import java.util.Optional;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepository chamadoRepository;

    public List<Chamado> listarTodos() {
        return chamadoRepository.findAllByOrderByDataAtualizacaoDesc();
    }

    public Chamado salvar(Chamado chamado) {
        chamado.setStatus(StatusChamado.ABERTO);
        return chamadoRepository.save(chamado);
    }

    public Optional<Chamado> buscarPorId(Long id) {
        return chamadoRepository.findById(id);
    }

    public void atualizarStatus(Long id, StatusChamado novoStatus) {
        chamadoRepository.findById(id).ifPresent(chamado -> {
            chamado.setStatus(novoStatus);
            chamadoRepository.save(chamado);
        });
    }
}
