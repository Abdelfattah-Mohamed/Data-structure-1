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
		/**
		 * new object.
		 */
		IPlayersFinder playersFinder = new Icehocky();
		/**
		 * image.
		 */
		String[] image = {};
		/**
		 * result.
		 */
		Point[] answer = new Point[] {};
		/**
		 * number of team.
		 */
		final int team = 1;
		/**
		 * area of player.
		 */
		final int threashold = 3;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
}
