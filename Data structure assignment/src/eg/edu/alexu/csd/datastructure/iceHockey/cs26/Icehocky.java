package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

/**
 * @author Abdelftah
 */

import java.awt.Point;
import java.util.Vector;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

public class Icehocky implements IPlayersFinder {

	/**
	 * TO KNOW AREA OF PLAYERS.
	 */
	static int counter = 0;
	/**
	 * TO KNOW MAX BOUNDRY of y.
	 */
	static int maxI = 0;
	/**
	 * TO KNOW MAX BOUNDRY of x.
	 */
	static int maxJ = 0;
	/**
	 * TO KNOW MIN BOUNDRY.
	 */
	static int minI = 0;
	/**
	 * TO KNOW MIN BOUNDRY of y.
	 */
	static int minJ = 0;
	/**
	 * TO KNOW CENTER OF BOUNDRY x.
	 */
	static int center_x = 0;
	/**
	 * TO KNOW CENTER OF BOUNDRY y.
	 */
	static int center_y = 0;
	/**
	 * To BOUNDRY.
	 */
	static int bou_i = 0;
	/**
	 * TO BOUNDRY.
	 */
	static int bou_j = 0;
	/**
	 * to store points.
	 */
	static Point[] line;
	/**
	 * to know size no. of point.
	 */
	static Vector<Point> point = new Vector<Point>();

	public Point[] findPlayers(String[] photo, int team, int threshold) {
		// TODO Auto-generated method stub
		if (photo == null) {
			return null;
		}

		if ((photo.length) <= 0) {
			throw new IllegalArgumentException("Empty");
		}
		char[][] photoArray = new char[101][101];
		storePhoteIn2DimintionArray(photo, photoArray, team);
		for (int i = 0; i < (photo.length); i++) {
			for (int j = 0; j < (photo[i].length()); j++) {
				if (photoArray[i][j] == (char) (team + 48)) {
					counter = 0;
					maxI = i;
					maxJ = j;
					minI = i;
					minJ = j;
					recursion(i, j, photoArray, team, threshold);
					if (center_x >= 0 || center_y >= 0) {
						if ((counter * 4) >= threshold) {
							point.add(new Point(center_x, center_y));
						}
					}
				}
				counter = 0;
			}
		}

		line = new Point[point.size()];
		for (int i = 0; i < point.size(); i++) {
			line[i] = point.elementAt(i);
		}
		sortPoint(line, point.size());
		point.removeAllElements();
		if (point.size() >= 0) {
			return line;
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param photo
	 * @param photoArray
	 * @param team
	 */
	private void storePhoteIn2DimintionArray(String[] photo, char[][] photoArray, int team) {
		int i = 0, j = 0;
		for (i = 0; i < (photo.length); i++) {
			for (j = 0; j < (photo[i].length()); j++) {
				if (photo[i].charAt(j) == (char) (team + 48)) {
					photoArray[i][j] = (char) (team + 48);
				} else {
					photoArray[i][j] = 'b';
				}
			}
		}
		bou_i = i;
		bou_j = j;
	}

	/**
	 * 
	 * @param i
	 * @param j
	 * @param photoArray
	 * @param team
	 * @param threshold
	 */
	private void recursion(int i, int j, char[][] photoArray, int team, int threshold) {

		if (photoArray[i][j] != (char) (team + 48) || i < 0 || j < 0 || i >= bou_i || j >= bou_j) {
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
		photoArray[i][j] = 'a';
		if (j < bou_j) {
			recursion(i, j + 1, photoArray, team, threshold);
		}
		if (i < bou_i) {
			recursion(i + 1, j, photoArray, team, threshold);
		}
		if (j > 0) {
			recursion(i, j - 1, photoArray, team, threshold);
		}
		if (i > 0) {
			recursion(i - 1, j, photoArray, team, threshold);
		}
		if ((counter * 4) >= threshold) {
			center_x = (minJ + maxJ + 1);
			center_y = (minI + maxI + 1);
		}
	}

	/**
	 * 
	 * @param line
	 * @param storeCounter
	 */
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
