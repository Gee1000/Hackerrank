/* 
 * Author : HackerRank
 * Date : 11 August 2022
 * Problem : We define super digit of an integer using the following rules:
 *  		 Given an integer, we need to find the super digit of the integer.
 *   		 - If has only digit, then its super digit is X. 
 *   		 - Otherwise, the super digit of X is equal to the super digit of the sum of the digits of X.  
 *   
 * Example : super_digit(9875)   	9+8+7+5 = 29 
			 super_digit(29) 	    2 + 9 = 11
   			 super_digit(11)		1 + 1 = 2
			 super_digit(2)			= 2  
 * The number is created by concatenating the string times so the initial
 *  superDigit(p) = superDigit(9875987598759875)
                    9+8+7+5+9+8+7+5+9+8+7+5+9+8+7+5 = 116
    superDigit(p) = superDigit(116)
                  	1+1+6 = 8
    superDigit(p) = superDigit(8)
 */

import java.util.Scanner;

public class superDigit {

	public static int SuperDigit(String n, int k) {
		String superD = String.valueOf(calculatesum(n) * k );
	    while(superD.length()> 1) {  
	        long sum = calculatesum(superD);
	        superD = String.valueOf(sum);
	    }
	    return Integer.parseInt(superD);
	}
	
	public static long calculatesum(String sb){
	    long sum = 0;
	    for(int i=0; i <sb.length(); i++) {
	        sum = sum + Character.getNumericValue(sb.charAt(i));
	    }
	    return sum;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String n = input.next(); // a string representation of an integer
		int k = input.nextInt(); // the times to concatenate n to make p
		
		System.out.println(SuperDigit(n, k));
		input.close();
	}
}
