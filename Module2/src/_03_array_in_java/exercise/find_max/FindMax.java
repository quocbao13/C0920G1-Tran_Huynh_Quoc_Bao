package _03_array_in_java.exercise.find_max;

import java.util.Arrays;
import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {

        int lengthArrX;
        int lengthArrY;
        int[][] arr;
        int maxArr = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter in size Width: ");
            lengthArrX = Integer.valueOf(scanner.nextLine());
            if (lengthArrX > 20){
                System.out.println("Size does not exceed 20");
            }
        }while (lengthArrX > 20);

        do {
            System.out.println("Enter in size Height: ");
            lengthArrY = Integer.valueOf(scanner.nextLine());
            if (lengthArrY > 20){
                System.out.println("Size does not exceed 20");
            }
        }while (lengthArrY > 20);

        arr = new int[lengthArrX][lengthArrY];
        int i = 0;
        int k = 0;

        while (i < arr.length) {
            k = 0;
            while (k < arr[i].length){
                System.out.print("Enter element " + (i + 1) + ":" + (k + 1) + ": ");
                arr[i][k] = Integer.valueOf(scanner.nextLine());
                k++;
            }
            i++;
        }

        System.out.printf("%-20s%s", "Elements in array: ", "");
        for (int j = 0; j < arr.length; j++) {
            for (int e = 0; e < arr[j].length; e++){
                System.out.print(arr[j][e] + "\t");
            }
        }

        for (int e = 0; e < arr.length; e++){
            for (int j = 0; j < arr[e].length; j++){
                if (maxArr < arr[e][j]){
                    maxArr = arr[e][j];
                }
            }
        }

        System.out.println("\nMax Number of array is " + maxArr);
    }
}
