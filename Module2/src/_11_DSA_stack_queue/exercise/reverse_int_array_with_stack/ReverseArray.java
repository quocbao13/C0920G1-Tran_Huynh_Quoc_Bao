package _11_DSA_stack_queue.exercise.reverse_int_array_with_stack;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class ReverseArray<R> {
    private LinkedList<R> reverseArray;

    ReverseArray() {
        reverseArray = new LinkedList<>();
    }

    public void push(R element) {
        reverseArray.addFirst(element);
    }

    public R pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return reverseArray.removeFirst();
    }

    public boolean isEmpty() {
        if (reverseArray.size() == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return reverseArray.size();
    }

    public void display() {
        for (int i = 0; i < reverseArray.size(); i++) {
            System.out.println(reverseArray.get(i));
        }
    }
}
