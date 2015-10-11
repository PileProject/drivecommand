package unit.drivecommand.model.ev3.port;

import com.pileproject.drivecommand.model.ev3.port.Ev3InputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by yusaku on 2015/10/07.
 */
public class Ev3InputPortTest {

    @DataProvider(name = "ports")
    public static Object[][] ports() {
        return new Object[][] {
                { Ev3InputPort.PORT_1 },
                { Ev3InputPort.PORT_2 },
                { Ev3InputPort.PORT_3 },
                { Ev3InputPort.PORT_4 },
        };
    }

	public static Pattern pattern = Pattern.compile("^\\[EV3\\] INPUT-PORT-[1-4].*$");

	@Test(dataProvider = "ports")
	public void testToString(Ev3InputPort port) {
		Matcher m = pattern.matcher(port.toString());
		assertTrue(m.matches());
	}

    @Test
    public void testGetRaw() throws Exception {
        assertEquals(Ev3InputPort.PORT_1.getRaw(), 0);
        assertEquals(Ev3InputPort.PORT_2.getRaw(), 1);
        assertEquals(Ev3InputPort.PORT_3.getRaw(), 2);
        assertEquals(Ev3InputPort.PORT_4.getRaw(), 3);
    }
}