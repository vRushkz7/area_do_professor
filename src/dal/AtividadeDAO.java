package dal;

import model.Atividade;
import util.Logger;
import java.io.*;
import java.util.ArrayList;

public class AtividadeDAO {
    private final String ARQUIVO = "atividades.dat";

    public void salvar(ArrayList<Atividade> atividades) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(atividades);
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar atividades: " + e.getMessage());
        }
    }

    public ArrayList<Atividade> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (ArrayList<Atividade>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.registrar("Erro ao carregar atividades: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}