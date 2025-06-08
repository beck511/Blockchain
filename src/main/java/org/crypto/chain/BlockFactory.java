package org.crypto.chain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.crypto.block.Block;
import org.crypto.chain.data.PersistData;
import org.crypto.chain.validation.Validation;
import org.crypto.exceptions.InvalidBlockchainException;
import org.crypto.user.Input;

import java.util.Date;
public class BlockFactory {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    PersistData persistData;

    public BlockFactory() {
        this.persistData = new PersistData();
    }

    public void createNewBlock(Blockchain blockchain) throws Exception {
        if (Input.getUserInput("Would you like to add some data?").equals("y")) {
            String previousHash = null;
            if (blockchain.getBlockchainSize() > 0) {
                previousHash = blockchain.getBlock(blockchain.getBlockchainSize() - 1).getHash();
            }
            blockchain.add(new Block(Input.getUserInput("Please add some data for the block"), previousHash, new Date()));
        } else {
            return;
        }
        String dataToPersist = gson.toJson(blockchain);
        persistData.save(dataToPersist);
        System.out.println("Persisting data: " + dataToPersist);
        validate(blockchain);
    }

    /**
     * Validate the blockchain after persisting a new block.
     *
     * @param blockchain the blockchain instance to validate
     * @throws InvalidBlockchainException if the chain fails validation
     */
    private void validate(Blockchain blockchain) throws InvalidBlockchainException {
        Validation validation = new Validation();
        if (!validation.isChainValid(blockchain)) {
            throw new InvalidBlockchainException();
        }
    }
}
