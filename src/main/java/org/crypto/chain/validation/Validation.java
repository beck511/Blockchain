package org.crypto.chain.validation;

import org.crypto.block.Block;
import org.crypto.block.Hash;
import org.crypto.chain.Blockchain;

public class Validation {
    Hash hash;

    public boolean isChainValid(Blockchain blockchain) {
        //loop through blockchain to check hashes:
        for (int i = 1; i < blockchain.getBlockchainSize(); i++) {
            Block currentBlock = blockchain.getBlock(i);
            Block previousBlock = blockchain.getBlock(i - 1);
            //compare registered hash and calculated hash:
            if (!currentBlock.getHash().equals(Hash.calculateHash(previousBlock.getHash(), currentBlock.getData(), currentBlock.getTimeStamp(), currentBlock.getNonce()))) {
                System.out.println("Hashes not equal");
                return false;
            }
        }
        return true;
    }
}
