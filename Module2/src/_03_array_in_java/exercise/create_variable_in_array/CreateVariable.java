package _03_array_in_java.exercise.create_variable_in_array;

import java.util.Arrays;
import java.util.Scanner;

public class CreateVariable {
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
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + "\t");
        }

        System.out.print("\n.Enter a number X:");
        int x = Integer.valueOf(scanner.nextLine());
        System.out.print("\n.Enter a number index:");
        int indexX = Integer.valueOf(scanner.nextLine());
        int[] arr2 = new int[arr.length+1];
        for (int j = arr.length; j >= 0; j--) {
            if (j > indexX){
                arr2[j] = arr[j-1];
            }else if (j == indexX) {
                arr2[indexX] = x;
            }else {
                arr2[j] = arr[j];
            }
        }
        System.out.println(Arrays.toString(arr2));
    }
}
