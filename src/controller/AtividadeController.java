package controller;

import model.Atividade;
import model.Aluno;

public class AtividadeController extends BaseRegistroController<Atividade> {
    public AtividadeController() {
        super("atividades.dat");
    }

    public void lancarParaTurma(Aluno[] alunos, String descricao) {
        for (Aluno a : alunos) {
            registros.add(new Atividade(a.getMatricula(), descricao));
        }
        salvar();
    }
}