package controller;

import dal.ProfessorDAO;
import factory.ProfessorFactory; // Importa o ProfessorDAO
import java.util.ArrayList;
import model.Professor;

public class ProfessorController {
    private ArrayList<Professor> professores;
    private ProfessorDAO professorDAO; // Instancia o DAO

    public ProfessorController() {
        this.professorDAO = new ProfessorDAO(); // Inicializa o DAO
        this.professores = professorDAO.carregar(); // Carrega usando o DAO
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
        professorDAO.salvar(professores); // Salva usando o DAO
    }
}