package _11_DSA_stack_queue.exercise.decimal_to_binary;

import java.util.ArrayList;
import java.util.Stack;

public class DecimalToBanary {
    public static void main(String[] args) {

        Stack<Integer> myStack = new Stack<>();

        int numDecimal = 1022;
        int count = 0;
        count = getCount(myStack, numDecimal, count);

        ArrayList<Integer> myArr = new ArrayList<>();
        for (int i = 0; i < count; i++){
            myArr.add(myStack.pop());
        }
        System.out.println(myArr);
    }

    private static int getCount(Stack<Integer> myStack, int numDecimal, int count) {
        while (numDecimal > 0){
            int n = numDecimal/2;
            Integer x = numDecimal % 2;
            numDecimal = n;

            myStack.push(x);
            count++;
        }
        return count;
    }
}
