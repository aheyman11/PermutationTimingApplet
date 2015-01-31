import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm2Test {
    Algorithm2 algorithm2;

    @Before
    public void setUp() throws Exception {
        algorithm2 = new Algorithm2();

    }

    @Test
    public void testPermute() throws Exception {
        algorithm2.permute(10);
    }
}