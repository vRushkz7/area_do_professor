package controller;

import dal.AtividadeDAO;
import java.util.ArrayList;
import model.Aluno;
import model.Atividade;

public class AtividadeController {
    private ArrayList<Atividade> atividades;

    public AtividadeController() {
        this.atividades = AtividadeDAO.carregar();
    }

    public void cadastrar(Atividade atividade) {
        atividades.add(atividade);
        salvar();
    }

    public void editar(int index, String novaDescricao) {
        atividades.get(index).setDescricao(novaDescricao);
        salvar();
    }

    public void excluir(int index) {
        atividades.remove(index);
        salvar();
    }

    public void lancarParaTurma(Aluno[] alunos, String descricao) {
        for (Aluno a : alunos) {
            atividades.add(new Atividade(a.getMatricula(), descricao));
        }
        salvar();
    }

    public ArrayList<Atividade> listar() {
        return atividades;
    }

    private void salvar() {
        AtividadeDAO.salvar(atividades);
    }
}