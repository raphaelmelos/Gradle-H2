package org.example.repository;

import org.example.model.Restaurante;
import org.example.model.Voto;

import javax.persistence.EntityManager;

public class VotoRepository {
    private EntityManager em;

    public VotoRepository(EntityManager em) {
        this.em = em;

    }

    public void inserir(Voto voto) {
        this.em.getTransaction().begin();
        this.em.merge(voto);
        this.em.getTransaction().commit();
    }
}
