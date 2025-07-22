package org.example.repository;

import org.example.model.Restaurante;
import org.example.model.Voto;

import javax.persistence.EntityManager;


/**
 * Classe utilizada para gerar os metodos com relação ao banco de dados.
 */


public class VotoRepository {
    private EntityManager em;

    public VotoRepository(EntityManager em) {
        this.em = em;

    }

    /**
     * metodo iserir ou atualizar.
     * @param voto de uma Classe Voto.
     */
    public void inserir(Voto voto) {
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }
}
