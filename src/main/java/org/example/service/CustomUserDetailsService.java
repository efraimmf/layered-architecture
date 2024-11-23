package org.example.service;

import org.example.model.Aluno;
import org.example.model.Instrutor;
import org.example.model.Usuario;
import org.example.repository.AlunoRepository;
import org.example.repository.InstrutorRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final AlunoRepository alunoRepository;
    private final InstrutorRepository instrutorRepository;

    public CustomUserDetailsService(AlunoRepository alunoRepository, InstrutorRepository instrutorRepository) {
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Aluno> aluno = alunoRepository.findByEmail(email);
        if (aluno.isPresent()) {
            return toUserDetails(aluno.get(), "ROLE_ALUNO");
        }

        Optional<Instrutor> instrutor = instrutorRepository.findByEmail(email);
        if (instrutor.isPresent()) {
            return toUserDetails(instrutor.get(), "ROLE_INSTRUTOR");
        }

        throw new UsernameNotFoundException("Usuário não encontrado com email: " + email);
    }

    private UserDetails toUserDetails(Usuario usuario, String role) {
        return new org.springframework.security.core.userdetails.User(
                usuario.getEmail(),
                usuario.getSenha(),
                List.of(new SimpleGrantedAuthority(role))
        );
    }
}
