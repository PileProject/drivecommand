package unit.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.model.nxt.port.NxtInputPort;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by yusaku on 2015/10/07.
 */
public class NxtInputPortTest {

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(NxtInputPort.PORT_1.getRaw(), 0);
        assertEquals(NxtInputPort.PORT_2.getRaw(), 1);
        assertEquals(NxtInputPort.PORT_3.getRaw(), 2);
        assertEquals(NxtInputPort.PORT_4.getRaw(), 3);
    }
}