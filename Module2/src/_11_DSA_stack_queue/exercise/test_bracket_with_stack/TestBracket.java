package _11_DSA_stack_queue.exercise.test_bracket_with_stack;

import java.util.Arrays;
import java.util.Stack;

public class TestBracket {
    public static void main(String[] args) {
        String myStr1 = "()()(())()(())(())";
        String myStr2 = "s * (s – a) * s – b) * (s – c) ";
        char left = '(';
        char right = ')';

        Stack<Character> bStack = new Stack<>();

        String[] myArr = myStr1.split("");
        System.out.println(Arrays.toString(myArr));
        boolean check = false;
        for (int i = 0; i < myArr.length; i++){
            if (left == myArr[i].charAt(0)){
                bStack.push(left);
            }else if (right == myArr[i].charAt(0)){
                if (bStack.size() == 0){
                    System.out.println("False");
                    check = false;
                    break;
                }
                bStack.pop();
                check = true;
            }
        }

        if (check && bStack.size() == 0) {
            System.out.println(true);
        } else if (check){
            System.out.println(false);
        }




    }
}
