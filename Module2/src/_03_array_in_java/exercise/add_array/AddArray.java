package _03_array_in_java.exercise.add_array;

import java.util.Arrays;
import java.util.Scanner;

public class AddArray {
    public static void main(String[] args) {
        int lengthArr;
        int[] arr;
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
        for (int value : arr) {
            System.out.print(value + "\t");
        }
        System.out.println("");
        int[] arr2;
        arr2 = new int[lengthArr];
        int a = 0;
        while (a < arr2.length) {
            System.out.print("Enter element " + (a + 1) + ": ");
            arr2[a] = Integer.valueOf(scanner.nextLine());
            a++;
        }
        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int value : arr2) {
            System.out.print(value + "\t");
        }
        int[] addArr = new int[arr.length + arr2.length];
        for (int z = 0; z < arr.length; z++){
            addArr[z] = arr[z];
            for (int c = (arr.length + z); c == (arr.length + z);){
                addArr[c] = arr2[z];
            }
        }
        System.out.println(Arrays.toString(addArr));


    }   
}
