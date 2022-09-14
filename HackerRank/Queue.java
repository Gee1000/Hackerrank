import java.util.Scanner;
import java.util.Stack;

/* 
 * Author : HackerRank
 * Date : 12 August 2022
 * Problem : In this challenge, you must first implement a queue using two stacks. Then process queries, where each query is one of the following 3 types:
 * 			 1 x: Enqueue element x into the end of the queue.
 * 			 2: Dequeue the element at the front of the queue.
 *           3: Print the element at the front of the queue.
 */


public class Queue {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        int x = -1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        while (q > 0) {
            int t = input.nextInt();
            switch (t) {
                case 1: x = input.nextInt();
                        stack1.push(x);
                        break;
                case 2: if (stack2.empty()) {
                            while(!stack1.empty()) stack2.push(stack1.pop());
                        }
                        stack2.pop();
                        break;
                case 3: if (stack2.empty()) {
                            while(!stack1.empty()) stack2.push(stack1.pop());
                        }
                        System.out.println(stack2.peek());
                        break;
            }
            q--;
        }
        input.close();

	}

}
