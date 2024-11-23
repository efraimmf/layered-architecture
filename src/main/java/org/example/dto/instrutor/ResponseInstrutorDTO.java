package org.example.dto.instrutor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.dto.aluno.SimpleAlunoDTO;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResponseInstrutorDTO {
    private String nome;
    private String sobrenome;
    private String email;
    private List<SimpleAlunoDTO> alunos;
}
