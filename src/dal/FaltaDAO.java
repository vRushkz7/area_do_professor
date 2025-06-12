package dal;

import model.Falta;
import util.Logger;
import java.io.*;
import java.util.ArrayList;

public class FaltaDAO {
    private final String ARQUIVO = "faltas.dat";

    public void salvar(ArrayList<Falta> faltas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(faltas);
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar faltas: " + e.getMessage());
        }
    }

    public ArrayList<Falta> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (ArrayList<Falta>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.registrar("Erro ao carregar faltas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}