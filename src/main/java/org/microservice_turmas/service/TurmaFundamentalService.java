package org.microservice_turmas.service;

import org.microservice_turmas.dto.TurmaFundamentalDTO;
import org.microservice_turmas.model.TurmaFundamental;
import org.microservice_turmas.model.TurmaMedio;
import org.microservice_turmas.repository.TurmaFundamentalRepository;
import org.microservice_turmas.repository.TurmaMedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Service
public class TurmaFundamentalService {
    @Autowired
    private TurmaFundamentalRepository turmaFundamentalRepository;

    @Transactional
    public void criarTurmaFundamental(TurmaFundamentalDTO turmaFundamentalDTO){
        var novaTurma = turmaFundamentalDTO.turmaFundamentalBuilder();

        turmaFundamentalRepository.saveAndFlush(novaTurma);
    }

    @Transactional
    public Optional<TurmaFundamental> pegarPorId(Integer idTurma){
        return turmaFundamentalRepository.findById(idTurma);
    }

    @Transactional
    public void dissolverTurma(Integer idTurma){
        turmaFundamentalRepository.deleteById(idTurma);
    }

    @Transactional
    public void editarTurmaFundamental(Integer idTurma, TurmaFundamentalDTO turmaFundamentalDTO){
        var turmaAtual = pegarPorId(idTurma).get();

        turmaAtual.setSerie(turmaFundamentalDTO.getSerie());
        turmaAtual.setSerie(turmaFundamentalDTO.getSerie());
        turmaAtual.setTurno(turmaFundamentalDTO.getTurno());

        turmaFundamentalRepository.saveAndFlush(turmaAtual);
    }

    @Transactional
    public List<TurmaFundamental> pegarTodos(){
        return turmaFundamentalRepository.findAll();
    }

    @Transactional
    public List<TurmaFundamental> pegarPorLetra(char letra){
        letra = Character.toUpperCase(letra);
        return turmaFundamentalRepository.findByLetra(letra);
    }

    @Transactional
    public List<TurmaFundamental> pegarPorTurno(String turno){
        turno = turno.toUpperCase();
        return turmaFundamentalRepository.findByTurno(turno);
    }



}
