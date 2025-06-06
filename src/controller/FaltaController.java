package controller;

import model.Falta;

public class FaltaController extends BaseRegistroController<Falta> {
    public FaltaController() {
        super("faltas.dat");
    }
}