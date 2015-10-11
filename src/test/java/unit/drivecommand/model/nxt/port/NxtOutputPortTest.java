package unit.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.model.nxt.port.NxtOutputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by yusaku on 2015/10/07.
 */
public class NxtOutputPortTest {

    @DataProvider(name = "ports")
    public static Object[][] ports() {
        return new Object[][] {
                { NxtOutputPort.PORT_A },
                { NxtOutputPort.PORT_B },
                { NxtOutputPort.PORT_C },
        };
    }

    public static Pattern pattern = Pattern.compile("^\\[NXT\\] OUTPUT-PORT-[A-C].*$");

    @Test(dataProvider = "ports")
    public void testToString(NxtOutputPort port) {
        Matcher m = pattern.matcher(port.toString());
        assertTrue(m.matches());
    }

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(NxtOutputPort.PORT_A.getRaw(), 0);
        assertEquals(NxtOutputPort.PORT_B.getRaw(), 1);
        assertEquals(NxtOutputPort.PORT_C.getRaw(), 2);
    }
}