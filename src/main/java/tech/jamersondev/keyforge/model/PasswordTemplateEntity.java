package tech.jamersondev.keyforge.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class PasswordTemplateEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3654245965855624347L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String generatedPassword;
    private int passwordLength;
    private Date createdDate;
    private boolean includeUppercaseLetters;
    private boolean includeLowercaseLetters;
    private boolean includeNumbers;
    private boolean includeSpecialCharacters;

    public PasswordTemplateEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getGeneratedPassword() {
        return generatedPassword;
    }

    public void setGeneratedPassword(String generatedPassword) {
        this.generatedPassword = generatedPassword;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public boolean isIncludeUppercaseLetters() {
        return includeUppercaseLetters;
    }

    public void setIncludeUppercaseLetters(boolean includeUppercaseLetters) {
        this.includeUppercaseLetters = includeUppercaseLetters;
    }

    public boolean isIncludeLowercaseLetters() {
        return includeLowercaseLetters;
    }

    public void setIncludeLowercaseLetters(boolean includeLowercaseLetters) {
        this.includeLowercaseLetters = includeLowercaseLetters;
    }

    public boolean isIncludeNumbers() {
        return includeNumbers;
    }

    public void setIncludeNumbers(boolean includeNumbers) {
        this.includeNumbers = includeNumbers;
    }

    public boolean isIncludeSpecialCharacters() {
        return includeSpecialCharacters;
    }

    public void setIncludeSpecialCharacters(boolean includeSpecialCharacters) {
        this.includeSpecialCharacters = includeSpecialCharacters;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
