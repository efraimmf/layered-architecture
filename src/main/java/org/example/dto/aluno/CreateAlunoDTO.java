package org.example.dto.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateAlunoDTO {
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @NotBlank(message = "O campo sobrenome é obrigatório")
    private String sobrenome;

    @Email(message = "Formato de e-mail inválido")
    @NotBlank(message = "O campo e-mail é obrigatório")
    private String email;

    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @NotBlank(message = "O campo senha é obrigatório")
    private String senha;

    @NotBlank(message = "O campo peso é obrigatório")
    private Double peso;

    @NotBlank(message = "O campo altura é obrigatório")
    private Double altura;

    @NotBlank(message = "O campo objetivo é obrigatório")
    private String objetivo;

    private UUID instrutorId;
}