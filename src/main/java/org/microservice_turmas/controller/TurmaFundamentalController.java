package org.microservice_turmas.controller;

import org.microservice_turmas.service.TurmaFundamentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma/fundamental")
public class TurmaFundamentalController {

    @Autowired
    private TurmaFundamentalService turmaFundamentalService;
}
