package _02_loop_in_java.exercise.show_img;

import java.util.Scanner;

public class ShowImg {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.println("1. Print a Rectangle. ");
            System.out.println("2. Print a Triangle. ");
            System.out.println("3. Print a Isosceles Triangle. ");
            System.out.println("0. Exit. ");
            System.out.print("Enter a number: ");
            num = scanner.nextInt();
            switch (num){
                case 1:{
                    for (int i = 0; i < 3; i++){
                        for (int j = 0; j < 7; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 2:{
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j <= i; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println();
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < 5; j++){
                            if (j < (5 - 1 - i)){
                                System.out.print(" ");
                                continue;
                            }
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println();
                    for (int i = 0; i < 5; i++){
                        for (int j = 5; j > i; j--){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    System.out.println();
                    for (int i = 0; i < 5; i++){
                        for (int j = 4; j >= 0; j--){
                            if (j > (5 - 1 - i)){
                                System.out.print(" ");
                                continue;
                            }
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 3:{
                    for (int i = 0; i < 5; i++){
                        for (int j = 0; j < 5; j++){
                            if (j < (5 - 1 - i)){
                                System.out.print(" ");
                                continue;
                            }
                            System.out.print("*");
                        }
                        for (int j = 1; j <= i; j++){
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                }
                case 0:{
                    System.exit(0);
                }
            }
        }while (num != 0);
    }
}
