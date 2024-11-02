package tech.jamersondev.keyforge.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import tech.jamersondev.keyforge.model.PasswordTemplateEntity;
import tech.jamersondev.keyforge.records.PasswordTemplateDTO;
import tech.jamersondev.keyforge.records.PasswordTemplateResponseDTO;


public interface IPasswordTemplate {
    PasswordTemplateEntity generate(PasswordTemplateDTO password) throws Exception;
    Page<PasswordTemplateResponseDTO> list(Pageable pageable);
}
