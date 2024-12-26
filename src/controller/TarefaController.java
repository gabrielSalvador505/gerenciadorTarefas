package controller;

import objects.Tarefa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class TarefaController {

    public static Scanner sc = new Scanner(System.in);
    private static List<Tarefa> listaTarefas = new ArrayList<>();
    private static int proximoId;
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");

    public static void adicionarTarefa() {

        int id = proximoId;
        proximoId++;

        System.out.println("Titulo:");
        String titulo = sc.nextLine();

        System.out.println("Descricao:");
        String descricao = sc.nextLine();

        System.out.println("Data de entrega: [dd/MM/yy]");
        LocalDate prazo = LocalDate.parse(sc.nextLine(), formatter);

        Tarefa novaTarefa = new Tarefa(id, titulo, descricao, prazo);
        listaTarefas.add(novaTarefa);
    }

    public static void concluirTarefa() {
        listarTarefas();
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

    public static void detalharTarefa() {
        listarTarefas();

        System.out.println("Selecione uma tarefa: [id]");
        int id = sc.nextInt();
        sc.nextLine();

        for (Tarefa tarefa : listaTarefas) {
            if (tarefa.getId() == id) {

                //retorna com precisão a diferença em dias entre duas datas
                long dias = ChronoUnit.DAYS.between(LocalDate.now(), tarefa.getPrazo());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Título: " + tarefa.getTitulo());
                System.out.println("Descricao: " + tarefa.getDescricao());
                System.out.println("Entrega: " + formatter.format(tarefa.getPrazo()));
                System.out.println(dias + " dias para entrega");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            } else {
                System.out.println("id inválido");
            }
        }
    }
}
