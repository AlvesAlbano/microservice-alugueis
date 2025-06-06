package org.microservice_aluguel.service;

import jakarta.persistence.EntityNotFoundException;
import org.microservice_aluguel.client.FilmesClient;
import org.microservice_aluguel.dto.AluguelDTO;
import org.microservice_aluguel.model.Aluguel;
import org.microservice_aluguel.repository.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        String filmeJson = filmesClient.getFilmeById(aluguelDTO.getIdFilme());

        if (filmeJson.isBlank()) {
            throw new RuntimeException("Filme não encontrado");
        }

        var novoAluguel = aluguelDTO.aluguelBuilder();
        aluguelRepository.save(novoAluguel);
    }

    @Transactional(readOnly = true)
    public Optional<Aluguel> pegarPorId(Integer idAluguel) {
        return aluguelRepository.findById(idAluguel);
    }

    @Transactional
    public void devolverFilme(Integer idAluguel) {

        pegarPorId(idAluguel).orElseThrow(
            () -> new EntityNotFoundException("Aluguel não encontrado")
        );

        aluguelRepository.deleteById(idAluguel);
    }

    @Transactional
    public void editarAluguel(Integer idAluguel, AluguelDTO aluguelDTO) {
        var aluguelAtual = pegarPorId(idAluguel).orElseThrow(
                () -> new EntityNotFoundException("Aluguel não encontrado")
        );

        aluguelAtual.atualizarDados(aluguelDTO);

        aluguelRepository.save(aluguelAtual);
    }

    @Transactional(readOnly = true)
    public List<Aluguel> pegarTodos() {
        return aluguelRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Aluguel> pegarPorFilme(Integer idFilme) {
        return aluguelRepository.findByIdFilme(idFilme);
    }

    @Transactional(readOnly = true)
    public List<Aluguel> pegarPorUsuario(Integer idUsuario) {
        return aluguelRepository.findByIdUsuario(idUsuario);
    }
}