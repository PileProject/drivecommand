package unit.drivecommand.model.pile.port;

import com.pileproject.drivecommand.model.pile.port.PileOutputPort;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by yusaku on 2015/10/07.
 */
public class PileOutputPortTest {

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(PileOutputPort.MOTOR_LEFT .getRaw(), 0);
        assertEquals(PileOutputPort.MOTOR_RIGHT.getRaw(), 1);
    }
}