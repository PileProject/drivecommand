package unit.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.model.ev3.port.Ev3OutputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by yusaku on 2015/10/07.
 */
public class Ev3OutputPortTest {

    @DataProvider(name = "ports")
    public static Object[][] ports() {
        return new Object[][] {
                { Ev3OutputPort.PORT_A },
                { Ev3OutputPort.PORT_B },
                { Ev3OutputPort.PORT_C },
                { Ev3OutputPort.PORT_D },
        };
    }

    public static Pattern pattern = Pattern.compile("^\\[EV3\\] OUTPUT-PORT-[A-D].*$");

    @Test(dataProvider = "ports")
    public void testToString(Ev3OutputPort port) {
        Matcher m = pattern.matcher(port.toString());
        assertTrue(m.matches());
    }

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(Ev3OutputPort.PORT_A.getRaw(), 0);
        assertEquals(Ev3OutputPort.PORT_B.getRaw(), 1);
        assertEquals(Ev3OutputPort.PORT_C.getRaw(), 2);
        assertEquals(Ev3OutputPort.PORT_D.getRaw(), 3);
    }
}