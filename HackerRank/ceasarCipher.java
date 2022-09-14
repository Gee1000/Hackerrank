/* 
 * Author : HackerRank
 * Date : 12 August 2022
 * Problem : Julius Caesar protected his confidential information by encrypting it using a cipher. Caesar's cipher shifts each 
 * 			 letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the 
 * 			 alphabet. In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
 */

import java.util.Scanner;

public class ceasarCipher {
	
	public static String cipher(String s, int k) {
		StringBuilder sb = new StringBuilder();
        int temp = -1;
        for(int i = 0; i < s.length(); i++) {
            if(s.codePointAt(i) >= 65 && s.codePointAt(i) <= 90) {
                temp = s.codePointAt(i) + k;
                if(temp > 90) temp = temp%90 + 64;
                sb.append(Character.toString(temp));
            }
            else if(s.codePointAt(i) >= 97 && s.codePointAt(i) <= 122) {
                temp = s.codePointAt(i) + k;
                if(temp > 122) temp = temp%122 + 96;
                sb.append(Character.toString(temp));
            }
            else sb.append(s.substring(i,i+1));
        }
        return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String clearText = input.nextLine();
		int rotationFactor = input.nextInt();
		System.out.printf("The encrypted string: %s", cipher(clearText, rotationFactor));
		input.close();
	}

}
