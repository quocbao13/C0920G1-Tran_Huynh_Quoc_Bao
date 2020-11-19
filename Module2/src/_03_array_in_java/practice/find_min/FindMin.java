package _03_array_in_java.practice.find_min;

public class FindMin {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
    public static int minValue(int[] array){
        int index = 0;
        int minX = array[0];
        for (int i = 1; i < array.length; i++){
            if (minX > array[i]){
                minX = array[i];
                index = i;
            }
        }
        return index;
    }
}
