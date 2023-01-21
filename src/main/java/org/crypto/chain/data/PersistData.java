package org.crypto.chain.data;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class PersistData {
    private final String fileName = "blockchain.data";

    public PersistData() {
    }

    public void save(String data) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName, true);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        osw.write(data);
        osw.close();
    }

    public String load() throws IOException {
        String data;
        try (FileInputStream fis = new FileInputStream(fileName);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8)) {
            BufferedReader br = new BufferedReader(isr);
            data = br.readLine();
        }
        return data;
    }
}