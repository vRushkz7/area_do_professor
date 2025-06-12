package dal;

import java.io.*;
import java.util.ArrayList;
import model.Professor;
import util.Logger;

public class ProfessorDAO {
    private final String ARQUIVO = "professores.dat";

    public void salvar(ArrayList<Professor> professores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(professores);
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar professores: " + e.getMessage());
        }
    }

    public ArrayList<Professor> carregar() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (ArrayList<Professor>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {

            Logger.registrar("Erro ao carregar professores: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}