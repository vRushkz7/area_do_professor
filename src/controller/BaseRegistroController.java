package controller;

import model.RegistroAcademico;
import util.Serializador;

import java.util.ArrayList;

public abstract class BaseRegistroController<T extends RegistroAcademico> {
    protected ArrayList<T> registros;
    protected String arquivo;

    public BaseRegistroController(String arquivo) {
        this.arquivo = arquivo;
        Object obj = Serializador.carregar(arquivo);
        if (obj != null) {
            registros = (ArrayList<T>) obj;
        } else {
            registros = new ArrayList<>();
        }
    }

    public void cadastrar(T registro) {
        registros.add(registro);
        salvar();
    }

    public void editar(int index, String novaDescricao) {
        registros.get(index).setDescricao(novaDescricao);
        salvar();
    }

    public void excluir(int index) {
        registros.remove(index);
        salvar();
    }

    public ArrayList<T> listar() {
        return registros;
    }

    protected void salvar() {
        Serializador.salvar(registros, arquivo);
    }
}