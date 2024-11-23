package org.example.component;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.model.Instrutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    private final PasswordEncoder passwordEncoder;

    public InitialDataLoader(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        long count = (long) entityManager.createQuery("SELECT COUNT(u) FROM Instrutor u").getSingleResult();

        if (count == 0) {
            Instrutor instrutor = new Instrutor();
            instrutor.setNome("João");
            instrutor.setSobrenome("Silva");
            instrutor.setEmail("joao@exemplo.com");
            instrutor.setSenha(passwordEncoder.encode("senha123"));

            entityManager.persist(instrutor);
        }
    }
}
