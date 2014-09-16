package test.drivecommand.model.pile;

import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.*;
import com.pile_drive.drivecommand.model.pile.PileConstants;
import com.pile_drive.drivecommand.model.pile.PilePacketFormatter;

public class PilePacketFormatterTest {
	@Test
	public void createPacket() {
		byte port = 0;
		byte dir = 0x01;
		byte percent = 10;
		PilePacketFormatter packetFormat = new PilePacketFormatter(PileConstants.CommandTypes.MOVE);
		packetFormat.setDataByte((byte)((port << 2)|dir));
		packetFormat.setDataByte(percent);
		packetFormat.calculateChecksum();
		byte[] expected = {0x05, 0x00, 0x01, 0x0A, 0x0E};
		assertEquals(packetFormat.byteArray(), expected);
	}
}
