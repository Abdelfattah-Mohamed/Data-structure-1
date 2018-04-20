package eg.edu.alexu.csd.datastructure.maze.cs15_cs25_cs26;

import java.io.File;

import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.stack.IStack;
import eg.edu.alexu.csd.datastructure.stack.cs26.Stack;

public class Maze implements IMazeSolver {

	//تحت يمين شمال فوق
	@Override
	public int[][] solveBFS(File maze) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int[][] solveDFS(File maze) {
		// TODO Auto-generated method stub
		return null;
	}

	public int[][] dfs() {
		final String[] image = { 
				"##..S",
				"..#..",
				".##..",
				"E..#.",
				"..###" };
		int si = 0;
		int sj = 0;
		boolean[][] tf = new boolean[image.length][image[0].length()];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (image[i].charAt(j) == 'S') {
					si = i;
					sj = j;
					break;
				}
			}
		}
		IStack inI = (IStack) new Stack();
		IStack inJ = (IStack) new Stack();
		inI.push(si);
		inJ.push(sj);
		for (int i = 0;  !inI.isEmpty(); i++) {
			if (si < 4 && (image[si + 1].charAt(sj) == '.' || image[si + 1].charAt(sj) == 'E') && !tf[si + 1][sj]) {
				si++;
				tf[si][sj] = true;
				inI.push(si);
				inJ.push(sj);
			} else if (sj < 4 && (image[si].charAt(sj + 1) == '.' || image[si].charAt(sj + 1) == 'E')
					&& !tf[si][sj + 1]) {
				sj++;
				tf[si][sj] = true;
				inI.push(si);
				inJ.push(sj);
			} else if (sj > 0 && (image[si].charAt(sj - 1) == '.' || image[si].charAt(sj - 1) == 'E')
					&& !tf[si][sj - 1]) {
				sj--;
				tf[si][sj] = true;
				inI.push(si);
				inJ.push(sj);
			} else if (si > 0 && (image[si - 1].charAt(sj) == '.' || image[si - 1].charAt(sj) == 'E')
					&& !tf[si - 1][sj]) {
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
			if(inI.isEmpty()) {
				return null;
			}
			if (image[si].charAt(sj) == 'E') {
				break;
			}
		}
		int[][] ret = new int[inI.size()][2];
		for (int i = inI.size() - 1; i >= 0; i--) {
			ret[i][0] = (int) inI.pop();
			ret[i][1] = (int) inJ.pop();
		}
		return ret;
	}
}
