package view;

import controller.*;
import factory.*;
import model.*;
import util.Logger;

import java.util.ArrayList;
import java.util.Scanner;

//TODO: mostrar lista em todas opçoes de listar e excluir
public class MenuView {
    static Scanner sc = new Scanner(System.in);
    static Aluno[] alunos = {
        new Aluno("Ana", "A001"),
        new Aluno("Bruno", "A002"),
        new Aluno("Carla", "A003")
    };

    public static void main(String[] args) {
        ProfessorController professorController = new ProfessorController();
        FaltaController faltaController = new FaltaController();
        NotaController notaController = new NotaController();
        AtividadeController atividadeController = new AtividadeController();

        int op;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Professores");
            System.out.println("2. Faltas");
            System.out.println("3. Notas");
            System.out.println("4. Atividades");
            System.out.println("0. Sair");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> crudProfessores(professorController);
                case 2 -> crudFaltas(faltaController);
                case 3 -> crudNotas(notaController);
                case 4 -> crudAtividades(atividadeController);
            }
        } while (op != 0);
    }

    static void crudProfessores(ProfessorController pc) {
        int op;
        do {
            System.out.println("\n-- Professores --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Disciplina: ");
                    String disciplina = sc.nextLine();
                    pc.cadastrar(nome, cpf, disciplina);
                }
                case 2 -> {
                    ArrayList<Professor> list = pc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        Professor p = list.get(i);
                        System.out.println("[" + i + "] " + p.getNome() + " - " + p.getCpf() + " - " + p.getDisciplina());
                    }
                }
                case 3 -> {
                    ArrayList<Professor> list = pc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        Professor p = list.get(i);
                        System.out.println("[" + i + "] " + p.getNome() + " - " + p.getCpf() + " - " + p.getDisciplina());
                    }
                    
                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    System.out.print("Disciplina: ");
                    String disc = sc.nextLine();
                    pc.editar(idx, nome, cpf, disc);
                }
                case 4 -> {
                    ArrayList<Professor> list = pc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        Professor p = list.get(i);
                        System.out.println("[" + i + "] " + p.getNome() + " - " + p.getCpf() + " - " + p.getDisciplina());
                    }
                    
                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    pc.excluir(idx);
                }
            }
        } while (op != 0);
    }

    static void crudFaltas(FaltaController fc) {
        int op;
        do {
            System.out.println("\n-- Faltas --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    String mat = escolherAluno();
                    System.out.print("Motivo: ");
                    String motivo = sc.nextLine();
                    fc.cadastrar(FaltaFactory.criar(mat, motivo));
                }
                case 2 -> {
                    var list = fc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }
                }
                case 3 -> {
                    var list = fc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }

                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    System.out.print("Nova descrição: ");
                    fc.editar(idx, sc.nextLine());
                }
                case 4 -> {
                    var list = fc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }

                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    fc.excluir(idx);
                }
            }
        } while (op != 0);
    }

    static void crudNotas(NotaController nc) {
        int op;
        do {
            System.out.println("\n-- Notas --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("0. Voltar");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    String mat = escolherAluno();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Valor: ");
                    double val = sc.nextDouble(); sc.nextLine();
                    nc.cadastrar(NotaFactory.criar(mat, desc, val));
                }
                case 2 -> {
                    var list = nc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }
                }
                case 3 -> {
                    var list = nc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }

                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    System.out.print("Nova descrição: ");
                    String desc = sc.nextLine();
                    System.out.print("Novo valor: ");
                    double val = sc.nextDouble(); sc.nextLine();
                    nc.editarNota(idx, desc, val);
                }
                case 4 -> {
                    var list = nc.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }

                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    nc.excluir(idx);
                }
            }
        } while (op != 0);
    }

    static void crudAtividades(AtividadeController ac) {
        int op;
        do {
            System.out.println("\n-- Atividades --");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Editar");
            System.out.println("4. Excluir");
            System.out.println("5. Lançar para turma");
            System.out.println("0. Voltar");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    String mat = escolherAluno();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    ac.cadastrar(AtividadeFactory.criar(mat, desc));
                }
                case 2 -> {
                    var list = ac.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }
                }
                case 3 -> {
                    var list = ac.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }

                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    System.out.print("Nova descrição: ");
                    ac.editar(idx, sc.nextLine());
                }
                case 4 -> {
                    var list = ac.listar();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("[" + i + "] " + list.get(i).exibir());
                    }
                    
                    System.out.print("Índice: ");
                    int idx = sc.nextInt(); sc.nextLine();
                    ac.excluir(idx);
                }
                case 5 -> {
                    System.out.print("Descrição: ");
                    ac.lancarParaTurma(alunos, sc.nextLine());
                }
            }
        } while (op != 0);
    }

    static String escolherAluno() {
        for (Aluno a : alunos) {
            System.out.println(a.getMatricula() + " - " + a.getNome());
        }
        System.out.print("Escolha matrícula: ");
        return sc.nextLine();
    }
}