package br.com.ada.party.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Party {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "Nome não pode ser vazio")
    private String name;

    @Column(columnDefinition = "DATE")
    @NotNull(message = "Data não pode ser vazia")
    private LocalDate date;

    @OneToMany(fetch = FetchType.LAZY)
    @NotNull(message = "Documentos não podem ser nulos")
    private List<Document> documents;

    @NotNull(message = "Tipo da parte não pode ser nulo")
    private PartyType partyType;
}
