package eg.edu.alexu.csd.datastructure.maze.cs15_cs25_cs26;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class jUNIT {

	@Test
	void test() {
		Maze post = new Maze();
		final int[][] answer = new int[][] { { 0, 4 }, { 1, 4 }, { 2, 4 }, { 3, 4 }, { 3, 3 }, { 3, 2 }, { 3, 1 },
				{ 4, 1 }, { 4, 0 }, { 3, 0 } };
		//int[][] x = post.dfs();
		Assert.assertArrayEquals(answer, post.dfs());
	}
}
