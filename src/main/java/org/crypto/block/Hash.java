package org.crypto.block;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import static org.apache.commons.codec.binary.Hex.encodeHexString;

public class Hash {

    private static final String algorithm = "SHA-512";

    public static String calculateHash(String previousHash, String data, Date timeStamp, int nonce) {
        if (previousHash == null)
        {previousHash = "001-Genesis-Block-001";}
        String dataToHash = previousHash + data + timeStamp + nonce;
        byte[] bytes;
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            bytes = digest.digest(dataToHash.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalArgumentException("Invalid hash algorithm: " + algorithm, ex);
        }
        return encodeHexString(bytes);
    }
}
