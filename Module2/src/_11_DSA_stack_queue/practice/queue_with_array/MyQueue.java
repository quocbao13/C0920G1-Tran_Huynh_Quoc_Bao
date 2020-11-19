package _11_DSA_stack_queue.practice.queue_with_array;

import java.util.Arrays;

public class MyQueue {
    private int capacity;
    private int queueArr[];
    private int head = 0;
    private int tail = -1;
    private int currentSize = 0;

    public MyQueue(int queueSize) {
        this.capacity = queueSize;
        queueArr = new int[this.capacity];
    }

    public boolean isQueueFull(){
        boolean status = false;
        if (currentSize == capacity){
            status = true;
        }
        return status;
    }

    public boolean isQueueEmpty(){
        boolean status = false;
        if (currentSize == 0){
            status = true;
        }
        return status;
    }

    // Vì enqueue thì sẽ thêm 1 người xếp vào cuối hàng đợi, nên mỗi lần thêm cuối thì tail tăng +1 đơn vị
    public void enqueue(int item) {
        if (isQueueFull()) {
            System.out.println("Overflow ! Unable to add element: " + item);
        } else {
            tail++;
//            if (tail == capacity - 1) {
//                tail = 0;
//                System.out.println("if");
//            }
            queueArr[tail] = item;
            currentSize++;
            System.out.println("Element " + item + " is pushed to Queue !");
        }
    }


    // Vì dequeue sẽ có người sẽ rút ở đầu hàng đợi, nên mỗi lần người đó đi ra thì head tăng +1 đơn vị
    public void dequeue() {
        if (isQueueEmpty()) {
            System.out.println("Underflow ! Unable to remove element from Queue");
        } else {
            head++;
//            if (head == capacity - 1) {
//                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
//                head = 0;
            if (head > tail) {
                // Nếu head > tail tức là hàng đợi không còn người xếp hàng nữa
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
                head = 0;
                tail = -1;
            } else {
                // Ngược lại, head <= tail thì vẫn còn người ở hàng đợi
                System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
            }
            currentSize--;
        }
    }


    public void displayQueue() {
        System.out.println(Arrays.toString(queueArr));
    }
}
