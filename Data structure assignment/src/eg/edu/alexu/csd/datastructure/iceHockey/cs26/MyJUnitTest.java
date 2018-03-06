package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author Abd El Fattah
 */
public class MyJUnitTest {
/**
 * @Test
 */
	@Test
	public void iceHockeyTest() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = {
				"33JUBU33",
                "3U3O4433",
                "O33P44NB",
                "PO3NSDP3",
                "VNDSD333",
                "OINFD33X"
		};
		Point[] answer =
			new Point[] {
				new Point('4' - '0', '5' - '0'),
                new Point('n' - 'a', '9' - '0'),
                new Point('o' - 'a', '2' - '0'),
		};
		final int team = 3;
		final int threashold = 16;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
/**
* @Test
*/
	@Test
	public void iceHockeyTest1() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = {
				"3333333333"
				+ "333333333"
				+ "3333333333"
				+ "33333333333"
				+ "3333333333",
		};
		Point[] answer =
			new Point[] {
				new Point('b' - '0', '1' - '0'),
		};
		final int team = 3;
		final int threashold = 5;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
	/**
	 * @Test
	 */
	@Test
	public void iceHockeyTest2() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = {
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
				"3",
		};
		Point[] answer =
			new Point[] {
				new Point('1' - '0', 'b' - '0'),
		};
		final int team = 3;
		final int threashold = 3;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
	/**
	 * @Test
	 */
	@Test
	public void iceHockeyTest3() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = {
				"33333333",
                "33333333",
                "33333333",
                "33333333",
                "33333333",
                "33333333",
                "33333333",
                "33333333"
		};
		Point[] answer =
			new Point[] {
				new Point('8' - '0', '8' - '0'),
		};
		final int team = 3;
		final int threashold = 12;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
	/**
	 * @Test
	 */
	@Test
	public void iceHockeyTest4() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = {
				"313r3d3c",
                "b3v3z3x3",
                "3v3d3t3y",
                "137343n3",
                "3z3c3v3b"
		};
		Point[] answer =
			new Point[] {
		};
		final int team = 3;
		final int threashold = 5;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
	/**
	 * @Test
	 */
	@Test
	public void iceHockeyTest5() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = null;
		Point[] answer = null;
		final int team = 3;
		final int threashold = 12;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
	/**
	 * @Test
	 */
	@Test
	public void iceHockeyTest6() {
		IPlayersFinder playersFinder = new Icehocky();
		String[] image = {
				"1"
		};
		Point[] answer =
			new Point[] {
				new Point('1' - '0', '1' - '0'),
		};
		final int team = 1;
		final int threashold = 3;
		Assert.assertArrayEquals(answer,
				playersFinder.findPlayers(image,
						team, threashold));
	}
	/**
	 * @Test
	 */
	@Test
	public void randomPhoto4() {
		IPlayersFinder playersFinder = new Icehocky();
		final String[] photo = {
				"44444H44S4",
				"K444K4L444",
				"4LJ44T44XH",
				"444O4VIF44",
				"44C4D4U444",
				"4V4Y4KB4M4",
				"G4W4HP4O4W",
				"4444ZDQ4S4",
				"4BR4Y4A444",
				"4G4V4T4444"};
		final int team = 4;
		final int threshold = 16;
		Point[] returnedPoints;
		returnedPoints = playersFinder.findPlayers(photo, team,
				threshold);
		final Point[] ans = {
				new Point(3, 8),
				new Point(4, 16),
				new Point(5, 4),
				new Point(16, 3),
				new Point(16, 17),
				new Point(17, 9)};
		Assert.assertArrayEquals(ans, returnedPoints);
	}
}
