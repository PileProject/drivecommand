/**
 * Copyright (C) 2011-2017 The PILE Developers <pile-dev@googlegroups.com>
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

import com.pileproject.drivecommand.model.nxt.port.NxtOutputPort;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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