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

    public void setBlockchain(List<Block> blockchain) {
        this.blockchain = blockchain;
    }

    public String getPrefixString() {
        return prefixString;
    }

    public void setPrefixString(String prefixString) {
        this.prefixString = prefixString;
    }
}
