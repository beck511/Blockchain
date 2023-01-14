package org.crypto.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidBlockchainException extends Throwable {
    Logger logger = LoggerFactory.getLogger(InvalidBlockchainException.class);

    public InvalidBlockchainException() {
        logger.error("Invalid blockchain validation!");
    }
}
