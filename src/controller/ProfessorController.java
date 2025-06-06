package controller;

import factory.ProfessorFactory;
import model.Professor;
import util.Serializador;

import java.util.ArrayList;

public class ProfessorController {
    private final String ARQUIVO = "professores.dat";
    private ArrayList<Professor> professores;

    public ProfessorController() {
        Object obj = Serializador.carregar(ARQUIVO);
        if (obj != null) {
            professores = (ArrayList<Professor>) obj;
        } else {
            professores = new ArrayList<>();
        }
    }

    public void cadastrar(String nome, String cpf, String disciplina) {
        professores.add(ProfessorFactory.criar(nome, cpf, disciplina));
        salvar();
    }

    public ArrayList<Professor> listar() {
        return professores;
    }

    public void editar(int index, String nome, String cpf, String disciplina) {
        Professor p = professores.get(index);
        p.setNome(nome);
        p.setCpf(cpf);
        p.setDisciplina(disciplina);
        salvar();
    }

    public void excluir(int index) {
        professores.remove(index);
        salvar();
    }

    private void salvar() {
        Serializador.salvar(professores, ARQUIVO);
    }
}