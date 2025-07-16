package org.example.controller;

import org.example.exception.AplicacaoException;
import org.example.model.Funcionario;
import org.example.model.Restaurante;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class VotacaoController {

    private final Map<LocalDate, Map<Funcionario, Restaurante>> votosPorDia = new HashMap<>();

    public void registrarVoto(Funcionario funcionario, Restaurante restaurante) throws AplicacaoException {
        LocalDate hoje = LocalDate.now();

        votosPorDia.putIfAbsent(hoje, new HashMap<>());
        Map<Funcionario, Restaurante> votosHoje = votosPorDia.get(hoje);

        if (votosHoje.containsKey(funcionario)) {
            throw new AplicacaoException("Funcionário já votou hoje!");
        }

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

        System.out.println("\n📊 Resultado da votação de hoje:");
        for (Map.Entry<Restaurante, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue() + " voto(s)");
        }
    }
}
