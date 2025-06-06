package org.microservice_aluguel.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.microservice_aluguel.dto.AluguelDTO;
import org.microservice_aluguel.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Aluguéis", description = "Endpoints responsáveis pela manipulação de aluguéis no banco de dados.")
@RestController
@RequestMapping("/alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping("/todos")
    @Operation(
            summary = "Retorna todos os aluguéis cadastrados",
            description = "Recupera e retorna todos os aluguéis registrados no banco de dados."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de aluguéis retornada com sucesso")
    })
    public ResponseEntity<?> pegarAlugueis() {
        return ResponseEntity.ok(aluguelService.pegarTodos());
    }

    @PostMapping("/adicionar")
    @Operation(
            summary = "Adiciona um novo aluguel",
            description = "Adiciona um novo aluguel ao banco de dados com base nos dados fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Aluguel criado com sucesso"),
            @ApiResponse(responseCode = "500", description = "O filme não foi encontrado no microsserviço do mesmo")
    })
    public ResponseEntity<?> adicionarAluguel(@RequestBody AluguelDTO aluguelDTO) {
        aluguelService.adicionarAluguel(aluguelDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Novo aluguel adicionado");
    }

    @DeleteMapping("/devolver/{id}")
    @Operation(
            summary = "Devolve (encerra) um aluguel",
            description = "Marca um aluguel como devolvido, encerrando seu registro ativo."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluguel devolvido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluguel não encontrado")
    })
    public ResponseEntity<?> devolverAluguel(@PathVariable("id") Integer idAluguel) {

        aluguelService.devolverFilme(idAluguel);
        return ResponseEntity.ok(String.format("Aluguel de ID %d foi encerrado", idAluguel));
    }

    @PatchMapping("/editar/{id}")
    @Operation(
            summary = "Edita um aluguel existente",
            description = "Atualiza os dados de um aluguel já existente com os novos dados fornecidos."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluguel editado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Aluguel não encontrado")
    })
    public ResponseEntity<?> editarAluguel(@PathVariable("id") Integer idAluguel, @RequestBody AluguelDTO aluguelDTO) {
        if (aluguelService.pegarPorId(idAluguel).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }

        aluguelService.editarAluguel(idAluguel, aluguelDTO);
        return ResponseEntity.ok("Aluguel editado");
    }

    @GetMapping("/filme/{id}")
    @Operation(
            summary = "Busca aluguéis por ID do filme",
            description = "Retorna todos os aluguéis associados a um filme específico com base em seu ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluguéis retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum aluguel encontrado para o filme")
    })
    public ResponseEntity<?> pegarPorFilme(@PathVariable("id") Integer idFilme) {
        if (aluguelService.pegarPorFilme(idFilme).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }
        return ResponseEntity.ok(aluguelService.pegarPorFilme(idFilme));
    }

    @GetMapping("/usuario/{id}")
    @Operation(
            summary = "Busca aluguéis por ID do usuário",
            description = "Retorna todos os aluguéis feitos por um usuário específico com base em seu ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluguéis retornados com sucesso"),
            @ApiResponse(responseCode = "404", description = "Nenhum aluguel encontrado para o usuário")
    })
    public ResponseEntity<?> pegarPorUsuario(@PathVariable("id") Integer idUsuario) {
        if (aluguelService.pegarPorUsuario(idUsuario).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Nenhum aluguel encontrado");
        }
        return ResponseEntity.ok(aluguelService.pegarPorUsuario(idUsuario));
    }
}