package org.crypto.chain;

import org.crypto.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    List<Block> blockchain = new ArrayList<>();
    int prefix = 8;
    String prefixString = new String(new char[prefix]).replace('\0', '0');
    public List<Block> getBlockchain() {
        return blockchain;
    }

    public Block getBlock(int number) {
        return blockchain.get(number);
    }

    public String getPrefixString() {
        return prefixString;
    }

    public int getBlockchainSize() {
        return blockchain.size();
    }

    public void add(Block block) {
        blockchain.add(block);
    }
}
