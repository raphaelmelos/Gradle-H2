package org.example.repository;

import org.example.model.Funcionario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

public class FuncionarioRepository {

        private EntityManager em;

        public FuncionarioRepository(EntityManager em) {this.em = em;}

        public void inserir(Funcionario funcionario) {
            this.em.getTransaction().begin();
            this.em.merge(funcionario);
            this.em.getTransaction().commit();
        }
}
