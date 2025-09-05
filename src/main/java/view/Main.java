package view;

import servico.TarefaServico;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TarefaServico servico = new TarefaServico();

        int opcao;
        do {
            System.out.println("=== MENU TO-DO LIST ===");
            System.out.println("1 - Criar tarefa");
            System.out.println("2 - Mostrar tarefas");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    servico.criarTarefa();
                    break;
                case 2:
                    servico.mostrarTarefas();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);

        scanner.close();
    }
}
