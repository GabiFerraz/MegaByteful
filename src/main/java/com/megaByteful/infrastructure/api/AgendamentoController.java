package com.megaByteful.controller;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {
    private final AgendarServicoUseCase agendarServicoUseCase;

    @PostMapping
    public ResponseEntity<Agendamento> agendarServico(@RequestBody Agendamento agendamento) {
        return ResponseEntity.ok(agendarServicoUseCase.execute(agendamento));
    }

    // Mais coisa aqui
   
}