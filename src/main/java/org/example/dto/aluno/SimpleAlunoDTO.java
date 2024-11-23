package org.example.dto.aluno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SimpleAlunoDTO {
    private String nome;
    private String sobrenome;
    private String email;
}
