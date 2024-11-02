package tech.jamersondev.keyforge.records;

import tech.jamersondev.keyforge.model.PasswordTemplateEntity;

import java.util.Date;

public record PasswordTemplateResponseDTO(Date createdDate, String generatedPassword) {
    public PasswordTemplateResponseDTO(PasswordTemplateEntity passwordTemplateEntity) {
        this(passwordTemplateEntity.getCreatedDate(), passwordTemplateEntity.getGeneratedPassword());
    }
}
