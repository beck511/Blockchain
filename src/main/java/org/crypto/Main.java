package org.crypto;

import org.crypto.chain.BlockFactory;
import org.crypto.chain.Blockchain;

public class Main {
    public static Blockchain blockchain = new Blockchain();
    public static void main(String[] args) throws Exception {

        while (true) {
            new BlockFactory().createNewBlock(blockchain);
        }
    }
}