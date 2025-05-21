package org.microservice_turmas.controller;

import org.microservice_turmas.dto.TurmaMedioDTO;
import org.microservice_turmas.service.TurmaMedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turma/medio")
public class TurmaMedioController {

    @Autowired
    private TurmaMedioService turmaMedioService;

    @GetMapping("/todas")
    public ResponseEntity<?> pegarTurmasMedio(){

        if (turmaMedioService.pegarTodos().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma Turma Encontrada");
        }

        return ResponseEntity.ok(turmaMedioService.pegarTodos());
    }

    @GetMapping("/letra/{letra}")
    public ResponseEntity<?> pegarTurmaMedioPorLetra(@PathVariable("letra") char letra){

        if (turmaMedioService.pegarPorLetra(letra).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma Turma Encontrada");
        }

        return ResponseEntity.ok(turmaMedioService.pegarPorLetra(letra));
    }

    @GetMapping("/turno/{turno}")
    public ResponseEntity<?> pegarTurmaMedioPorTurno(@PathVariable("turno") String turno){

        if (turmaMedioService.pegarPorTurno(turno).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma Turma Encontrada");
        }

        return ResponseEntity.ok(turmaMedioService.pegarPorTurno(turno));
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarTurmaMedio(@RequestBody TurmaMedioDTO turmaMedioDTO){

        turmaMedioService.criarTurmaMedio(turmaMedioDTO);

        return new ResponseEntity<>(turmaMedioDTO,HttpStatus.CREATED);

//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body("Nova Turma Adicionada");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<?> dissolverTurmaMedio(@PathVariable("id") Integer idTurmaMedio){

        if (turmaMedioService.pegarPorId(idTurmaMedio).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Turma não encontrada");

        }

        turmaMedioService.dissolverTurma(idTurmaMedio);
        return ResponseEntity.ok(
                String.format("Turma de ID %d apagada com sucesso!.",idTurmaMedio)
        );
    }

    @PatchMapping("/editar/{id}")
    public ResponseEntity<?> editarTurmaMedio(@PathVariable("id") Integer idTurma, @RequestBody TurmaMedioDTO turmaMedioDTO){


        if(turmaMedioService.pegarPorId(idTurma).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Turma não encontrada");
        }

        turmaMedioService.editarTurmaMedio(idTurma,turmaMedioDTO);

        return new ResponseEntity<>(turmaMedioService.pegarPorId(idTurma),HttpStatus.OK);
    }

}
