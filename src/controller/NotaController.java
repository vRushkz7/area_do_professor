package controller;

import dal.NotaDAO;
import java.util.ArrayList;
import model.Nota;

public class NotaController {
    private ArrayList<Nota> notas;
    private NotaDAO notaDAO;

    public NotaController() {
        this.notaDAO = new NotaDAO();
        this.notas = notaDAO.carregar();
    }

    public void cadastrar(Nota nota) {
        notas.add(nota);
        salvar();
    }

    public void editarNota(int index, String novaDescricao, double novoValor) {
        Nota nota = notas.get(index);
        nota.setDescricao(novaDescricao);
        nota.setValor(novoValor);
        salvar();
    }

    public void excluir(int index) {
        notas.remove(index);
        salvar();
    }

    public ArrayList<Nota> listar() {
        return notas;
    }

    private void salvar() {
        notaDAO.salvar(notas);
    }
}