package assign08;

/**
 * 
 * @author Daniel Kopta
 * Simple class to drive the path finding logic and solve a maze.
 */
public class PathFinder {

	/**
	 * Given an input file containing a maze,
	 * finds a path to the goal then outputs the solved maze.
	 * @param inputFile - the file containing the input maze
	 * @param outputFile1 - the file to write the solution to closest goal shortest path
	 * @param findShortest - if true, the path found is required to be the shortest path,
	 *                       if false, the path found can be any path
	 */
	public static void solveMaze(String inputFile, String outputFile, boolean findShortest)
	{
		Graph g = null;
		try {
			g = new Graph(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(findShortest)
			g.CalculateShortestPath();
		else
			g.CalculateAPath();
		
		g.printGraph(outputFile);
	}
	

}
