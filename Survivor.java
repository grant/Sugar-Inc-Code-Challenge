/*
Description: 
You are in a room with a circle of 100 chairs. The chairs are numbered sequentially from 1 to 100.
At some point in time, the person in chair #1 will be asked to leave. The person in chair #2 will be skipped, and the person in chair #3 will be asked to leave. This pattern of skipping one person and asking the next to leave will keep going around the circle until there is one person left… the survivor.
Write a program to determine which chair the survivor is sitting in. Please send us the answer and your working code.
 */

import java.util.ArrayList;

public class Survivor {
	public static void main(String[] args) {
		System.out.println(getSurvivorNumber(100));
	}

	/**
	 * Returns the number chair the survivor is sitting in. Chairs are numbered sequentially starting from 1
	 * The survivor is found by starting at chair 1 and removing every other person, circling in a loop until 
	 *
	 * @param int numChairs The number of chairs in the game. Valid numbers are 1 to Integer.MAX_VALUE.
	 * @return The number chair the survivor is sitting in. (-1 if invalid number provided)
	 */	
	private static int getSurvivorNumber(int numChairs) {
		// Handle bad input
		if (numChairs < 1) {
			return -1;
		}

		// Populate chair array list
		ArrayList<Integer> chairs = new ArrayList<Integer>();
		for (int i = 0; i < numChairs; i++) {
			chairs.add(i + 1);
		}

		// Remove all but one elements
		int chairIndex = 0;
		while (chairs.size() > 1) {
			chairs.remove(chairIndex);
			chairIndex++;// Skip every other chair
			chairIndex %= chairs.size();// Loop to beginning if necessary
		}
		
		return chairs.get(0);
	}
}