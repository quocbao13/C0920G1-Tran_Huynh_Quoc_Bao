package _11_DSA_stack_queue.practice.queue_with_array;

public class QueueClient {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
        queue.displayQueue();

        queue.dequeue();
        queue.enqueue(435);

        queue.displayQueue();
    }
}
