package org.crypto.block;

import java.util.Date;
import java.util.Random;

public class Block {
    private final String hash;
    private final String data;
    private final Date timestamp;
    private final String previousHash;
    private final long nonce = new Random().nextLong();

    public Block(String data, String previousHash, Date timestamp) {
        this.data = data;
        this.timestamp = timestamp;
        this.previousHash = previousHash;
        hash = Hash.calculateHash(previousHash, data, timestamp, nonce);
    }

    public String getData() {
        return data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public long getNonce() {
        return nonce;
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {return previousHash; }
}
