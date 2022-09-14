/* 
 * Author : HackerRank
 * Date : 11 August 2022
 * Problem : Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. 
 * 			 Determine if the columns are also in ascending alphabetical order, top to bottom. Return YES if they are or NO if they 
 * 			 are not. 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class gridChallenge {
	
	public static String gridSortOrder(List<String> grid) {
		int i = 0;
        for(String item : grid) {
            String [] listItem = item.split("");
            Collections.sort(Arrays.asList(listItem));
            grid.set(i++, String.join("",listItem));
        }

        for (int c = 0; c < grid.get(0).length(); c++) {
            for (int r = 0; r < grid.size() - 1; r++) {
                if(grid.get(r).charAt(c) > grid.get(r+1).charAt(c)) return "NO";
            }
        }
		return "YES";
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCases = input.nextInt();
		
		while(testCases > 0) {
			List<String> grid = new ArrayList<>();
			int numberOfRows = input.nextInt();
			for(int i = 0; i < numberOfRows; i++) { grid.add(input.next().toLowerCase()); }
			System.out.print(gridSortOrder(grid));
			testCases--;
		}
		System.out.println("\nProgram terminated");
		input.close();

	}

}
