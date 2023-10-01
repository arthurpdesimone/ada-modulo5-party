package br.com.ada.party.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Document {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Versão do documento não pode ser nula")
    private Long version;

    @NotNull(message = "Tipo do documento não pode ser nulo")
    private FinancialDocumentTypeValues type;

    @NotNull(message = "Nome do documento não pode ser nula")
    private String name;

    @NotNull(message = "Data de expedição do documento não pode ser nula")
    private LocalDate date;

    @NotNull(message = "Data de expiração do documento não pode ser nula")
    @FutureOrPresent(message = "A data de expiração deve ser maior que o dia de hoje")
    private LocalDate expirationDate;

    @NotNull(message = "Descrição do documento não pode ser nula")
    private String description;

}
