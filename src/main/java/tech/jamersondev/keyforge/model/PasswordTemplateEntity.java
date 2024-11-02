package tech.jamersondev.keyforge.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tb_password_entity")
public class PasswordTemplateEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3654245965855624347L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String generatedPassword;
    private Date createdDate;

    public PasswordTemplateEntity() {
    }

    public PasswordTemplateEntity(String generatedPassword, Date createdDate) {
        this.generatedPassword = generatedPassword;
        this.createdDate = createdDate;
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


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
