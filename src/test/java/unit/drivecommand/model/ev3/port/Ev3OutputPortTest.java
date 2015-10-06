package unit.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.model.ev3.port.Ev3OutputPort;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by yusaku on 2015/10/07.
 */
public class Ev3OutputPortTest {

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(Ev3OutputPort.PORT_A.getRaw(), 0);
        assertEquals(Ev3OutputPort.PORT_B.getRaw(), 1);
        assertEquals(Ev3OutputPort.PORT_C.getRaw(), 2);
    }
}