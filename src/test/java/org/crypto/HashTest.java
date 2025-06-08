import org.crypto.block.Hash;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class HashTest {
    @Test
    void calculateHashProducesSameResultForSameInput() {
        String previous = "prev";
        String data = "data";
        Date timestamp = new Date(0);
        long nonce = 123L;

        String first = Hash.calculateHash(previous, data, timestamp, nonce);
        String second = Hash.calculateHash(previous, data, timestamp, nonce);

        assertEquals(first, second);
    }
}
