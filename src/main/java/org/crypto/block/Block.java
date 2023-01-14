package org.crypto.block;

import java.util.Date;

public class Block {
    private final String hash;
    private final String data;
    private final Date timeStamp;
    private final String previousHash;
    private final int nonce = 8;

    public Block(String data, String previousHash, Date timeStamp) {
        this.data = data;
        this.timeStamp = timeStamp;
        this.previousHash = previousHash;
        hash = Hash.calculateHash(previousHash, data, timeStamp, nonce);
    }

    public String getData() {
        return data;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {return previousHash; }
}
