package org.microservice_aluguel.controller;

import org.microservice_aluguel.dto.AluguelDTO;
import org.microservice_aluguel.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping("/todos")
    public synchronized ResponseEntity<?> pegarAlugueis(){

        if (aluguelService.pegarTodos().isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }
        return ResponseEntity.ok(aluguelService.pegarTodos());
    }

    @PostMapping("/adicionar")
    public synchronized ResponseEntity<?> adicionarAluguel(@RequestBody AluguelDTO aluguelDTO){
         aluguelService.adicionarAluguel(aluguelDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Novo aluguel adicionado");
    }

    @DeleteMapping("/devolver/{id}")
    public synchronized ResponseEntity<?> devolverAluguel(@PathVariable("id") Integer idAluguel){

        if (aluguelService.pegarPorId(idAluguel).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }

        aluguelService.devolverFilme(idAluguel);
        return ResponseEntity.ok(String.format("Aluguel de ID %d foi encerrado\n",idAluguel));
    }

    @PatchMapping("/editar/{id}")
    public synchronized ResponseEntity<?> editarAluguel(@PathVariable("id") Integer idAluguel, @RequestBody AluguelDTO aluguelDTO){

        if (aluguelService.pegarPorId(idAluguel).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }

        aluguelService.editarAluguel(idAluguel,aluguelDTO);
        return ResponseEntity.ok("Aluguel editado");
    }

    @GetMapping("/filme/{id}")
    public synchronized ResponseEntity<?> pegarPorFilme(Integer idFilme){
        if (aluguelService.pegarPorFilme(idFilme).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }
        return ResponseEntity.ok(aluguelService.pegarPorFilme(idFilme));
    }

    @GetMapping("/usuario/{id}")
    public synchronized ResponseEntity<?> pegarPorUsuario(Integer idUsuario){
        if (aluguelService.pegarPorUsuario(idUsuario).isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }
        return ResponseEntity.ok(aluguelService.pegarPorUsuario(idUsuario));
    }

}