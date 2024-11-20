package org.example.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Instrutor extends Usuario{
    @OneToMany(mappedBy = "instrutor", cascade = CascadeType.ALL)
    private List<Aluno> alunos;
}
