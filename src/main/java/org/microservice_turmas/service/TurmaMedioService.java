package org.microservice_turmas.service;

import org.microservice_turmas.dto.TurmaMedioDTO;
import org.microservice_turmas.model.TurmaMedio;
import org.microservice_turmas.repository.TurmaMedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaMedioService {

    @Autowired
    private TurmaMedioRepository turmaMedioRepository;

    @Transactional
    public void criarTurmaMedio(TurmaMedioDTO turmaMedioDTO){

//        char letraMaiuscula = Character.toUpperCase(turmaMedioDTO.getLetra());
//        String turnoMaiusculo = turmaMedioDTO.getTurno().toUpperCase();
//
//        TurmaMedio novaTurma = new TurmaMedio(
//                turnoMaiusculo,
//                turmaMedioDTO.getSerie(),
//                letraMaiuscula
//        );

        var novaTurma = turmaMedioDTO.turmaMedioBuilder();

        turmaMedioRepository.saveAndFlush(novaTurma);
    }

    @Transactional
    public Optional<TurmaMedio> pegarPorId(Integer idTurma){
        return turmaMedioRepository.findById(idTurma);
    }

    @Transactional
    public void dissolverTurma(Integer idTurma){
        turmaMedioRepository.deleteById(idTurma);
    }

    @Transactional
    public void editarTurmaMedio(Integer idTurma, TurmaMedioDTO turmaMedioDTO){

        var turmaAtual = pegarPorId(idTurma).get();

        turmaAtual.setSerie(turmaMedioDTO.getSerie());
        turmaAtual.setTurno(turmaMedioDTO.getTurno());

        turmaMedioRepository.saveAndFlush(turmaAtual);
    }

    @Transactional
    public List<TurmaMedio> pegarTodos(){
        return turmaMedioRepository.findAll();
    }

    @Transactional
    public List<TurmaMedio> pegarPorLetra(char letra){
        letra = Character.toUpperCase(letra);
        return turmaMedioRepository.findByLetra(letra);
    }

    @Transactional
    public List<TurmaMedio> pegarPorTurno(String turno){
        turno = turno.toUpperCase();
        return turmaMedioRepository.findByTurno(turno);
    }
}