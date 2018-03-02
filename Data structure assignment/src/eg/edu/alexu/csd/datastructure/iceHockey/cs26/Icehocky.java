package eg.edu.alexu.csd.datastructure.iceHockey.cs26;

import java.awt.Point;
import java.util.Vector;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;

/**
 * @author Abd El Fattah
 */
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
	static int centerX = 0;
	/**
	 * TO KNOW CENTER OF BOUNDRY y.
	 */
	static int centerY = 0;
	/**
	 * To BOUNDRY.
	 */
	static int bouI = 0;
	/**
	 * TO BOUNDRY.
	 */
	static int bouJ = 0;
	/**
	 * to store points.
	 */
	static Point[] line;
	/**
	 * to know size no. of point.
	 */
	static Vector<Point> point = new Vector<Point>();
	/**
	  * @return Returns array of points.
	  * @param photo.
	  * @param team.
	  * @throws Exception.
	  * @throws MyException.
	  */
	public Point[] findPlayers(final String[] photo,
			final int team, final int threshold) {
		// TODO Auto-generated method stub
		if (photo == null) {
			return null;
		}

		if ((photo.length) <= 0) {
			throw new IllegalArgumentException("Empty");
		}
		final int x = 101;
		char[][] photoArray = new char[x][x];
		storePhoteIn2DimintionArray(photo, photoArray, team);
		final int cell = 4;
		for (int i = 0; i < (photo.length); i++) {
			for (int j = 0; j < (photo[i].length()); j++) {
				if (photoArray[i][j] == (char) (team + '0')) {
					counter = 0;
					maxI = i;
					maxJ = j;
					minI = i;
					minJ = j;
					recursion(i, j, photoArray,
							team, threshold);
					if (centerX >= 0 || centerY >= 0) {
						if ((counter * cell)
								>= threshold) {
							point.add(new Point(
							centerX, centerY));
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
	 * @param photo
	 * @param photoArray
	 * @param team
	 */
	private void storePhoteIn2DimintionArray(final String[] photo,
			final char[][] photoArray, final int team) {
		int i = 0, j = 0;
		for (i = 0; i < (photo.length); i++) {
			for (j = 0; j < (photo[i].length()); j++) {
				if (photo[i].charAt(j) == (char) (team + '0')) {
					photoArray[i][j] = (char) (team + '0');
				} else {
					photoArray[i][j] = 'b';
				}
			}
		}
		bouI = i;
		bouJ = j;
	}

	/**
	 * @param i
	 * @param j
	 * @param photoArray
	 * @param team
	 * @param threshold
	 */
	private void recursion(final int i, final int j,
			final char[][] photoArray, final int team,
			final int threshold) {
		final int cell = 4;
		if (photoArray[i][j] != (char) (team + '0')
				|| i < 0 || j < 0 || i >= bouI
				|| j >= bouJ) {
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
		if (j < bouJ) {
			recursion(i, j + 1, photoArray, team, threshold);
		}
		if (i < bouI) {
			recursion(i + 1, j, photoArray, team, threshold);
		}
		if (j > 0) {
			recursion(i, j - 1, photoArray, team, threshold);
		}
		if (i > 0) {
			recursion(i - 1, j, photoArray, team, threshold);
		}
		if ((counter * cell)
				>= threshold) {
			centerX = (minJ + maxJ + 1);
			centerY = (minI + maxI + 1);
		}
	}

	/**
	 * @param text
	 * @param storeCounter
	 */
	private void sortPoint(final Point[] text,
			final int storeCounter) {
		// TODO Auto-generated method stub
		Point temp;
		for (int i = 0; i < storeCounter - 1; i++) {
			for (int j = i + 1; j < storeCounter; j++) {
				if (text[i].x > text[j].x) {
					// swap.
					temp = text[i];
					text[i] = text[j];
					text[j] = temp;
				} else if (text[i].x == text[j].x) {
					if (text[i].y > text[j].y) {
						// swap
						temp = line[i];
						text[i] = text[j];
						text[j] = temp;
					}
				}
			}
		}
	}
}
