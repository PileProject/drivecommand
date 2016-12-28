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
package unit.drivecommand.model.pile;

import com.pileproject.drivecommand.model.pile.PileConstants;
import com.pileproject.drivecommand.model.pile.PilePacketFormatter;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PilePacketFormatterTest {
    @Test
    public void createPacket() {
        byte port = 0;
        byte dir = 0x01;
        byte percent = 10;

        PilePacketFormatter packetFormat = new PilePacketFormatter(PileConstants.CommandTypes.MOVE);

        assertEquals(false, packetFormat.isFixed());
        assertEquals(false, packetFormat.isValid());


        packetFormat.setDataByte((byte) ((port << 2) | dir));

        assertEquals(false, packetFormat.isFixed());
        assertEquals(false, packetFormat.isValid());


        packetFormat.setDataByte(percent);

        assertEquals(false, packetFormat.isFixed());
        assertEquals(false, packetFormat.isValid());


        packetFormat.calculateChecksum();

        assertEquals(true, packetFormat.isFixed());
        assertEquals(true, packetFormat.isValid());


        byte[] expected = {0x05, 0x00, 0x01, 0x0A, 0x0E};
        assertEquals(expected, packetFormat.byteArray());
    }

    @Test
    public void receivePacket() {
        byte[] good = {0x05, 0x00, 0x01, 0x0A, 0x0E};
        byte[] expectedData = {0x01, 0x0A};

        PilePacketFormatter goodPacket = new PilePacketFormatter(good);

        assertEquals(true, goodPacket.isFixed());
        assertEquals(true, goodPacket.isValid());
        assertEquals(expectedData, goodPacket.data());
        assertEquals(good, goodPacket.byteArray());

        
        byte[] bad = {0x05, 0x00, 0x00, 0x0A, 0x0E};
        PilePacketFormatter badPacket = new PilePacketFormatter(bad);

        assertEquals(true, badPacket.isFixed());
        assertEquals(false, badPacket.isValid());
        assertEquals(null, badPacket.data());
        assertEquals(null, badPacket.byteArray());
    }
}
