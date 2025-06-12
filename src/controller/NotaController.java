package controller;

import dal.NotaDAO; // Importa o NotaDAO
import java.util.ArrayList;
import model.Nota;

public class NotaController {
    private ArrayList<Nota> notas;
    private NotaDAO notaDAO; // Instancia o DAO

    public NotaController() {
        this.notaDAO = new NotaDAO(); // Inicializa o DAO
        this.notas = notaDAO.carregar(); // Carrega usando o DAO
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
        notaDAO.salvar(notas); // Salva usando o DAO
    }
}