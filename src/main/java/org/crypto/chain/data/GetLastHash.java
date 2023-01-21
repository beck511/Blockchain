/*
 * Copyright (c) 2023.
 */

package org.crypto.chain.data;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class GetLastHash {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("blockchain.json");
        Blockchain blockchain = gson.fromJson(reader, Blockchain.class);
        reader.close();
        String lastHash = blockchain.blockchain[blockchain.blockchain.length-1].hash;
        System.out.println("Last Hash: " + lastHash);
    }
}

class Blockchain {
    Block[] blockchain;
    int prefix;
    String prefixString;
}

class Block {
    String hash;
    String data;
    String timeStamp;
    int nonce;
}
