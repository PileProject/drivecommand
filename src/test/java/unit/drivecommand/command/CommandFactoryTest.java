package unit.drivecommand.command;

import com.pileproject.drivecommand.command.CommandBase;
import com.pileproject.drivecommand.command.CommandFactory;
import com.pileproject.drivecommand.model.CommandType;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.AssertJUnit.assertEquals;

public class CommandFactoryTest {
    
    @DataProvider(name = "command")
    public static Object[][] commandMakers() {
        return new Object[][] {
            {
                CommandType.SET_LED_OFF, null
            },
            {
                CommandType.GET_COLOR_ILLUMINANCE, null
            },
            {
                CommandType.SET_LED_OFF, null
            }
        };
    }
    
    @Test(dataProvider = "command")
    public void createCommand(CommandType type, HashMap<String, Object> args) {
        CommandBase cmd = CommandFactory.createCommand(type, args);
        assertEquals(cmd.getCommandType(), type);
        assertEquals(cmd.getArgs(), args);
        assertEquals(cmd.getDeviceType(), type.getDeviceType());
    }
}
