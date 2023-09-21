package br.com.ada.party.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
public class Party {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @FutureOrPresent(message = "A data tem que ser maior que o dia de hoje")
    private LocalDateTime dateTime;
}
