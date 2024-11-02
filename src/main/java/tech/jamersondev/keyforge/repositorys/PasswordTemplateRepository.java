package tech.jamersondev.keyforge.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jamersondev.keyforge.model.PasswordTemplateEntity;

import java.util.UUID;

public interface PasswordTemplateRepository extends JpaRepository<PasswordTemplateEntity, UUID> {
}
