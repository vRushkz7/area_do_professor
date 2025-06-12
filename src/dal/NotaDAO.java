package dal;

import model.Nota;
import util.Logger;
import java.io.*;
import java.util.ArrayList;

public class NotaDAO {
    private final String ARQUIVO = "notas.dat";

    public void salvar(ArrayList<Nota> notas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(notas);
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar notas: " + e.getMessage());
        }
    }

    public ArrayList<Nota> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (ArrayList<Nota>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.registrar("Erro ao carregar notas: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}