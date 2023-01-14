package org.crypto.chain.data;

import java.io.*;

public class PersistData {
    private final String fileName = "blockchain.data";

    public PersistData() {
    }

    public void save(String data) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName, true);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(data);
        oos.close();
    }

    public String load() throws IOException, ClassNotFoundException {
        String data = null;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            data = (String) ois.readObject();
        }
        return data;
    }

}