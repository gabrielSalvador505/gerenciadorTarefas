package controller;

import objects.Tarefa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TarefaController {

    public static Scanner sc = new Scanner(System.in);
    private static List<Tarefa> listaTarefas = new ArrayList<>();
    private static int proximoId;

    public static void adicionarTarefa() {

        int id = proximoId;
        proximoId++;

        System.out.println("Titulo:");
        String titulo = sc.nextLine();

        System.out.println("Descricao:");
        String descricao = sc.nextLine();

        System.out.println("Data de entrega:");
        LocalDate prazo = LocalDate.parse(sc.nextLine());

        Tarefa novaTarefa = new Tarefa(id, titulo, descricao, prazo);
        listaTarefas.add(novaTarefa);
    }

    public static void concluirTarefa() {
        System.out.println("Id:");
        int id = sc.nextInt();
        sc.nextLine();
        for (Tarefa tarefa : listaTarefas) {
            if (id == tarefa.getId()) {
                tarefa.setConcluida(true);
            }
        }
    }

    public static void listarTarefas() {
        for (Tarefa tarefa : listaTarefas) {
            System.out.println(tarefa.toString());
        }
    }
}
