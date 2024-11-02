package tech.jamersondev.keyforge.services;

import org.springframework.stereotype.Service;
import tech.jamersondev.keyforge.interfaces.IPasswordTemplate;
import tech.jamersondev.keyforge.repositorys.PasswordTemplateRepository;

@Service
public class PasswordTemplateService implements IPasswordTemplate {

    private final PasswordTemplateRepository passwordTemplateRepository;

    public PasswordTemplateService(PasswordTemplateRepository passwordTemplateRepository) {
        this.passwordTemplateRepository = passwordTemplateRepository;
    }

}
