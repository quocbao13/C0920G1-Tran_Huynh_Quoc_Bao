package _03_array_in_java.exercise.delete_variable_in_array;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteVariable {
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

        System.out.println("\n.Enter a number X. If have");
        int x = Integer.valueOf(scanner.nextLine());
        int[] arr2 = new int[arr.length-1];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == x){

                System.out.println("Variable " + x + " in index " + j);
                System.out.println("Are you sure to delete " + x + "\n1. Yes\n2. No");
                int choose = Integer.valueOf(scanner.nextLine());
                if (choose == 1){
                    for (int z = 0; z < j; z++){
                        arr2[z] = arr[z];
                    }
                    for (int k = j; k < arr.length-1; k++){
                        arr2[k] = arr[k + 1];
                    }
                }else {
                    continue;
                }
            }
        }
        System.out.println(Arrays.toString(arr2));



    }

}
