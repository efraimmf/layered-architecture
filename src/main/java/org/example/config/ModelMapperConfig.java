package org.example.config;

import org.example.dto.aluno.ResponseAlunoDTO;
import org.example.dto.aluno.SimpleAlunoDTO;
import org.example.dto.instrutor.ResponseInstrutorDTO;
import org.example.model.Aluno;
import org.example.model.Instrutor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.typeMap(Aluno.class, ResponseAlunoDTO.class).addMappings(mapper -> {
            mapper.map(src -> src.getInstrutor().getNome(), ResponseAlunoDTO::setInstrutorNome);
            mapper.map(src -> src.getInstrutor().getSobrenome(), ResponseAlunoDTO::setInstrutorSobrenome);
            mapper.map(src -> src.getInstrutor().getEmail(), ResponseAlunoDTO::setInstrutorEmail);
        });

        modelMapper.typeMap(Instrutor.class, ResponseInstrutorDTO.class).addMappings(mapper -> {
            mapper.map(
                    instrutor -> (instrutor.getAlunos() != null ? instrutor.getAlunos().stream()
                            .map(aluno -> modelMapper.map(aluno, SimpleAlunoDTO.class))
                            .toList() : new ArrayList<SimpleAlunoDTO>()),
                    ResponseInstrutorDTO::setAlunos
            );
        });

        return modelMapper;
    }
}
