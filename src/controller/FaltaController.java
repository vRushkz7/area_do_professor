package controller;

import dal.FaltaDAO; // Importa o FaltaDAO
import java.util.ArrayList;
import model.Falta;

public class FaltaController {
    private ArrayList<Falta> faltas;
    private FaltaDAO faltaDAO; // Instancia o DAO

    public FaltaController() {
        this.faltaDAO = new FaltaDAO(); // Inicializa o DAO
        this.faltas = faltaDAO.carregar(); // Carrega usando o DAO
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
        faltaDAO.salvar(faltas); // Salva usando o DAO
    }
}