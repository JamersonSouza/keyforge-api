package tech.jamersondev.keyforge.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SwaggerRedirectController {
    @GetMapping
    public String redirectToSwaggerUi() {
        return "redirect:/swagger-ui/index.html";
    }
}
