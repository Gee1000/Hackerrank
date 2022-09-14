import java.util.Scanner;
import java.util.Stack;

/* 
 * Author : HackerRank
 * Date : 12 August 2022
 * Problem : Two brackets are considered to be a matched pair if the opening bracket (i.e., (, [, or {) 
 * 			 occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three 
 * 			 types of matched pairs of brackets: [], {}, and ().
 */

public class Balance {

	public static String isBalanced(String s) {
		Stack<String> stack = new Stack<>();
        if (s.length()%2 != 0) return "NO";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') stack.push(s.substring(i,i+1));
            else if (s.charAt(i) == '}') {
                if(stack.empty() || !stack.pop().equals("{")) return "NO";
            } else if (s.charAt(i) == ']') {
                if(stack.empty() || !stack.pop().equals("[")) return "NO";
            } else if (s.charAt(i) == ')') {
                if(stack.empty() || !stack.pop().equals("(")) return "NO";
            } else {
                return "NO";
            }
        }
        return stack.empty() ? "YES" : "NO";
	}

	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String brackets = input.nextLine();
		System.out.printf("isBalanced: %s", isBalanced(brackets));
		input.close();
	}
}
