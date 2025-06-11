package util.dao;

import java.io.*;
import util.Logger;

public class Serializador {
    public static void salvar(Object obj, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            Logger.registrar("Erro ao salvar: " + e.getMessage());
        }
    }

    public static Object carregar(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            Logger.registrar("Erro ao carregar: " + e.getMessage());
            return null;
        }
    }
}