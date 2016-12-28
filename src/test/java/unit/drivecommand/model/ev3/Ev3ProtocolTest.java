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
package unit.drivecommand.model.ev3;

import com.pileproject.drivecommand.model.ProtocolBase;
import com.pileproject.drivecommand.model.com.ICommunicator;
import com.pileproject.drivecommand.model.ev3.Ev3Protocol;

import org.testng.annotations.Test;

import mockit.Expectations;
import mockit.Mocked;

public class Ev3ProtocolTest {
    @Mocked
    private ICommunicator communicator;

    // TODO: add negative version of tests

    @Test
    public void openSuccessfully() throws Exception {
        new Expectations() {{
            communicator.open();
        }};
        ProtocolBase protocol = new Ev3Protocol(communicator);
        protocol.open();
    }

    @Test
    public void closeSuccessfully() throws Exception {
        new Expectations() {{
            communicator.close();
        }};
        ProtocolBase protocol = new Ev3Protocol(communicator);
        protocol.close();
    }

    @Test
    public void execSuccessfully() throws Exception {
        // TODO: check whether each operation works properly
    }

    @Test
    public void applySuccessfully() throws Exception {
        // TODO: complete this
        new Expectations() {{
            // communicator.write(foo);
        }};
        ProtocolBase protocol = new Ev3Protocol(communicator);
        // protocol.apply();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void loadAndThrowAnException() throws Exception {
        ProtocolBase protocol = new Ev3Protocol(communicator);
         protocol.load(0);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void storeAndThrowAnException() throws Exception {
        ProtocolBase protocol = new Ev3Protocol(communicator);
        protocol.store(0, null);
    }
}
