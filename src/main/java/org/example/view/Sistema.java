package org.example.view;

import org.example.controller.FuncionarioController;
import org.example.controller.VotacaoController;
import org.example.exception.AplicacaoException;
import org.example.model.Funcionario;
import org.example.model.Restaurante;
import org.example.util.TecladoUtil;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static final FuncionarioController controller = new FuncionarioController();
    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static final List<Restaurante> restaurantes = new ArrayList<>();
    private static final VotacaoController votacaoController = new VotacaoController();
    private static boolean sair = false;

    public static void main(String[] args) {
        registrarDados();

        while (!sair) {
            menu();
            int opcao = TecladoUtil.lerInteiro("Informe uma opçao:");
            executaAcao(opcao);
        }
    }

    private static void registrarDados() {
        funcionarios.add(new Funcionario(1, "Raphael"));
        funcionarios.add(new Funcionario(2, "Arthur"));
        funcionarios.add(new Funcionario(3, "Pedro"));
        funcionarios.add(new Funcionario(4, "Maria"));
        funcionarios.add(new Funcionario(5, "Dafine"));

        restaurantes.add(new Restaurante(1, "Churrascaria do Ze"));
        restaurantes.add(new Restaurante(2, "Pizza Do Sul"));
        restaurantes.add(new Restaurante(3, "Rafa Sushi"));
        restaurantes.add(new Restaurante(4, "Parrila"));

        System.out.println("✅ Funcionários e restaurantes registrados!");
        System.out.println("Total de funcionarios: " + funcionarios.size());
        System.out.println("Total de restaurantes: " + restaurantes.size());
    }

    //metodo para listar todos os restaurantes
    private static void listarRestaurantes() {
        System.out.println("\nRestaurantes disponíveis:");
        for (Restaurante r : restaurantes) {
            System.out.println(r);
        }
    }
    //metodo para listar todos os funcionários
    private static void listarFuncionarios() {
        System.out.println("\nFuncionários cadastrados:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }
    }
    //metodo para buscar funcionário. cria um for Funcionário que percorre uma lista de funcionários
    private static Funcionario buscarFuncionarioPorId(int idFuncionario) {
        for (Funcionario f : funcionarios) {
            if (f.getId().equals(idFuncionario)) {
                return f;
            }
        }
        return null;
    }

    private static Restaurante buscarRestaurantePorId(int idRestaurante) {
        for (Restaurante r : restaurantes) {
            if (r.getId().equals(idRestaurante)) {
                return r;
            }
        }
        return null;
    }

    private static void votar() throws AplicacaoException {
        listarFuncionarios();
        int idFuncionario = TecladoUtil.lerInteiro("Digite o ID do funcionário:");
        Funcionario funcionario = buscarFuncionarioPorId(idFuncionario);

        if (funcionario == null) {
            String nome = TecladoUtil.lerString("Digite seu nome");
            controller.inserir(nome);
        }

        listarRestaurantes();
        int idRestaurante = TecladoUtil.lerInteiro("Digite o ID do restaurante:");
        Restaurante restaurante = buscarRestaurantePorId(idRestaurante);

        if (restaurante == null) {
            throw new AplicacaoException("Restaurante não encontrado!");
        }

        votacaoController.registrarVoto(funcionario, restaurante);
        System.out.println("Voto registrado com sucesso!");
    }

    private static void executaAcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    votar();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    listarRestaurantes();
                    break;
                case 4:
                    votacaoController.apurarVotacaoDoDia();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } catch (AplicacaoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("\n Menu Principal:");
        System.out.println("1. Votar");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Listar Restaurantes");
        System.out.println("4. Apurar votacao do dia");
        System.out.println("5. Sair");
    }
}
