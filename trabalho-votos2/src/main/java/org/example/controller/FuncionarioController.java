package org.example.controller;

import org.example.exception.AplicacaoException;
import org.example.repository.FuncionarioRepository;

import javax.persistence.*;

public class FuncionarioController {

        private FuncionarioController funcionarioController;
        
        public FuncionarioController (){
                EntityManagerFactory factory = Persistence.createEntityManagerFactory("votos");
                EntityManager em = factory.createEntityManager();

                this.funcionarioController = new FuncionarioController();
        }

        public void inserir(String nome) throws AplicacaoException {
                try {

                }catch(PersistenceException e){
                        e.getMessage();
                        throw new AplicacaoException("Falha ao inserir");
                }
        }
}
