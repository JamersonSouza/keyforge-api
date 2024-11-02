package tech.jamersondev.keyforge.services;

import org.springframework.stereotype.Service;
import tech.jamersondev.keyforge.interfaces.IPasswordTemplate;
import tech.jamersondev.keyforge.model.PasswordTemplateEntity;
import tech.jamersondev.keyforge.records.PasswordTemplateDTO;
import tech.jamersondev.keyforge.records.PasswordTemplateResponseDTO;
import tech.jamersondev.keyforge.repositorys.PasswordTemplateRepository;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswordTemplateService implements IPasswordTemplate {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    private final PasswordTemplateRepository passwordTemplateRepository;

    public PasswordTemplateService(PasswordTemplateRepository passwordTemplateRepository) {
        this.passwordTemplateRepository = passwordTemplateRepository;
    }

    @Override
    public PasswordTemplateEntity generate(PasswordTemplateDTO passwordTemplate) throws Exception {
        StringBuilder password = new StringBuilder();
        SecureRandom random = new SecureRandom();
        if(!passwordTemplate.includeSpecialCharacters() && !passwordTemplate.includeNumbers()
                && !passwordTemplate.includeLowercaseLetters() && !passwordTemplate.includeUppercaseLetters()){
            throw new Exception("At least one type be selected");
        }
        List<String> characterTypes = Arrays.asList(
                UPPERCASE,
                LOWERCASE,
                NUMBERS,
                SPECIAL_CHARACTERS
        );

        String allowedCharacters = characterTypes.stream()
                .filter(chosenType ->
                        chosenType.equals(UPPERCASE) ? passwordTemplate.includeUppercaseLetters():
                        chosenType.equals(LOWERCASE) ? passwordTemplate.includeLowercaseLetters() :
                        chosenType.equals(NUMBERS) ? passwordTemplate.includeNumbers() :
                        chosenType.equals(SPECIAL_CHARACTERS) && passwordTemplate.includeSpecialCharacters()
                )
                .collect(Collectors.joining());

        for (int i = 0; i < passwordTemplate.passwordLength(); i++) {
            password.append(allowedCharacters.charAt(random.nextInt(allowedCharacters.length())));
        }
        PasswordTemplateEntity passwordTemplateEntity = new PasswordTemplateEntity(password.toString(), new Date());
        return this.passwordTemplateRepository.save(passwordTemplateEntity);
    }
}
