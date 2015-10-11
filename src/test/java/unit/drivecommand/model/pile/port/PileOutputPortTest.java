package unit.drivecommand.model.pile.port;

import com.pileproject.drivecommand.model.pile.port.PileOutputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by yusaku on 2015/10/07.
 */
public class PileOutputPortTest {

    @DataProvider(name = "ports")
    public static Object[][] knownPorts() {
        return new Object[][] {
                { PileOutputPort.MOTOR_LEFT },
                { PileOutputPort.MOTOR_RIGHT },
        };
    }

    public static Pattern pattern = Pattern.compile(
            "^\\[PILE\\] OUTPUT-PORT-MOTOR_(LEFT|RIGHT).*$"
    );

    @Test( dataProvider = "ports" )
    public void testToString(PileOutputPort port) {
        Matcher m = pattern.matcher(port.toString());
        assertTrue(m.matches());
    }
    @Test
    public void testGetRaw() throws Exception {
        assertEquals(PileOutputPort.MOTOR_LEFT .getRaw(), 0);
        assertEquals(PileOutputPort.MOTOR_RIGHT.getRaw(), 1);
    }
}