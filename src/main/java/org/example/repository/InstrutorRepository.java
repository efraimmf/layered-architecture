package org.example.repository;

import org.example.model.Instrutor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InstrutorRepository extends JpaRepository<Instrutor, UUID> {
    List<Instrutor> findByNomeContainingIgnoreCaseAndSobrenomeContainingIgnoreCase(String nome, String sobrenome);  // Buscar instrutores pelo nome e sobrenome
    Optional<Instrutor> findByEmail(String email); // Buscar instrutor pelo email
}
