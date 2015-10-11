package unit.drivecommand.model.pile.port;

import com.pileproject.drivecommand.model.pile.port.PileInputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by yusaku on 2015/10/07.
 */
public class PileInputPortTest {

    @DataProvider(name = "ports")
    public static Object[][] ports() {
        return new Object[][] {
                { PileInputPort.LINE_SENSOR_L },
                { PileInputPort.LINE_SENSOR_R },
                { PileInputPort.TOUCH_SENSOR },
                { PileInputPort.RANGEFINDER },
        };
    }

    public static Pattern pattern = Pattern.compile(
            "^\\[PILE\\] INPUT-PORT-(LINE_SENSOR_*|TOUCH_SENSOR|RANGEFINDER).*$"
    );

    @Test(dataProvider = "ports")
    public void testToString(PileInputPort port) {
        Matcher m = pattern.matcher(port.toString());
        assertTrue(m.matches());
    }

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(PileInputPort.RANGEFINDER  .getRaw(), 0);
        assertEquals(PileInputPort.TOUCH_SENSOR .getRaw(), 0);
        assertEquals(PileInputPort.LINE_SENSOR_L.getRaw(), 0);
        assertEquals(PileInputPort.LINE_SENSOR_R.getRaw(), 1);
    }
}
