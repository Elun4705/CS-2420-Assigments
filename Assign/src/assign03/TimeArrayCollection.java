package assign03;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class TimeArrayCollection {
	private static Random rand;
	public static void main(String[] args)
	{
		rand = new Random();
		rand.setSeed(System.currentTimeMillis());
	
		//TODO: Write code to time your toSortedList, contains, and SearchUtil.binarySearch methods so you can plot the results.
	
	}

	

	public static Integer randomInt()
	{
		return rand.nextInt();
	}

}
