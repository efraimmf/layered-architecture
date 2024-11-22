package org.example.repository;

import org.example.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {
    List<Aluno> findByNomeContainingIgnoreCaseOrSobrenomeContainingIgnoreCase(String nome, String sobrenome);  // Buscar alunos pelo nome ou sobrenome
    List<Aluno> findByInstrutorId(UUID instrutorId);  // Buscar alunos de um instrutor
    long countByInstrutorId(UUID instrutorId);  // Contar alunos de um instrutor
}
