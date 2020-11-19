package _10_dsa_danh_sach.exercise.linkedlist_;

public class MylinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(2,1);
        myLinkedList.add(2,2);
        myLinkedList.add(2,3);
        myLinkedList.add(4,1);
        myLinkedList.displayList();
        System.out.println("Element " + myLinkedList.removeFirst() + " was deleted");
        myLinkedList.displayList();
    }
}
