package unit.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.model.ev3.port.Ev3InputPort;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by yusaku on 2015/10/07.
 */
public class Ev3InputPortTest {

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(Ev3InputPort.PORT_1.getRaw(), 0);
        assertEquals(Ev3InputPort.PORT_2.getRaw(), 1);
        assertEquals(Ev3InputPort.PORT_3.getRaw(), 2);
        assertEquals(Ev3InputPort.PORT_4.getRaw(), 3);
    }
}