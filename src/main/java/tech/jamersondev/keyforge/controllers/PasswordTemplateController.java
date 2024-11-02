package tech.jamersondev.keyforge.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import tech.jamersondev.keyforge.model.PasswordTemplateEntity;
import tech.jamersondev.keyforge.records.PasswordTemplateDTO;
import tech.jamersondev.keyforge.records.PasswordTemplateResponseDTO;
import tech.jamersondev.keyforge.services.PasswordTemplateService;

import java.net.URI;

@RestController
@RequestMapping("/password")
public class PasswordTemplateController {

    private final PasswordTemplateService passwordTemplateService;

    public PasswordTemplateController(PasswordTemplateService passwordTemplateService) {
        this.passwordTemplateService = passwordTemplateService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PasswordTemplateResponseDTO> generatePassword(
            @RequestBody PasswordTemplateDTO password,
            UriComponentsBuilder uriComponentsBuilder
            ) throws Exception {

        PasswordTemplateEntity generate = this.passwordTemplateService.generate(password);
        URI uri = uriComponentsBuilder.path("password/{passwordId}").buildAndExpand(generate.getId()).toUri();
        return ResponseEntity.created(uri).body(new PasswordTemplateResponseDTO(generate.getCreatedDate(), generate.getGeneratedPassword()));
    }

    @GetMapping
    public ResponseEntity<Page<PasswordTemplateResponseDTO>> list(@PageableDefault(size = 12)  @Parameter(hidden = true) Pageable pageable){
        Page<PasswordTemplateResponseDTO> response = this.passwordTemplateService.list(pageable);
        return ResponseEntity.ok(response);
    }

}
