package how_to_hash;

import java.util.Arrays;

public class HashFunction {
	
	private static String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public static void main(String[] args) {
		
		HashFunction thisFunc = new HashFunction(30); // New object of class HashFunction i.e. array with size 30
		
		System.out.println("\n\nFirst Hash Table\n\n");
		
		String[] elementsToAdd = {"1", "5", "17", "21", "26"};
		
		thisFunc.hashFunction1(elementsToAdd, theArray);
		
		displayTheHashTable();
		
		Arrays.fill(theArray,  "-1");
		
		System.out.println("\n\nSecond Hash Table\n\n");
		
		String[] newElementsToAdd = {"1", "5", "17", "21", "30"};
		
		thisFunc.hashFunction2(newElementsToAdd, theArray);
		
		displayTheHashTable();
	}
	
	// Simple hash function
	public void hashFunction1(String[] stringsForArray, String[] theArray) {

		for (int n = 0; n < stringsForArray.length; n++) {

			String newElementVal = stringsForArray[n];

			theArray[Integer.parseInt(newElementVal)] = newElementVal;

		}

	}
	
	public void hashFunction2(String[] stringsForArray, String[] theArray) {

		for (int n = 0; n < stringsForArray.length; n++) {

			String newElementVal = stringsForArray[n];

			int arrayIndex = Integer.parseInt(newElementVal) % 29;

			System.out.println("Modulus Index= " + arrayIndex + " for value " + newElementVal);

			// Cycle through the array until we find an empty space

			while (theArray[arrayIndex] != "-1") {

				++arrayIndex;

				System.out.println("Collision! Try " + arrayIndex + " Instead");

				// If we get to the end of the array go back to index 0

				arrayIndex %= arraySize;

			}

			theArray[arrayIndex] = newElementVal;

		}

	}
	
	// Method to find a key within the Hash table
	public Integer findKey(String key) {
		
		int indexHash = Integer.parseInt(key) % 29;
		
		while (theArray[indexHash] != "-1") {
			
			if (theArray[indexHash] == key) {
				
				System.out.println(key + " was found in index " + indexHash);
				
				return indexHash;
				
			}
			
			++indexHash;
			
			indexHash %= arraySize;
		}
		
		// Key not found in the table
		return null;
	}
	
	
	// Constructor: Initialise instances of class
	HashFunction(int size) {
		
		arraySize = size;	
		theArray = new String[size];	
		Arrays.fill(theArray,  "-1");
		
	}
	
	public static void displayTheHashTable() {

		int increment = 0;

		for (int m = 0; m < 3; m++) {

			increment += 10;

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				System.out.format("| %3s " + " ", n);

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				if (theArray[n].equals("-1"))
					System.out.print("|      ");

				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

		}
		
	}
}