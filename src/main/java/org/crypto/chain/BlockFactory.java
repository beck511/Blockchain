package org.crypto.chain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.crypto.block.Block;
import org.crypto.chain.data.PersistData;
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
            blockchain.add(new Block(Input.getUserInput("Please add some data for the block"), null, new Date()));
        } else {
            return;
        }
        String dataToPersist = gson.toJson(blockchain);
        persistData.save(dataToPersist);
        System.out.println("Persisting data: " + dataToPersist);
        //TODO - validate();
    }
}
