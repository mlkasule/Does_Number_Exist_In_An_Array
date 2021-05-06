
/**
 * Write a recursive boolean method named isMember. The method should accept two arguments: an int array and an int value. The method should return true if the value is found in the array, or false if the value is not found in the array.
 * Demonstrate the method in a program that takes input from the user. First, the program should prompt the user to enter the length of the array. Then, it should prompt the user for every member of the array. Then, it should ask the user for a number to search for in the array, and print whether the number is a member of the array (either "true" or "false").
 * Sample Run
 * ﻿java Member
 * Enter·size·of·array:4↵
* Enter·number·for·array·index·0:7↵
* Enter·number·for·array·index·1:9↵
* Enter·number·for·array·index·2:10↵
* Enter·number·for·array·index·3:15↵
* Enter·number·to·search·for·in·array:10↵
* true↵
 */

import java.util.Scanner;

public class Member {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter size of the array: ");
		int size = input.nextInt();

		// create an array with size;
		int[] array = new int[size];

		// loop through
		for (int i = 0; i < array.length; i++) {

			// ask for number
			System.out.print("Enter number for array index " + i + ": ");
			// assign input to array at i
			array[i] = input.nextInt();
		}

		// search key with isMember
		System.out.print("Enter number to search for in array: ");
		int key = input.nextInt();

		int firstIndex = 0;
		int lastIndex = (size - 1);

		// check existence
		// System.out.println(isMember(array, firstIndex, lastIndex, key));

		if (isMember(array, firstIndex, lastIndex, key))
			System.out.println(true);
		else
			System.out.println(false);

	}

	/**
	 * Methods checks whether key exists or no using binary search
	 * 
	 * @param arr
	 * @param value
	 * @param index
	 * @return true or false
	 */
	public static boolean isMember(int[] arr, int firstIndex, int lastIndex, int value) {

		int middleIndex = (firstIndex + lastIndex) / 2;

		if (firstIndex > lastIndex)
			return false;
		if (arr[middleIndex] == value) // target value at middle to be the key
			return true;
		else if (arr[middleIndex] < value)
			return isMember(arr, middleIndex + 1, lastIndex, value); // firstIndex = middleIndex + 1
		else
			return isMember(arr, firstIndex, middleIndex - 1, value); // lastIndex = middleIndex - 1
	}

}
