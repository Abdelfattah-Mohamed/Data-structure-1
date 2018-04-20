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

class Node {
	Point currentNode;
	Node prevNode;

	Node(Point cur, Node preNode) {
		currentNode = cur;
		prevNode = preNode;
	}

	Point getCurrent() {
		return currentNode;
	}

	Node getPreNode() {
		return prevNode;
	}
}

public class MazeRunner implements IMazeSolver {

	@Override
	public int[][] solveBFS(File maze) {
		try {
			char[][] mazeCh = readCharArray(maze);
			int rows = mazeCh.length;
			int cols = mazeCh[0].length;
			Point start = findStart(mazeCh);
			Point end = findEnd(mazeCh);
			boolean[][] visited = new boolean[rows][cols];
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					visited[i][j] = false;
				}
			}
			IQueue Q = new QueueLinkedList();
			IStack S = new Stack();
			Node begin = new Node(start, null);
			Q.enqueue(begin);
			S.push(begin);
			visited[start.x][start.y] = true;
			while (!Q.isEmpty()) {
				Node current = (Node) Q.dequeue();
				Point test = current.getCurrent();
				if (test.x == end.x && test.y == end.y) {
					visited[end.x][end.y] = true;
					S.push(current);
					return drawPath(S, end.x, end.y);
				} else {
					if (validPath(rows, cols, test.x + 1, test.y)) {
						if (!visited[test.x + 1][test.y] && mazeCh[test.x + 1][test.y] != '#') {
							visited[test.x + 1][test.y] = true;
							Point p = new Point(test.x + 1, test.y);
							Node cell = new Node(p, current);
							Q.enqueue(cell);
							S.push(cell);
						}
					}
					if (validPath(rows, cols, test.x, test.y + 1)) {
						if (!visited[test.x][test.y + 1] && mazeCh[test.x][test.y + 1] != '#') {
							visited[test.x][test.y + 1] = true;
							Point p = new Point(test.x, test.y + 1);
							Node cell = new Node(p, current);
							Q.enqueue(cell);
							S.push(cell);
						}
					}
					if (validPath(rows, cols, test.x - 1, test.y)) {
						if (!visited[test.x - 1][test.y] && mazeCh[test.x - 1][test.y] != '#') {
							visited[test.x - 1][test.y] = true;
							Point p = new Point(test.x - 1, test.y);
							Node cell = new Node(p, current);
							Q.enqueue(cell);
							S.push(cell);
						}
					}
					if (validPath(rows, cols, test.x, test.y - 1)) {
						if (!visited[test.x][test.y - 1] && mazeCh[test.x][test.y - 1] != '#') {
							visited[test.x][test.y - 1] = true;
							Point p = new Point(test.x, test.y - 1);
							Node cell = new Node(p, current);
							Q.enqueue(cell);
							S.push(cell);
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
			int row = mazeCh.length;
			int col = mazeCh[0].length;
			Point start;
			int si = 0;
			int sj = 0;
			boolean[][] tf = new boolean[row][col];
			start = findStart(mazeCh);
			findEnd(mazeCh);
			si = start.x;
			sj = start.y;
			IStack inI = (IStack) new Stack();
			IStack inJ = (IStack) new Stack();
			inI.push(si);
			inJ.push(sj);
			while (!inI.isEmpty() || mazeCh[si][sj] == 'E') {
				if (validPath(row, col, si + 1, sj)) {
					si++;
					tf[si][sj] = true;
					inI.push(si);
					inJ.push(sj);
				} else if (validPath(row, col, si, sj + 1)) {
					sj++;
					tf[si][sj] = true;
					inI.push(si);
					inJ.push(sj);
				} else if (validPath(row, col, si, sj - 1)) {
					sj--;
					tf[si][sj] = true;
					inI.push(si);
					inJ.push(sj);
				} else if (validPath(row, col, si - 1, sj)) {
					si--;
					tf[si][sj] = true;
					inI.push(si);
					inJ.push(sj);
				} else {
					inI.pop();
					inJ.pop();
					si = (int) inI.peek();
					sj = (int) inJ.peek();
				}
				if (mazeCh[si][sj] == 'E') {
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
			throw new RuntimeException();
		}
	}

	private char[][] readCharArray(File maze) {
		try {
			FileReader mazeFile = new FileReader(maze);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(mazeFile);
			String size = br.readLine();
			char[] sizeCh = size.toCharArray();
			StringBuilder M = new StringBuilder();
			StringBuilder N = new StringBuilder();
			boolean flag = true;
			for (int i = 0; i < sizeCh.length; i++) {
				if (flag) {
					while (sizeCh[i] != ' ') {
						M.append(sizeCh[i]);
						i++;
					}
					flag = false;
				} else {
					while (sizeCh[i] != ' ') {
						N.append(sizeCh[i]);
						i++;
						if (i == sizeCh.length) {
							break;
						}
					}
				}
			}
			int m = Integer.parseInt(M.toString());
			int n = Integer.parseInt(N.toString());
			char[][] mazeCh = new char[m][n];
			String[] mazeStr = new String[m];
			for (int i = 0; i < m; i++) {
				mazeStr[i] = br.readLine();
			}
			if (br.readLine() != null) {
				throw new RuntimeException();
			}
			mazeCh = toCharArray(mazeStr, m, n);
			return mazeCh;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	private char[][] toCharArray(String[] mazeStr, int m, int n) {
		char[][] mazeCh = new char[m][n];
		for (int i = 0; i < mazeStr.length; i++) {
			char[] temp = mazeStr[i].replaceAll("\\s", "").toCharArray();
			if (temp.length != n) {
				throw new RuntimeException();
			}
			for (int j = 0; j < temp.length; j++) {
				mazeCh[i][j] = temp[j];
			}
		}
		return mazeCh;
	}

	private Point findStart(char[][] mazeCh) {
		Point start = new Point();
		boolean flag = false;
		for (int i = 0; i < mazeCh.length; i++) {
			for (int j = 0; j < mazeCh[0].length; j++) {
				if (mazeCh[i][j] == 'S' || mazeCh[i][j] == 's') {
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

	private Point findEnd(char[][] mazeCh) {
		Point end = new Point();
		boolean flag = false;
		for (int i = 0; i < mazeCh.length; i++) {
			for (int j = 0; j < mazeCh[0].length; j++) {
				if (mazeCh[i][j] == 'E' || mazeCh[i][j] == 'e') {
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

	private boolean validPath(int rows, int cols, int row, int col) {
		return (row >= 0 && row < rows && col >= 0 && col < cols);
	}

	private int[][] drawPath(IStack S, int x, int y) {
		IStack temp = new Stack();
		Node test = (Node) S.peek();
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
