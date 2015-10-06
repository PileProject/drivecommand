package unit.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.model.nxt.port.NxtOutputPort;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by yusaku on 2015/10/07.
 */
public class NxtOutputPortTest {

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(NxtOutputPort.PORT_A.getRaw(), 0);
        assertEquals(NxtOutputPort.PORT_B.getRaw(), 1);
        assertEquals(NxtOutputPort.PORT_C.getRaw(), 2);
    }
}