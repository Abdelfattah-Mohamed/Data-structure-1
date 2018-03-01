package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

/**
 * @author Abdelftah
 */

import java.awt.Point;

import org.junit.Assert;
import org.junit.Test;


import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class MyJUnitTest {

    @Test
    public void iceHockeyTest() {
        IPlayersFinder playersFinder = new Icehocky ();
        String[] image = {
                "3333333333333333333333333333333333333333", 
                };
        		
        Point[] answer = 
            new Point[]{
                new Point(1, 40),
               // new Point(8, 15),
               // new Point(8, 24),
            };
        int team = 3;
        int threashold = 16;
        Assert.assertArrayEquals(answer, playersFinder.findPlayers(image, team, threashold));
    }
}
