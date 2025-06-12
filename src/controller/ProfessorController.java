package controller;

import dal.ProfessorDAO;
import factory.ProfessorFactory;
import java.util.ArrayList;
import model.Professor;

public class ProfessorController {
    private ArrayList<Professor> professores;
    private ProfessorDAO professorDAO;

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO(); 
        this.professores = professorDAO.carregar(); 
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
        professorDAO.salvar(professores);
    }
}