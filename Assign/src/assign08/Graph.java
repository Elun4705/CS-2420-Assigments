package assign08;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Daniel Kopta This Graph class acts as a starting point for your maze
 *         path finder. Add to this class as needed.
 * @author Andy Huo and Emmanuel Luna
 */
public class Graph {

	// The graph itself is just a 2D array of nodes
	private Node[][] nodes;

	// The node to start the path finding from
	private Node start;

	// The size of the maze
	private int width;
	private int height;

	/**
	 * Constructs a maze graph from the given text file.
	 * 
	 * @param filename - the file containing the maze
	 * @throws Exception
	 */
	public Graph(String filename) throws Exception {
		BufferedReader input;
		input = new BufferedReader(new FileReader(filename));

		if (!input.ready()) {
			input.close();
			throw new FileNotFoundException();
		}

		// read the maze size from the file
		String[] dimensions = input.readLine().split(" ");
		height = Integer.parseInt(dimensions[0]);
		width = Integer.parseInt(dimensions[1]);

		// instantiate and populate the nodes
		nodes = new Node[height][width];
		for (int i = 0; i < height; i++) {
			String row = input.readLine().trim();

			for (int j = 0; j < row.length(); j++)
				switch (row.charAt(j)) {
				case 'X':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isWall = true;
					break;
				case ' ':
					nodes[i][j] = new Node(i, j);
					break;
				case 'S':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isStart = true;
					start = nodes[i][j];
					break;
				case 'G':
					nodes[i][j] = new Node(i, j);
					nodes[i][j].isGoal = true;
					break;
				default:
					throw new IllegalArgumentException("maze contains unknown character: \'" + row.charAt(j) + "\'");
				}
		}
		input.close();
	}

	/**
	 * Outputs this graph to the specified file. Use this method after you have
	 * found a path to one of the goals. Before using this method, for the nodes on
	 * the path, you will need to set their isOnPath value to true.
	 * 
	 * @param filename - the file to write to
	 */
	public void printGraph(String filename) {
		try {
			PrintWriter output = new PrintWriter(new FileWriter(filename));
			output.println(height + " " + width);
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					output.print(nodes[i][j]);
				}
				output.println();
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Traverse the graph with BFS (shortest path to closest goal) A side-effect of
	 * this method should be that the nodes on the path have had their isOnPath
	 * member set to true.
	 * 
	 * @return - the length of the path
	 */
	public int CalculateShortestPath() {

		// Create a queue for use in the BFS
		LinkedList<Node> queue = new LinkedList<Node>();

		int length = 0;
		start.visited = true;

		queue.offer(start);
		Node current = start;

		// If there are no neighbors, return 0.
		if (getNeighbors(current).size() == 0) {
			return 0;
		}

		// Initiate the BFS
		while (queue.isEmpty() == false) {
			current = queue.poll();

			// Check if the current node is the goal
			if (current.isGoal == true) {
				current = current.cameFrom;

				// Travel back through the path to mark each node as part of the path
				// and calculate length at the same time.
				while (current.cameFrom != null) {
					length++;
					current.isOnPath = true;
					current = current.cameFrom;
				}
				return length;
			}

			// Add the neighbors to the Queue
			for (Node n : getNeighbors(current)) {
				n.visited = true;
				n.cameFrom = current;
				queue.offer(n);
			}
		}

		return length;
	}

	/**
	 * Traverse the graph with DFS (any path to any goal) A side-effect of this
	 * method should be that the nodes on the path have had their isOnPath member
	 * set to true.
	 * 
	 * @return - the length of the path
	 */
	public int CalculateAPath() {
		int length = 0;

		Node current = start;

		// Call the recursive function
		length = DFS(current, length);

		return length;
	}

	/**
	 * The recursive function for traversing a graph with DFS
	 * 
	 * @param current - the current node being checked
	 * @param length  - how long the current path is
	 * @return the length of the path
	 */
	public int DFS(Node current, int length) {
		current.visited = true;

		// check if the current node is the goal
		if (current.isGoal) {
			while (current.cameFrom != null) {
				length++;
				current.isOnPath = true;
				current = current.cameFrom;
			}
			return length;
		}

		// Find neighbors and put them in random order access
		ArrayList<Node> neighbors = getNeighbors(current);
		Collections.shuffle(neighbors);

		// Return to a node with another path
		for (Node next : neighbors) {
			next.cameFrom = current;
			length = DFS(next, length);
			if (length > 0)
				break;
		}

		return length;
	}

	/**
	 * A helper method which returns a node's neighbors
	 * 
	 * @param n - the node being tested
	 * @return - an ArrayList of the neighbors
	 */
	public ArrayList<Node> getNeighbors(Node n) {

		ArrayList<Node> neighbors = new ArrayList<Node>();

		if (nodes[n.row + 1][n.col].isWall == false && nodes[n.row + 1][n.col].visited == false) {
			neighbors.add(nodes[n.row + 1][n.col]);
		}

		if (nodes[n.row - 1][n.col].isWall == false && nodes[n.row - 1][n.col].visited == false) {
			neighbors.add(nodes[n.row - 1][n.col]);
		}

		if (nodes[n.row][n.col + 1].isWall == false && nodes[n.row][n.col + 1].visited == false) {
			neighbors.add(nodes[n.row][n.col + 1]);
		}

		if (nodes[n.row][n.col - 1].isWall == false && nodes[n.row][n.col - 1].visited == false) {
			neighbors.add(nodes[n.row][n.col - 1]);
		}

		return neighbors;

	}

	/**
	 * @author Daniel Kopta A node class to assist in the implementation of the
	 *         graph. You will need to add additional functionality to this class.
	 */
	private static class Node {
		// The node linked to this one
		private Node cameFrom;

		// The node's position in the maze
		private int row, col;

		// Visitation Status;
		private boolean visited;

		// The type of the node
		private boolean isStart;
		private boolean isGoal;
		private boolean isOnPath;
		private boolean isWall;

		// TODO: You will undoubtedly want to add more members and functionality to this
		// class.

		public Node(int r, int c) {
			isStart = false;
			isGoal = false;
			isOnPath = false;
			row = r;
			col = c;
		}

		@Override
		public String toString() {
			if (isWall)
				return "X";
			if (isStart)
				return "S";
			if (isGoal)
				return "G";
			if (isOnPath)
				return ".";
			return " ";
		}
	}

}
