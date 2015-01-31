import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm3Test {
    Algorithm3 algorithm3;

    @Before
    public void setUp() throws Exception {
        algorithm3 = new Algorithm3();
    }

    @Test
    public void testPermute() throws Exception {
        algorithm3.permute(10);
    }

}