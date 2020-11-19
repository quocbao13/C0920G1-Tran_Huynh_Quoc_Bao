package _03_array_in_java.exercise.find_min;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        int lengthArr;
        int[] arr;
        int indexMin ;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Enter in size: ");
            lengthArr = Integer.valueOf(scanner.nextLine());
            if (lengthArr > 20){
                System.out.println("Size does not exceed 20");
            }
        }while (lengthArr > 20);
        arr = new int[lengthArr];
        int i = 0;
        while (i < arr.length) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = Integer.valueOf(scanner.nextLine());
            i++;
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }
        indexMin = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[indexMin]);
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
