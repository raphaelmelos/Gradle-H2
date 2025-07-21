package org.example.controller;

import org.example.exception.AplicacaoException;
import org.example.model.Funcionario;
import org.example.model.Restaurante;
import org.example.repository.FuncionarioRepository;
import org.example.repository.RestauranteRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import java.util.List;

public class RestaraunteController {

    private final RestauranteRepository restauranteRepository;
    private RestaraunteController restaraunteController;

    public RestaraunteController() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("votos");
        EntityManager em = factory.createEntityManager();

        this.restauranteRepository = new RestauranteRepository(em);

    }

    public void inserir(String nome) throws AplicacaoException {
        try {
            Restaurante restaurante = new Restaurante();
            restaurante.setNome(nome);
            restauranteRepository.inserir(restaurante);

        } catch (ArithmeticException e) {
            throw new AplicacaoException("Falha ao inserir");
        }
    }

    public List<Restaurante> buscar() throws AplicacaoException {
        try {
            System.out.println("\nExibindo resultados: ");
            return restauranteRepository.buscar();

        } catch (PersistenceException e) {
            throw new AplicacaoException("Encontramos um erro!");
        }
    }

}

