package unit.drivecommand.device.port;

import com.pileproject.drivecommand.machine.device.port.DevicePort;
import com.pileproject.drivecommand.model.ev3.port.Ev3InputPort;
import com.pileproject.drivecommand.model.ev3.port.Ev3OutputPort;
import com.pileproject.drivecommand.model.nxt.port.NxtInputPort;
import com.pileproject.drivecommand.model.nxt.port.NxtOutputPort;
import com.pileproject.drivecommand.model.pile.port.PileInputPort;
import com.pileproject.drivecommand.model.pile.port.PileOutputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by yusaku on 2015/10/07.
 */
public class DevicePortTest {
    @DataProvider(name = "ports")
    public static Object[][] knownPorts() {
        return new Object[][] {
                { PileOutputPort.MOTOR_LEFT },
                { PileOutputPort.MOTOR_RIGHT },

                { NxtOutputPort.PORT_A },
                { NxtOutputPort.PORT_B },
                { NxtOutputPort.PORT_C },

                { Ev3OutputPort.PORT_A },
                { Ev3OutputPort.PORT_B },
                { Ev3OutputPort.PORT_C },

                { PileInputPort.LINE_SENSOR_L },
                { PileInputPort.LINE_SENSOR_R },
                { PileInputPort.TOUCH_SENSOR },
                { PileInputPort.RANGEFINDER },

                { NxtInputPort.PORT_1 },
                { NxtInputPort.PORT_2 },
                { NxtInputPort.PORT_3 },
                { NxtInputPort.PORT_4 },

                { Ev3InputPort.PORT_1 },
                { Ev3InputPort.PORT_2 },
                { Ev3InputPort.PORT_3 },
                { Ev3InputPort.PORT_4 },
        };
    }

    public static Pattern pattern = Pattern.compile("^\\[(PILE|NXT|EV3)\\] (INPUT|OUTPUT)-PORT-.*$");

    @Test( dataProvider = "ports" )
    public void testToString(DevicePort port) {
        Matcher m = pattern.matcher(port.toString());
        assertTrue(m.matches());
    }

}