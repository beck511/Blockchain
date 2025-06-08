import org.crypto.block.Block;
import org.crypto.chain.Blockchain;
import org.crypto.chain.validation.Validation;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationTest {
    @Test
    void validChainReturnsTrue() {
        Blockchain bc = new Blockchain();
        Block first = new Block("one", null, new Date(0));
        bc.add(first);
        Block second = new Block("two", first.getHash(), new Date(1000));
        bc.add(second);

        Validation validation = new Validation();
        assertTrue(validation.isChainValid(bc));
    }
}
