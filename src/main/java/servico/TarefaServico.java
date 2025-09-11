package servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Tarefa;

public class TarefaServico {

    private List<Tarefa> listaDeTarefas = new ArrayList<>();
    private int proximoId = 1;
    private Scanner scanner = new Scanner(System.in);

    // Criar nova tarefa interativamente
    public void criarTarefa() {
        System.out.println("criar uma nova tarefa!");
        System.out.print("Digite o título da tarefa: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite a descrição da tarefa: ");
        String descricao = scanner.nextLine();

        Tarefa tarefa = new Tarefa(proximoId++, titulo, descricao, false);
        listaDeTarefas.add(tarefa);

        System.out.println("Parabéns! Tarefa criada: " + titulo + "\n");
    }

    // Mostrar todas as tarefas
    public void mostrarTarefas() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Opaa! Ainda não há tarefas cadastradas.\n");
            return;
        }

        System.out.println("=== Suas tarefas ===");
        for (Tarefa t : listaDeTarefas) {
            String status = t.isCompleta() ? "Concluída" : "Pendente";
            System.out.println(t.getId() + " - " + t.getTitulo() + " | " + t.getDescricao() + " [" + status + "] - Criada em: " + t.getDataAgora());
        }
        System.out.println("Total de tarefas cadastradas: " + listaDeTarefas.size());
        System.out.println();
    }


    // Atualizar tarefa
    public void atualizarTarefa() {
        mostrarTarefas();
        System.out.print("Digite o ID da tarefa que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Tarefa tarefa = buscarPorId(id);
        if (tarefa == null) {
            System.out.println("ERRO! Tarefa não encontrada.\n");
            return;
        }

        System.out.print("Novo título: ");
        String novoTitulo = scanner.nextLine();
        System.out.print("Nova descrição: ");
        String novaDescricao = scanner.nextLine();

        tarefa.setTitulo(novoTitulo);
        tarefa.setDescricao(novaDescricao);

        System.out.println("Tarefa atualizada com sucesso!\n");
    }

    // Remover tarefa
    public void removerTarefa() {
        mostrarTarefas();
        System.out.print("Digite o ID da tarefa que deseja remover: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Tarefa tarefa = buscarPorId(id);
        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.\n");
            return;
        }

        listaDeTarefas.remove(tarefa);
        System.out.println("Tarefa removida!\n");
    }

    // Marcar como concluída
    public void concluirTarefa() {
        mostrarTarefas();
        System.out.print("Digite o ID da tarefa que deseja marcar como concluída: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Tarefa tarefa = buscarPorId(id);
        if (tarefa == null) {
            System.out.println("Tarefa não encontrada.\n");
            return;
        }

        tarefa.setCompleta(true);
        System.out.println("Tarefa concluída!\n");
    }

    // Buscar tarefa pelo ID
    private Tarefa buscarPorId(int id) {
        for (Tarefa t : listaDeTarefas) {
            if (t.getId() == id) return t;
        }
        return null;
    }
