package _10_dsa_danh_sach.exercise.arraylist_;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    MyList(int capacity) {
        this.size = capacity;

    }

    public void add(int index, E element){
        ensureCapacity();
        for (int i = size - 1; i >= index; i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        for (int i = index; i < elements.length; i++){
            elements[i] = elements[i + 1];
        }
        size--;
        return (E) elements;
    }

    public int size() {
        return elements.length;
    }

    public E clone(){
        return (E) elements;
    }

    public boolean contains (E o) {
        boolean isContains = false;
        for (int i = 0; i < elements.length; i++){
            if (elements[i] == o){
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    public int indexOf(E o){
        int index = 0;
        for (int i = 0; i < elements.length; i++){
            if (elements[i] == o){
                index = i;
            }
        }
        return index;
    }

    public boolean add(E e){

        return true;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newData, 0, size);
            elements = newData;
        }
    }

    public E get(int i){
        return (E) elements[i];
    }

    public void clear(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void showMyList(){
        for (int i = 0; i < size; i++){
            System.out.println(elements[i]);
        }
    }

}
