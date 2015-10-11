package unit.drivecommand.machine.device.input;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.machine.device.DeviceType;
import com.pileproject.drivecommand.machine.device.input.ColorSensor;
import com.pileproject.drivecommand.machine.device.port.InputPort;
import com.pileproject.drivecommand.model.ProtocolBase;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.HashMap;

import mockit.Expectations;
import mockit.Mocked;

@SuppressWarnings("serial")
public class ColorSensorTest {
    @Mocked
    private ProtocolBase protocol;
    private final InputPort PORT = new InputPort() {
        @Override
        public int getRaw() {
            return 1;
        }
    };
    private final float[] VALUE_RGB = {0, 100, 255};
    private final int VALUE_ILLUMINANCE = 22;
    private final String KEY_VALUE = "value";
    
    @Test
    public void getColorRgb() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALUE, VALUE_RGB);
            }};
        }};
        ColorSensor cs = new ColorSensor(PORT, protocol);
        AssertJUnit.assertEquals(cs.getRgb(), VALUE_RGB);
    }
    
    @Test
    public void getColorIlluminance() {
        new Expectations() {{
            protocol.exec(PORT.getRaw(), (CommandBase) any);
            result = new HashMap<String, Object>() {{
                put(KEY_VALUE, VALUE_ILLUMINANCE);
            }};
        }};
        ColorSensor cs = new ColorSensor(PORT, protocol);
        AssertJUnit.assertEquals(cs.getIlluminance(), VALUE_ILLUMINANCE);
    }
    
    @Test
    public void deviceTypeIsColorSensor() {
        ColorSensor cs = new ColorSensor(PORT, protocol);
        AssertJUnit.assertEquals(cs.getDeviceType(), DeviceType.COLOR_SENSOR);
    }
}

