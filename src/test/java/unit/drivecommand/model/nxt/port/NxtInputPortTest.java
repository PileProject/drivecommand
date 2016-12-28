/**
 * Copyright (C) 2011-2016 The DriveCommand Authors <pile-dev@googlegroups.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package unit.drivecommand.model.nxt.port;

import com.pileproject.drivecommand.model.nxt.port.NxtInputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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