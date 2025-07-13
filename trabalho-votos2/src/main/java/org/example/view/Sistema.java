package org.example.view;

import org.example.model.Funcionario;
import org.example.model.Restaurante;
import org.example.util.TecladoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {


        // Criando lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario(1, "Raphael"));
        funcionarios.add(new Funcionario(2, "Arthur"));

        // Criando lista de restaurantes
        List<Restaurante> restaurantes = new ArrayList<>();
        restaurantes.add(new Restaurante(1, "Churrascaria do Ze"));
        restaurantes.add(new Restaurante(2, "Pizza Bagualuda"));
        restaurantes.add(new Restaurante(3, "Sushi Podre"));

        // Mostrar funcionários
        System.out.println("Bem-vindo!");
        System.out.println("Funcionários cadastrados:");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

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

        // Mostrar restaurantes
        System.out.println("\nRestaurantes disponiveis:");
        for (Restaurante r : restaurantes) {
            System.out.println(r);
        }

        // Escolher restaurante
        System.out.print("\nQual restaurante quer escolher? (digite o ID): ");
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
}