package _11_DSA_stack_queue.exercise.reverse_int_array_with_stack;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseArrayTest {
    public static void main(String[] args) {
        Stack<Integer> reverseArray = new Stack<>();
        LinkedList<Integer> myArray = new LinkedList<Integer>();
        //thêm giá trị vào linkedlist
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(4);
        myArray.add(5);

        System.out.println(myArray);
        //chuyền giá trị vào stack
        for (Integer in: myArray) {
            reverseArray.push(in);
        }

//        reverseArray.display();

//        System.out.println("Size is: " + reverseArray.size());

        //đẩy giá trị ra stack và truyền vào lại linkedlist
        for (int i = 0; i < myArray.size(); i++){
            myArray.set(i, reverseArray.pop());
        }

        System.out.println(myArray);


    }


}
