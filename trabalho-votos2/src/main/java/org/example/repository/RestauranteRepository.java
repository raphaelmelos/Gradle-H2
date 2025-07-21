package org.example.repository;

import org.example.model.Funcionario;
import org.example.model.Restaurante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class RestauranteRepository {
    private EntityManager em;

    public RestauranteRepository(EntityManager em) {
        this.em = em;
    }

    public void inserir(Restaurante restaurante) {
        this.em.getTransaction().begin();
        this.em.merge(restaurante);
        this.em.getTransaction().commit();
    }

    public List<Restaurante> buscar() {
        TypedQuery<Restaurante> buscarTodosQuery =
                this.em.createQuery("SELECT r FROM Restaurante r", Restaurante.class);
        return buscarTodosQuery.getResultList();
    }
}
