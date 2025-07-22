package org.example.repository;

import org.example.model.Funcionario;
import org.example.model.Restaurante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Classe utilizada para gerar os metodos com relação ao banco de dados.
 */

public class RestauranteRepository {
    private EntityManager em;

    /**
     * Construitor de classe RestauranteRepository
     * @param em da interface EntityManager
     */
    public RestauranteRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * metodo inserir ou atualizar
     * @param restaurante da Classe Restaurante
     */
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
