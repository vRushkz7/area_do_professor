package controller;

import model.Nota;

public class NotaController extends BaseRegistroController<Nota> {
    public NotaController() {
        super("notas.dat");
    }

    public void editarNota(int index, String novaDescricao, double novoValor) {
        Nota nota = registros.get(index);
        nota.setDescricao(novaDescricao);
        nota.setValor(novoValor);
        salvar();
    }
}