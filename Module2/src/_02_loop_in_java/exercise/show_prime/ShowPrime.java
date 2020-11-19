package _02_loop_in_java.exercise.show_prime;

import java.util.Scanner;

public class ShowPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numbers, count;
        System.out.println("Enter a number:");
        numbers = Integer.valueOf(scanner.nextLine());
        count = 0;
        int N = 2;
        boolean check = false;
        while (count < numbers) {
            for (int i = 2; i <= Math.sqrt(N); i++){
                check = false;
                if (N % i == 0){
                    check = true;
                    break;
                }
            }
            if (!check){
                System.out.println((count+1) + ". " + N + " is prime");
                count++;
            }
            N++;
        }
    }
}
