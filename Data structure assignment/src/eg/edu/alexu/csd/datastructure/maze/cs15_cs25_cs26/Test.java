package eg.edu.alexu.csd.datastructure.maze.cs15_cs25_cs26;

import java.io.File;
import java.io.IOException;


public class Test {

	public static void main(String[] args) throws IOException {

		File f = new File("D:\\Uinversity\\#5 data structure\\#6 Labs\\test.txt");
		MazeRunner m = new MazeRunner();
		int[][] r = m.solveDFS(f);
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i][0] + " " + r[i][1]);
		}
	}

}