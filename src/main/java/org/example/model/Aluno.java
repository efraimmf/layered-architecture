package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Aluno extends Usuario{
    @NotBlank(message = "O campo peso é obrigatório")
    private Double peso;
    @NotBlank(message = "O campo altura é obrigatório")
    private Double altura;
    @NotBlank(message = "O campo objetivo é obrigatório")
    private String objetivo;

    @ManyToOne
    @JoinColumn(name = "instrutor_id", nullable = false)
    private Instrutor instrutor;
}
