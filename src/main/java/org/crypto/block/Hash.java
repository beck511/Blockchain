package org.crypto.block;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Hash {
    private final Logger logger = LoggerFactory.getLogger(Hash.class);

    public String calculateHash(String previousHash, LocalDateTime timeStamp, int nonce, String data) {
        String dataToHash = previousHash
                + timeStamp
                + nonce
                + data;
        byte[] bytes = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            bytes = digest.digest(dataToHash.getBytes(UTF_8));
        } catch (NoSuchAlgorithmException ex) {
            logger.error(ex.getMessage());
        }
        StringBuilder buffer = new StringBuilder();
        for (byte b : Objects.requireNonNull(bytes)) {
            buffer.append(String.format("%02x", b));
        }
        return buffer.toString();
    }
}
