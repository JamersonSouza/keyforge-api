package tech.jamersondev.keyforge.interfaces;

import tech.jamersondev.keyforge.model.PasswordTemplateEntity;
import tech.jamersondev.keyforge.records.PasswordTemplateDTO;
import tech.jamersondev.keyforge.records.PasswordTemplateResponseDTO;

public interface IPasswordTemplate {
    PasswordTemplateEntity generate(PasswordTemplateDTO password) throws Exception;
}
