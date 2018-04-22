package eg.edu.alexu.csd.datastructure.maze.cs15_cs25_cs26;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.cs15_cs25_cs26.QueueLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;
import eg.edu.alexu.csd.datastructure.stack.cs26.Stack;

/**
 * @author Abd Elfattah
 * @author super
 * @author Abd Elrahman
 */
class Node {
	/**
	 * the current cell.
	 */
	private Point currentNode;
	/**
	 * the previous cell.
	 */
	private Node prevNode;

	/**
	 * constructor for the Node.
	 *
	 * @param cur
	 *            the current cell.
	 * @param preNode
	 *            the previous Node.
	 */
	Node(final Point cur, final Node preNode) {
		currentNode = cur;
		prevNode = preNode;
	}

	/**
	 * getting the current cell.
	 *
	 * @return the current cell
	 */
	Point getCurrent() {
		return currentNode;
	}

	/**
	 * getting the previous cell.
	 *
	 * @return the previous cell
	 */
	Node getPreNode() {
		return prevNode;
	}
}

/**
 * @author Abd Elrahamn
 * @author super
 * @author Abd Elfattah
 */
public class MazeRunner implements IMazeSolver {

	@Override
	public final int[][] solveBFS(final File maze) {
		try {
			char[][] mazeCh = readCharArray(maze);
			int rows = mazeCh.length;
			int cols = mazeCh[0].length;
			Point start = findStart(mazeCh);
			Point end = findEnd(mazeCh);
			boolean[][] visited = new boolean[rows][cols];
			IQueue q = new QueueLinkedList();
			IStack s = new Stack();
			Node begin = new Node(start, null);
			q.enqueue(begin);
			s.push(begin);
			visited[start.x][start.y] = true;
			while (!q.isEmpty()) {
				Node current = (Node) q.dequeue();
				Point test = current.getCurrent();
				if (test.x == end.x && test.y == end.y) {
					visited[end.x][end.y] = true;
					s.push(current);
					return drawPath(s);
				} else {
					if (validPath(rows,
							cols,
							test.x + 1, test.y)) {
						if (!visited[test.x + 1][test.y]
					&& mazeCh[test.x + 1][test.y] != '#') {
							visited[test.x + 1]
								[test.y] = true;
							Point p
							= new Point(
							test.x + 1, test.y);
							Node cell
							= new Node(p, current);
							q.enqueue(cell);
							s.push(cell);
						}
					}
					if (validPath(
					rows, cols, test.x, test.y + 1)) {
						if (!visited[test.x][test.y + 1]
					&& mazeCh[test.x][test.y + 1] != '#') {
							visited[test.x]
							[test.y + 1] = true;
							Point p = new Point(
							test.x, test.y + 1);
							Node cell
							= new Node(p, current);
							q.enqueue(cell);
							s.push(cell);
						}
					}
					if (validPath(
					rows, cols, test.x - 1, test.y)) {
						if (!visited[test.x - 1][test.y]
					&& mazeCh[test.x - 1][test.y] != '#') {
							visited[test.x - 1]
							[test.y] = true;
							Point p = new Point(
							test.x - 1, test.y);
							Node cell
							= new Node(p, current);
							q.enqueue(cell);
							s.push(cell);
						}
					}
					if (validPath(
					rows, cols, test.x, test.y - 1)) {
						if (!visited[test.x][test.y - 1]
				&& mazeCh[test.x][test.y - 1] != '#') {
							visited[test.x]
							[test.y - 1] = true;
							Point p = new Point(
							test.x, test.y - 1);
							Node cell
							= new Node(p, current);
							q.enqueue(cell);
							s.push(cell);
						}
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return null;
	}

	@Override
	public final int[][] solveDFS(final File maze) {
		// TODO Auto-generated method stub
		try {
			char[][] mazeCh = readCharArray(maze);
			Point start, end;
			int si = 0;
			int sj = 0;
			boolean[][] tf = new boolean
					[mazeCh.length]
					[mazeCh[0].length];
			start = findStart(mazeCh);
			end = findEnd(mazeCh);
			si = start.x;
			sj = start.y;
			IStack inI = (IStack) new Stack();
			IStack inJ = (IStack) new Stack();
			inI.push(si);
			inJ.push(sj);
			tf[si][sj] = true;
			while (!inI.isEmpty()) {
				si = (int) inI.peek();
				sj = (int) inJ.peek();
				if (si != end.x || sj != end.y) {
					if (validPath(mazeCh.length,
							mazeCh[0].length,
							si + 1, sj)
							&& (!tf[si + 1][sj]
					&& mazeCh[si + 1][sj] != '#')) {
						si++;
						tf[si][sj] = true;
						inI.push(si);
						inJ.push(sj);
					} else if (validPath(mazeCh.length, mazeCh[0].length, si, sj + 1)
							&& (!tf[si][sj + 1] && mazeCh[si][sj + 1] != '#')) {
						sj++;
						tf[si][sj] = true;
						inI.push(si);
						inJ.push(sj);
					} else if (validPath(mazeCh.length, mazeCh[0].length, si - 1, sj)
							&& (!tf[si - 1][sj] && mazeCh[si - 1][sj] != '#')) {
						si--;
						tf[si][sj] = true;
						inI.push(si);
						inJ.push(sj);
					} else if (validPath(mazeCh.length, mazeCh[0].length, si, sj - 1)
							&& (!tf[si][sj - 1] && mazeCh[si][sj - 1] != '#')) {
						sj--;
						tf[si][sj] = true;
						inI.push(si);
						inJ.push(sj);
					} else {
						inI.pop();
						inJ.pop();
						if (inI.isEmpty()) {
							return null;
						}
					}
				} else {
					tf[end.x][end.y] = true;
					break;
				}
			}
			if (inI.isEmpty()) {
				return null;
			}
			int[][] ret = new int[inI.size()][2];
			for (int i = inI.size() - 1; i >= 0; i--) {
				ret[i][0] = (int) inI.pop();
				ret[i][1] = (int) inJ.pop();
			}
			return ret;
		} catch (Exception e) {
			throw new RuntimeException("null");
		}
	}

	/**
	 * reading from file.
	 *
	 * @param maze
	 *            file destination
	 * @return char 2D array
	 */
	private char[][] readCharArray(final File maze) {
		try {
			FileReader mazeFile = new FileReader(maze);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(mazeFile);
			String size = br.readLine();
			char[] sizeCh = size.toCharArray();
			StringBuilder m = new StringBuilder();
			StringBuilder n = new StringBuilder();
			boolean flag = true;
			for (int i = 0; i < sizeCh.length; i++) {
				if (flag) {
					while (sizeCh[i] != ' ') {
						m.append(sizeCh[i]);
						i++;
					}
					flag = false;
				} else {
					while (sizeCh[i] != ' ') {
						n.append(sizeCh[i]);
						i++;
						if (i == sizeCh.length) {
							break;
						}
					}
				}
			}
			int r = Integer.parseInt(m.toString());
			int c = Integer.parseInt(n.toString());
			char[][] mazeCh = new char[r][c];
			String[] mazeStr = new String[r];
			for (int i = 0; i < r; i++) {
				mazeStr[i] = br.readLine();
			}
			if (br.readLine() != null) {
				throw new RuntimeException();
			}
			mazeCh = toCharArray(mazeStr, r, c);
			return mazeCh;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	/**
	 * converting array of string to 2-D char array.
	 *
	 * @param mazeStr
	 *            array of string
	 * @param m
	 *            number of rows
	 * @param n
	 *            number of columns
	 * @return 2-D char array "maze"
	 */
	private char[][] toCharArray(
		final String[] mazeStr, final int m, final int n) {
		char[][] mazeCh = new char[m][n];
		for (int i = 0; i < mazeStr.length; i++) {
			char[] temp
			= mazeStr[i].replaceAll("\\s", "").toCharArray();
			if (temp.length != n) {
				throw new RuntimeException();
			}
			for (int j = 0; j < temp.length; j++) {
				mazeCh[i][j] = temp[j];
			}
		}
		return mazeCh;
	}

	/**
	 * finding starting point.
	 *
	 * @param mazeCh
	 *            array of char containing the maze
	 * @return the start point if the start doesn't return error
	 */
	private Point findStart(final char[][] mazeCh) {
		Point start = new Point();
		boolean flag = false;
		for (int i = 0; i < mazeCh.length; i++) {
			for (int j = 0; j < mazeCh[0].length; j++) {
				if (mazeCh[i][j] == 'S'
				|| mazeCh[i][j] == 's') {
					start.x = i;
					start.y = j;
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			throw new RuntimeException();
		} else {
			return start;
		}
	}

	/**
	 * finding ending point.
	 *
	 * @param mazeCh
	 *            array of char containing the maze
	 * @return the end point if the start doesn't return error
	 */
	private Point findEnd(final char[][] mazeCh) {
		Point end = new Point();
		boolean flag = false;
		for (int i = 0; i < mazeCh.length; i++) {
			for (int j = 0; j < mazeCh[0].length; j++) {
				if (mazeCh[i][j] == 'E'
				|| mazeCh[i][j] == 'e') {
					end.x = i;
					end.y = j;
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			throw new RuntimeException();
		} else {
			return end;
		}
	}

	/**
	 * checking boundaries.
	 *
	 * @param rows
	 *            number of rows
	 * @param cols
	 *            number of columns
	 * @param row
	 *            the current row
	 * @param col
	 *            the current column
	 * @return true if the cell is in the boundaries else false
	 */
	private boolean validPath(
	final int rows, final int cols, final int row, final int col) {
		return (row >= 0 && row < rows && col >= 0 && col < cols);
	}

	/**
	 * drawing the path we found in the maze.
	 *
	 * @param s
	 *            stack containing the points
	 * @return 2-D integer array containing the path
	 */
	private int[][] drawPath(final IStack s) {
		IStack temp = new Stack();
		Node test = (Node) s.peek();
		while (test != null) {
			temp.push(test.getCurrent());
			test = test.getPreNode();
		}
		int rows = temp.size();
		int[][] path = new int[rows][2];
		for (int i = 0; i < rows; i++) {
			Point cell = new Point();
			cell = (Point) temp.pop();
			path[i][0] = cell.x;
			path[i][1] = cell.y;
		}
		return path;
	}

}