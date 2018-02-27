package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class Icehocky implements IPlayersFinder {

	int counter = 0;
	int maxI = 0, maxJ = 0;
	int minI = 0, minJ = 0;
	int center_x = 0, center_y = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("null")
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		int photoArray[][] = null;
		int storeCounter = 0;
		Point[] line = new Point[50];
		for (int i = 0; i < line.length; i++) {
			line[i] = new Point();
		}
		storePhoteIn2DimintionArray(photo, photoArray, team);
		for (int i = 0; i < (photo.length); i++) {
			for (int j = 0; photo[i].charAt(j) != '\0'; j++) {
				if (photoArray[i][j] == team) {
					counter = 1;
					maxI = i;
					maxJ = j;
					minI = i;
					minJ = j;
					recursion(i, j, photoArray, team, threshold);
					line[storeCounter].x = center_x;
					line[storeCounter].y = center_y;
					storeCounter++;
				}
				counter = 0;
			}
		}
		if (storeCounter != 0) {
			return line;
		}
		return null;
	}

	private void storePhoteIn2DimintionArray(String[] photo, int[][] photoArray, int team) {
		int i, j;
		for (i = 0; i < (photo.length); i++) {
			for (j = 0; photo[i].charAt(j) != '\0'; j++) {
				if (photo[i].charAt(j) == team) {
					photoArray[i][j] = photo[i].charAt(j);
				} else {
					photoArray[i][j] = 0;
				}
			}
		}
	}

	private void recursion(int i, int j, int[][] photoArray, int team, int threshold) {
		if (i > maxI) {
			maxI = i;
		}
		if (i < minI) {
			minI = i;
		}
		if (j > maxJ) {
			maxJ = j;
		}
		if (j < minJ) {
			minJ = j;
		}
		if (photoArray[i][j + 1] == team) {
			counter++;
			photoArray[i][j + 1] = team - 1;
			recursion(i, j + 1, photoArray, team, threshold);
		}
		if (photoArray[i + 1][j] == team) {
			counter++;
			photoArray[i + 1][j] = team - 1;
			recursion(i + 1, j, photoArray, team, threshold);
		}
		if (photoArray[i][j - 1] == team) {
			counter++;
			photoArray[i][j - 1] = team - 1;
			recursion(i, j - 1, photoArray, team, threshold);
		}
		if (photoArray[i - 1][j] == team) {
			counter++;
			photoArray[i - 1][j] = team - 1;
			recursion(i - 1, j, photoArray, team, threshold);
		}
		if (counter * 4 >= threshold) {
			center_x = (minI + maxI + 1);
			center_y = (minJ + maxJ + 1);
		}
		return;
	}

}
