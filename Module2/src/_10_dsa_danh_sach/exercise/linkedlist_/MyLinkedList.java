package _10_dsa_danh_sach.exercise.linkedlist_;


public class MyLinkedList<E> {
    private Node head;
    private int numNode;

    private class Node {
        private Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }

        public Object getData(){
            return this.data;
        }
    }

    public MyLinkedList() {

    }

    public void addFirst(E e) {
        Node newNode = new Node(e); // Create a new node
        newNode.next = head; // link the new node with the head
        head = newNode; // head points to the new node
        numNode++; // Increase list size
    }

    public void addLast(E e) {
        Node newNode = new Node(e);

        if (head != null){
            Node jump = head;
            for (int i = 0; i < numNode - 1; i++) {
                jump = jump.next;
            }

            jump.next = newNode;
        } else {
            head = new Node(e);
        }
        this.numNode++;
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e); // Insert first
        } else if (index >= numNode) {
            addLast(e); // Insert last
        } else { // Insert in the middle
            Node current = head;
            for (int i = 1; i < index; i++){
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(e);
            (current.next).next = temp;
            numNode++;
        }
    }

    public void displayList() {

        Node jump = head;

        while (jump != null) {
            System.out.println(jump.data);
            jump = jump.next;
        }
    }

    public E removeFirst() {
        if (numNode == 0) return null; // Nothing to delete
        else {
            Node temp = head; // Keep the first node temporarily
            head = head.next; // Move head to point to next node
            numNode--; // Reduce size by 1
            return (E) temp.data; // Return the deleted element
        }
    }

    public E removeLast() {
        if (numNode == 0) return null; // Nothing to remove
        else if (numNode == 1) { // Only one element in the list
            Node temp = head;
            head = null; // list becomes empty
            numNode = 0;
            return (E) temp.data;
        } else {
            Node current = head;

            for (int i = 0; i < numNode - 2; i++)
                current = current.next;
            Node temp = current;
            current = null;
            return (E) temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= numNode) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == numNode - 1) return removeLast(); // Remove last
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node current = previous.next;
            previous.next = current.next;
            numNode--;
            return (E) current.data;
        }
    }
}
