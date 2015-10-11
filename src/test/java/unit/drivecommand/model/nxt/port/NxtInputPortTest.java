package unit.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.model.nxt.port.NxtInputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by yusaku on 2015/10/07.
 */
public class NxtInputPortTest {

    @DataProvider(name = "ports")
    public static Object[][] ports() {
        return new Object[][] {
                { NxtInputPort.PORT_1 },
                { NxtInputPort.PORT_2 },
                { NxtInputPort.PORT_3 },
                { NxtInputPort.PORT_4 },
        };
    }

    public static Pattern pattern = Pattern.compile("^\\[NXT\\] INPUT-PORT-[1-4].*$");

    @Test(dataProvider = "ports")
    public void testToString(NxtInputPort port) {
        Matcher m = pattern.matcher(port.toString());
        assertTrue(m.matches());
    }

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(NxtInputPort.PORT_1.getRaw(), 0);
        assertEquals(NxtInputPort.PORT_2.getRaw(), 1);
        assertEquals(NxtInputPort.PORT_3.getRaw(), 2);
        assertEquals(NxtInputPort.PORT_4.getRaw(), 3);
    }
}