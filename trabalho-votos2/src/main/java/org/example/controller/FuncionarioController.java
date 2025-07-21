package org.example.controller;

import org.example.exception.AplicacaoException;
import org.example.model.Funcionario;
import org.example.repository.FuncionarioRepository;

import javax.persistence.*;
import java.util.List;

public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;
    private FuncionarioController funcionarioController;

    public FuncionarioController() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("votos");
        EntityManager em = factory.createEntityManager();

        this.funcionarioRepository = new FuncionarioRepository(em);


    }

    public void inserir(String nome) throws AplicacaoException {
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(nome);
            funcionarioRepository.inserir(funcionario);

        } catch (PersistenceException e) {
            e.getMessage();
            throw new AplicacaoException("Falha ao inserir");
        }
    }

    public List<Funcionario> buscar() throws AplicacaoException {
        try {
            return funcionarioRepository.buscar();
        } catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao inserir Estado");
        }
    }
}
