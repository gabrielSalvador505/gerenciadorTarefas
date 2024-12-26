package app;

import controller.*;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean i = true;
        while (i) {
            header();
            i = action(sc.nextInt());
        }

        System.out.println("-- SISTEMA FINALIZADO PELO OPERADOR --");
    }

    public static void header() {
        System.out.println("-- Tarefas --");
        System.out.println("1. listar tarefas");
        System.out.println("2. adicioanr tarefa");
        System.out.println("3. concluir tarefas");
        System.out.println("4. finalizar");

    }

    public static boolean action(int act) {
        return switch (act) {
            case 1 -> {
                TarefaController.listarTarefas();
                yield true;
            }
            case 2 -> {
                TarefaController.adicionarTarefa();
                yield true;
            }
            case 3 -> {
                TarefaController.concluirTarefa();
                yield true;
            }
            default -> false;
        };
    }
}
