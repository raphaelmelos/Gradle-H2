package org.example.view;

import org.example.controller.FuncionarioController;
import org.example.exception.AplicacaoException;
import org.example.model.Funcionario;
import org.example.model.Restaurante;
import org.example.util.TecladoUtil;
import org.hibernate.loader.collection.OneToManyJoinWalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {

    private static FuncionarioController controller = new FuncionarioController();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Restaurante> restaurantes = new ArrayList<>();
    private static boolean sair = false;



    Funcionario funcionario1 = new Funcionario(1,"raphael");

    public static void main(String[] args) {
            registrardados();
            while (!sair) {
                menu();
            int opcao = TecladoUtil.lerInteiro("Informa uma Opcao:");
            executaAcao(opcao);
            }

        }

        private static void registrardados() {
            // Criando lista de funcionários

            funcionarios.add(new Funcionario(1, "Raphael"));
            funcionarios.add(new Funcionario(2, "Arthur"));
            funcionarios.add(new Funcionario(3, "Pedro"));
            funcionarios.add(new Funcionario(4, "Maria"));
            funcionarios.add(new Funcionario(5, "Dafine"));
            System.out.println("Funcionarios registrados!");

            // Criando lista de restaurantes
            restaurantes.add(new Restaurante(1, "Churrascaria do Ze"));
            restaurantes.add(new Restaurante(2, "Pizza Do Sul"));
            restaurantes.add(new Restaurante(3, "Rafa Sushi"));
            restaurantes.add(new Restaurante(4, "Parrila"));
            System.out.println("Restaurantes registrados!");

            System.out.println("Total de funcionarios: " + funcionarios.size());
            System.out.println("Total de restaurantes: " + restaurantes.size());


        }




        // Mostrar restaurantes
        private static void listarRestaurantes() throws  AplicacaoException{
        System.out.println("\nRestaurantes disponiveis:");
        for (Restaurante r: restaurantes) {
            System.out.println(r);
             }
        }
        private static void listarFuncionarios() throws  AplicacaoException{
            System.out.println("Lista de funcionarios");
            for (Funcionario f: funcionarios){
                System.out.println(f.getNome());
            }
        }
    // Escolher restaurante
    private static void votar ()throws  AplicacaoException {
        System.out.print("\nQual restaurante quer escolher? (digite o ID): ");
        listarRestaurantes();
        int idRestaurante = TecladoUtil.lerInteiro("Iforme a opção");
        Restaurante restauranteSelecionado = null;

        for (Restaurante r : restaurantes) {
            if (r.getId().equals(idRestaurante)) {
                restauranteSelecionado = r;
                break;
            }
        }

        if (restauranteSelecionado == null) {
            System.out.println("Restaurante não encontrado!");
        } else {
            System.out.println("Voce votou no restaurante: " + restauranteSelecionado.getNome());
        }
    }

    private static void executaAcao( int opcao) {
        try {
            switch (opcao) {
                case 1:
                    // Escolher funcionário
                    System.out.print("\nDigite o ID do funcionário: ");
                    int idFuncionario = TecladoUtil.lerInteiro("Informe a opção: ");
                    Funcionario funcionarioSelecionado = null;


                    for (Funcionario f : funcionarios) {
                        if (f.getId().equals(idFuncionario)) {
                            funcionarioSelecionado = f;
                            break;
                        }
                    }
                    if (funcionarioSelecionado == null) {
                        System.out.println("Funcionario não encontrado!");
                        return;
                    }
                    System.out.println("Olá, " + funcionarioSelecionado.getNome() + "!");

                    votar();

                    System.out.println("Votar");
                    break;
                case 2:
                    listarFuncionarios();
                    System.out.println("Listar funcionarios");
                    break;
                case 3:
                    listarRestaurantes();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida!!");
                    break;
            }
        } catch (AplicacaoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void menu(){
        System.out.println("\nBem vindo ao menu!");
        System.out.println("1. Votar");
        System.out.println("2. Listar Funcionarios");
        System.out.println("3. Listar Restaurantes");
    }

}