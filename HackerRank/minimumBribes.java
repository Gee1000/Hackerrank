/* 
 * Author : HackerRank
 * Date : 11 August 2022
 * Problem : It is New Year's Day and people are in line for the Wonderland rollercoaster ride. Each person wears a sticker indicating their initial position in the queue from 1 
 * 			 to n. Any person can bribe the person directly in front of them to swap positions, but they still wear their original sticker. One person can bribe at most two others.
 *			 Determine the minimum number of bribes that took place to get to a given queue order. Print the number of bribes, or, if anyone has bribed more than two people, 
 *			 print Too chaotic. 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class minimumBribes {

	public static void minBribes(List<Integer> q) {
		int bribes = 0;
		for(int i = q.size() - 1; i >= 0; i--) {
			if(q.get(i) != i+1) {
				if(q.get(i-1) == i+1) {
					bribes++;
					Collections.swap(q, i-1, i);
				}
				else if(q.get(i-2) == i+1) {
					bribes += 2;
					Collections.swap(q, i-2, i-1);
					Collections.swap(q, i-1, i);;
				}
				else {
					System.out.print("Too chaotic \n");
					return;
				}
			}
		}
		System.out.print(bribes + "\n");
	}
	
	// 8 : 1 2 5 3 7 8 6 4
	// Expected : 7
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		
		while(testCases > 0) {
			List<Integer> queue = new ArrayList<>();
			int numberOfPeople = input.nextInt();
			for(int i = 0; i < numberOfPeople; i++) { queue.add(input.nextInt()); }
			minBribes(queue);
			testCases--;
		}
		System.out.println("Program terminated");
		input.close();
	}
}
