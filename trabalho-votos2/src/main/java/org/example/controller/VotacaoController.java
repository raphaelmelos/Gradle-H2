package org.example.controller;

import org.example.exception.AplicacaoException;
import org.example.model.Funcionario;
import org.example.model.Restaurante;
import org.example.model.Voto;
import org.example.repository.RestauranteRepository;
import org.example.repository.VotoRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class VotacaoController {

    private final VotoRepository votoRepository;
    private VotacaoController  votacaoController;

    public VotacaoController() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("votos");
        EntityManager em = factory.createEntityManager();

        this.votoRepository = new VotoRepository(em);
    }


    private final Map<LocalDate, Map<Funcionario, Restaurante>> votosPorDia = new HashMap<>();

    public void registrarVoto(Funcionario funcionario, Restaurante restaurante) throws AplicacaoException {
        LocalDate hoje = LocalDate.now();

        votosPorDia.putIfAbsent(hoje, new HashMap<>());
        Map<Funcionario, Restaurante> votosHoje = votosPorDia.get(hoje);

        if (votosHoje.containsKey(funcionario)) {
            throw new AplicacaoException("Funcionário já votou hoje!");
        }
   ///    votoRepository.inserir(new Voto());
        votosHoje.put(funcionario, restaurante);
    }

    public void apurarVotacaoDoDia() {
        LocalDate hoje = LocalDate.now();

        if (!votosPorDia.containsKey(hoje)) {
            System.out.println("Nenhum voto registrado hoje.");
            return;
        }

        Map<Restaurante, Integer> contagem = new HashMap<>();

        for (Restaurante r : votosPorDia.get(hoje).values()) {
            contagem.put(r, contagem.getOrDefault(r, 0) + 1);
        }

        System.out.println("\nResultado da votação de hoje:");
        for (Map.Entry<Restaurante, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue() + " voto(s)");
        }
    }
}
