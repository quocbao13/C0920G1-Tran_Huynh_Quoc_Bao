package _03_array_in_java.exercise.sum_col;

import java.util.Scanner;

public class SumCol {
    public static void main(String[] args) {
        int lengthArrX;
        int lengthArrY;
        int[][] arr;
        int maxArr = 0;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter in size Width: ");
            lengthArrY = Integer.valueOf(scanner.nextLine());
            if (lengthArrY > 20){
                System.out.println("Size does not exceed 20");
            }
        }while (lengthArrY > 20);

        do {
            System.out.println("Enter in size Height: ");
            lengthArrX = Integer.valueOf(scanner.nextLine());
            if (lengthArrX > 20){
                System.out.println("Size does not exceed 20");
            }
        }while (lengthArrX > 20);

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

        System.out.println("Have " + lengthArrY + ". Enter col to sum: ");
        int n = scanner.nextInt();
        int x = n - 1;
        int sum = 0;
        for (int j = 0; j < arr[x].length; j++){
            sum += arr[x][j];
        }
        System.out.println("Sum col " + n + " is " + sum);

    }
}
