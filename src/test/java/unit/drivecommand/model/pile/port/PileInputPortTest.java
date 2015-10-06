package unit.drivecommand.model.pile.port;

import com.pileproject.drivecommand.model.pile.port.PileInputPort;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by yusaku on 2015/10/07.
 */
public class PileInputPortTest {

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(PileInputPort.RANGEFINDER  .getRaw(), 0);
        assertEquals(PileInputPort.TOUCH_SENSOR .getRaw(), 0);
        assertEquals(PileInputPort.LINE_SENSOR_R.getRaw(), 1);
        assertEquals(PileInputPort.LINE_SENSOR_L.getRaw(), 0);
    }
}
