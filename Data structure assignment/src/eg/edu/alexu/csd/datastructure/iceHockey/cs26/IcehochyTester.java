package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import org.junit.jupiter.api.Test;

import java.awt.Point;

import org.junit.Assert;
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

class IcehochyTester {

	@Test
	void test() {
		IPlayersFinder playersFinder = new Icehocky();
        String[] image = {
                "33JUBU33", 
                "3U3O4433", 
                "O33P44NB", 
                "PO3NSDP3", 
                "VNDSD333", 
                "OINFD33X"};
        Point[] answer = 
            new Point[]{
                new Point(4, 5),
                new Point(13, 9),
                new Point(14, 2),
            };
        int team = 3;
        int threashold = 16;
        Assert.assertArrayEquals(answer, playersFinder.findPlayers(image, team, threashold));
	}

}
