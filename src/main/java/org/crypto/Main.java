package org.crypto;

import org.crypto.block.Block;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Block genesisBlock = new Block(null,null, LocalDateTime.now());
        System.out.println("Hash for block 1 : " + genesisBlock.getHash());

        Block secondBlock = new Block("Yo im the second block", genesisBlock.getHash(), LocalDateTime.now());
        System.out.println("Hash for block 2 : " + secondBlock.getHash());

        Block thirdBlock = new Block("Hey im the third block", secondBlock.getHash(), LocalDateTime.now());
        System.out.println("Hash for block 3 : " + thirdBlock.getHash());
    }
}