package tech.jamersondev.keyforge.records;

public record PasswordTemplateDTO(int passwordLength, boolean includeUppercaseLetters,
                                  boolean includeLowercaseLetters, boolean includeNumbers,
                                  boolean includeSpecialCharacters) {
}
