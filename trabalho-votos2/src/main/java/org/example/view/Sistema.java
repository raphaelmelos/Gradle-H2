package org.example.view;

import antlr.MismatchedCharException;
import org.example.controller.FuncionarioController;
import org.example.controller.RestaraunteController;
import org.example.controller.VotacaoController;
import org.example.exception.AplicacaoException;
import org.example.model.Funcionario;
import org.example.model.Restaurante;
import org.example.util.TecladoUtil;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private static final FuncionarioController controllerFun = new FuncionarioController();
    private static final RestaraunteController controllerRes = new RestaraunteController();
    private static final VotacaoController controllerVot = new VotacaoController();
    private static final List<Funcionario> funcionarios = new ArrayList<>();
    private static final List<Restaurante> restaurantes = new ArrayList<>();
    private static final VotacaoController votacaoController = new VotacaoController();
    private static boolean sair = false;
    Funcionario funcionario = new Funcionario();

    public static void main(String[] args) throws AplicacaoException {


        while (!sair) {
            menu();
            int opcao = TecladoUtil.lerInteiro("Informe uma opçao:");
            executaAcao(opcao);
        }
    }


    /* private static void registrarDados() throws AplicacaoException {

         funcionarios.add(new Funcionario(2, "Arthur"));


         restaurantes.add(new Restaurante(1, "Churrascaria do Ze"));
         restaurantes.add(new Restaurante(2, "Pizza Do Sul"));
         restaurantes.add(new Restaurante(3, "Rafa Sushi"));
         restaurantes.add(new Restaurante(4, "Parrila"));

         System.out.println("Funcionarios e restaurantes registrados!");
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
     /*private static void listarFuncionarios() throws AplicacaoException{
         System.out.println("\nFuncionários cadastrados:");
         //String nome = TecladoUtil.lerString("Informe o nome da Cidade");
         //System.out.println(controllerFun.buscar(nome));
     }
     */
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

    /**
     * Método criado para chamar o voto.
     * Recebe @param um int idFuncionário.
     * Busca no banco de dados chama o metodo de comparaçao para verificar funcionário existente.
     *
     * @throws AplicacaoException tratamento de execaoo para lidar com caracteres incorretos dentro do método.
     */
    private static void votar() throws AplicacaoException {
        try {
            //listarFuncionarios();

            int idFuncionario = TecladoUtil.lerInteiro("Digite o ID do funcionário:");
            Funcionario funcionario = buscarFuncionarioPorId(idFuncionario);

            if (funcionario == null) {
                String nome = TecladoUtil.lerString("Digite seu nome");
                controllerFun.inserir(nome);
            }

            controllerRes.buscar();
            int idRestaurante = TecladoUtil.lerInteiro("Digite o ID do restaurante:");
            Restaurante restaurante = buscarRestaurantePorId(idRestaurante);

            if (restaurante == null) {
                String nome = TecladoUtil.lerString("Digite o nome do Restaurante");
                controllerRes.inserir(nome);
            }
            controllerVot.registrarVoto(funcionario, restaurante);

            System.out.println("Voto registrado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Digite apenas números nos campos de ID");
        } catch (AplicacaoException e) {
            System.out.println("Erro no sistema: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }

    }

    /**
     * Switch case para definir opcao
     * @param opcao usado para definir opção do switch case
     */
    private static void executaAcao(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    votar();
                    break;
                case 2:
                    buscarFuncionarios();
                    break;
                case 3:
                    listarRestaurantes();
                    break;
                case 4:
                    controllerVot.apurarVotacaoDoDia();
                    break;
                case 5:
                    sair = true;
                    System.out.println("Você encerrou o sistema de votação. Obrigado!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } catch (AplicacaoException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void buscarFuncionarios() throws AplicacaoException {
        System.out.println(controllerFun.buscar());
    }

    /**
     * metodo para listar restaurantes inseridos no banco de dados.
     * Localizados na classe RestauranteRepository e RestauranteControlle
     */
    private static void listarRestaurantes() throws AplicacaoException {
        System.out.println(controllerRes.buscar());
    }
    /*private static void votoRegistrado(){
        System.out.println(controllerVot.registrarVoto());
    }
    */
    private static void menu() {
        System.out.println("\n Menu Principal:");
        System.out.println("1. Votar");
        System.out.println("2. Listar Funcionarios");
        System.out.println("3. Listar Restaurantes");
        System.out.println("4. Apurar votacao do dia");
        System.out.println("5. Sair");
    }

}
