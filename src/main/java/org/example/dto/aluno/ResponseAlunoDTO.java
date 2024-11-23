package org.example.dto.aluno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseAlunoDTO {
    private String nome;
    private String sobrenome;
    private String email;
    private Double peso;
    private Double altura;
    private String objetivo;
    private String instrutorNome;
    private String instrutorSobrenome;
    private String instrutorEmail;
}
