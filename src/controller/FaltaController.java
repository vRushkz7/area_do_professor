package controller;

import dal.FaltaDAO;
import java.util.ArrayList;
import model.Falta;

public class FaltaController {
    private ArrayList<Falta> faltas;
    private FaltaDAO faltaDAO;

    public FaltaController() {
        this.faltaDAO = new FaltaDAO();
        this.faltas = faltaDAO.carregar();
    }

    public void cadastrar(Falta falta) {
        faltas.add(falta);
        salvar();
    }

    public void editar(int index, String novaDescricao) {
        faltas.get(index).setDescricao(novaDescricao);
        salvar();
    }

    public void excluir(int index) {
        faltas.remove(index);
        salvar();
    }

    public ArrayList<Falta> listar() {
        return faltas;
    }

    private void salvar() {
        faltaDAO.salvar(faltas);
    }
}