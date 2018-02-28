package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class Icehocky implements IPlayersFinder {

	/**
	 * TO KNOW AREA OF PLAYERS.
	 */
	int counter = 0;
	/**
	 * TO KNOW MAX BOUNDRY.
	 */
	int maxI = 0, maxJ = 0;
	/**
	 * TO KNOW MIN BOUNDRY.
	 */
	int minI = 0, minJ = 0;
	/**
	 * TO KNOW CENTER OF BOUNDRY.
	 */
	int center_x = 0, center_y = 0;
	int bou_i = 0;
	int bou_j = 0;

	@SuppressWarnings("null")
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		int[][] photoArray = null;
		int storeCounter = 0;
		Point[] line = new Point[50];
		for (int i = 0; i < line.length; i++) {
			line[i] = new Point();
		}
		storePhoteIn2DimintionArray(photo, photoArray, team);
		for (int i = 0; i < (photo.length); i++) {
			for (int j = 0; j < (photo[i].length()); j++) {
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
		sortPoint(line, storeCounter);
		if (storeCounter != 0) {
			return line;
		}
		return null;
	}

	private void storePhoteIn2DimintionArray(String[] photo, int[][] photoArray, int team) {
		int i = 0, j = 0;
		for (i = 0; i < (photo.length); i++) {
			for (j = 0; j < (photo[i].length()); j++) {
				if (photo[i].charAt(j) == team) {
					photoArray[i][j] = team;
				}
			}
		}

		bou_i = i;
		bou_j = j;
	}

	private void recursion(int i, int j, int[][] photoArray, int team, int threshold) {
		if (photoArray[i][j] != team || i < 0 || j < 0 || i >= bou_i || j >= bou_j) {
			return;
		}
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
		counter++;
		photoArray[i][j] = (team - 1);
		recursion(i, j + 1, photoArray, team, threshold);
		recursion(i, j - 1, photoArray, team, threshold);
		recursion(i + 1, j, photoArray, team, threshold);
		recursion(i - 1, j, photoArray, team, threshold);
		if (counter * 4 >= threshold) {
			center_x = (minI + maxI + 1);
			center_y = (minJ + maxJ + 1);
		}
	}

	private void sortPoint(Point[] line, int storeCounter) {
		// TODO Auto-generated method stub
		Point temp;
		for (int i = 0; i < storeCounter - 1; i++) {
			for (int j = i + 1; j < storeCounter; j++) {
				if (line[i].x > line[j].x) {
					// swap.
					temp = line[i];
					line[i] = line[j];
					line[j] = temp;
				} else if (line[i].x == line[j].x) {
					if (line[i].y > line[j].y) {
						// swap
						temp = line[i];
						line[i] = line[j];
						line[j] = temp;

					}
				}
			}
		}
	}
}
