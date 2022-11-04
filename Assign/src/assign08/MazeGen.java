package assign08;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;

/**
 * 
 * @author Daniel Kopta
 * This program is a helper utility to generate random mazes.
 * See the assignment instructions for more details.
 *
 */
public class MazeGen {

	public static void main(String[] args) 
	{
		// Example usage:
		// Creates a 10x10 maze with about 30% walls and 5 goals
		randomMaze("assignment8_files/randomSmall.txt", 10, 0.3, 5);
	}

	/**
	 * 
	 * @param filename - name of file to output random maze to
	 * @param dimensions - size of the square maze (NxN)
	 * @param density - density of walls in the maze (0 - 1.0)
	 * 					1.0 will be all walls, 0.5 will be 50% walls
	 * @param numGoals - number of goals in the maze; must be > 0
	 *                   numGoals generally should not exceed N 
	 *                   (the square root of the maze size)
	 * 
	 * NOTE: An extremely dense maze will not display properly in the
	 * pacman tool. It is recommended that density be < 0.5
	 * 
	 */
	public static void randomMaze(String filename, int dimensions, double density, int numGoals)
	{
		if(numGoals < 1 || numGoals >= ((dimensions-2) * (dimensions-2)) 
		   || density > 1.0 || density < 0.0)
			throw new IllegalArgumentException("numGoals must be between 1 and the number of open spaces, "
					+ "and density must be between 0 - 1");
		int numWalls = 0;
		Random rand = new Random(System.currentTimeMillis());
		
		// make a starting point
		int startX = rand.nextInt(dimensions - 2) + 1;
		int startY = rand.nextInt(dimensions - 2) + 1;
		
		
		// make the goals
		HashSet<Coordinate> goals = new HashSet<Coordinate>();
		do
		{
			int goalX = rand.nextInt(dimensions - 2) + 1;
			int goalY = rand.nextInt(dimensions - 2) + 1;
			if(goalX == startX && goalY == startY)
				continue;
			goals.add(new Coordinate(goalX, goalY));
		}
		while(goals.size() != numGoals);
		
		try
		{
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			output.println(dimensions + " " + dimensions);
			for(int i=0; i < dimensions; i++)
				output.print("X");
			output.println();
			for(int i=1; i < dimensions - 1; i++)
			{
				output.print("X");
				for(int j=1; j < dimensions - 1; j++)
				{
					if(i==startX && j==startY)
					{
						output.print("S");
						continue;
					}
					if(goals.contains(new Coordinate(i, j)))
					{
						output.print("G");
						continue;
					}
					if(rand.nextDouble() < density)
					{
						numWalls++;
						output.print("X");
					}
					else
						output.print(" ");
				}
				output.println("X");
			}
			for(int i=0; i < dimensions; i++)
				output.print("X");
			output.println();
			output.close();
		}
		catch(Exception e){e.printStackTrace();}
		System.out.println("created " + dimensions + "x" + dimensions + 
				" maze with " + numWalls + " walls");
	}
	
	/**
	 * 
	 * @author Daniel Kopta
	 * Helper class for representing coordinates
	 * Needed to efficiently construct a unique set of goals
	 *
	 */
	private static class Coordinate
	{
		public int x, y;
		public Coordinate(int _x, int _y)
		{
			x = _x;
			y = _y;
		}
		
		@Override
		public boolean equals(Object o)
		{
			if(!(o instanceof Coordinate))
				return false;
			Coordinate c = (Coordinate)o;
			return x == c.x && y == c.y;
		}
		
		@Override
		public int hashCode()
		{
			// string has a nice hashcode that we can use 
			// to produce a hashcode for two ints
			return ("" + x + " " + y).hashCode();
		}
		
	}
	
}


