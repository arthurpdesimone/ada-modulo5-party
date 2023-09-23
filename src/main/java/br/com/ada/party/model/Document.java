package br.com.ada.party.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Document {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Long version;

    @NotNull
    private FinancialDocumentTypeValues type;

    @NotNull
    private String name;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private String description;

}
