package _11_DSA_stack_queue.exercise.palindrome_with_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

    public boolean test(String str) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.add( str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (stack.pop() == (queue.poll())) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.test("toi la ban nb al iot"));
    }
}
