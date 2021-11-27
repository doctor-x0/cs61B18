import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FilkTest {
    @Test
    public void testFilk() {
        assertTrue(Flik.isSameNumber(3, 3));
        assertFalse(Flik.isSameNumber(3, 4));
    }
}
