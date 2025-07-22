package org.example.repository;

import org.example.model.Funcionario;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Classe utilizada para gerar os metodos com relação ao banco de dados.
 */

public class FuncionarioRepository {

        private EntityManager em;

        public FuncionarioRepository(EntityManager em) {this.em = em;}

        public void inserir(Funcionario funcionario) {
            this.em.getTransaction().begin();
            this.em.merge(funcionario);
            this.em.getTransaction().commit();
        }

        //public Funcionario buscar(Integer id) {return  this.em.find(Funcionario.class, id);}

        public  List<Funcionario> buscar() {
            TypedQuery<Funcionario> buscarTodosQuery =
                    this.em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            return buscarTodosQuery.getResultList();
        }
}
