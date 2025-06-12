package dal;

import model.Professor;
import util.Logger; // O Logger continua em 'util'
import java.io.*;
import java.util.ArrayList;

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
            // Este erro é esperado na primeira execução, quando o arquivo ainda não existe.
            // Apenas registra e retorna uma lista vazia.
            Logger.registrar("Erro ao carregar professores: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}