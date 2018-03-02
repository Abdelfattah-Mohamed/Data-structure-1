package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/** 
 * @author Abd El Fattah 
 */
public class MyJUnitTest {

	@Test
	public void iceHockeyTest() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = {};
		Point[] answer = new Point[] {};
		final int team = 1;
		final int threashold = 3;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
}
