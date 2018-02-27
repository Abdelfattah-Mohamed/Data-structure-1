package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class Icehocky implements IPlayersFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		char photoArray[][] = null;
		storePhoteIn2DimintionArray(photo, photoArray, team);

		return null;
	}

	private void storePhoteIn2DimintionArray(String[] photo, char photoArray[][], int team) {
		int i, j;
		for (i = 0; i < (photo.length); i++) {
			for (j = 0; photo[i].charAt(j) != '\0'; j++) {
				if (photo[i].charAt(j) == team) {
					photoArray[i][j] = photo[i].charAt(j);
				} else {
					photoArray[i][j] = '0';
				}
			}
		}
	}

	private int recursion(int i, int j, int arr[][]) {
		final int counter = 0;

		return counter;
	}

}
