package org.microservice_aluguel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SwaggerUrl {

    @GetMapping
    public String swaggerUrl(){
        return "http://localhost:8080/swagger-ui/index.html<br>https://microservice-alugueis.onrender.com/swagger-ui/index.html";
    }
}