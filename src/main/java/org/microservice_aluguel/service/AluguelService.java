package org.microservice_aluguel.service;

import jakarta.transaction.Transactional;
import org.microservice_aluguel.client.FilmesClient;
import org.microservice_aluguel.dto.AluguelDTO;
import org.microservice_aluguel.model.Aluguel;
import org.microservice_aluguel.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;
    @Autowired
    private FilmesClient filmesClient;

    @Transactional
    public void adicionarAluguel(AluguelDTO aluguelDTO) {

        final String filmeJson = filmesClient.getFilmeById(aluguelDTO.getIdFilme());

        if (filmeJson.isBlank()) {
            throw new RuntimeException("Filme não encontrado");
        }

        var novoAluguel = aluguelDTO.aluguelBuilder();
        aluguelRepository.saveAndFlush(novoAluguel);
    }

    @Transactional
    public Optional<Aluguel> pegarPorId(Integer idAluguel) {
        return aluguelRepository.findById(idAluguel);
    }

    @Transactional
    public void devolverFilme(Integer idAluguel) {
        aluguelRepository.deleteById(idAluguel);
    }

    @Transactional
    public void editarAluguel(Integer idAluguel, AluguelDTO aluguelDTO) {
        var aluguelAtual = pegarPorId(idAluguel).get();

        aluguelAtual.setIdUsuario(aluguelDTO.getIdUsuario());
        aluguelAtual.setIdFilme(aluguelDTO.getIdFilme());
        aluguelAtual.setInicioAluguel(aluguelDTO.getInicioAluguel());
        aluguelAtual.setDevolucaoAluguel(aluguelDTO.getDevolucaoAluguel());
        aluguelAtual.setValorAluguel(aluguelDTO.getValorAluguel());

        aluguelRepository.saveAndFlush(aluguelAtual);
    }

    @Transactional
    public List<Aluguel> pegarTodos() {
        return aluguelRepository.findAll();
    }

    @Transactional
    public List<Aluguel> pegarPorFilme(Integer idFilme) {
        return aluguelRepository.findByIdFilme(idFilme);
    }

    @Transactional
    public List<Aluguel> pegarPorUsuario(Integer idUsuario) {
        return aluguelRepository.findByIdUsuario(idUsuario);
    }

    @Transactional
    public List<Aluguel> pegarPorInicioAluguel() {
        return null;
    }

    @Transactional
    public List<Aluguel> pegarPorDevolucaoAluguel() {
        return null;
    }
}