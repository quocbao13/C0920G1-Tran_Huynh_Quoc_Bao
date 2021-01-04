package luyen_tap_1.Views;

import luyen_tap_1.Libs.NumberN;
import luyen_tap_1.Libs.SynchronizedClass;

import java.util.List;
import java.util.Scanner;

public class NumberNTest {
    public static void main(String[] args) {
        int[] listN;
        listN = InputList();
        ShowList(listN);
        int countN = CountN(listN);
        System.out.println("");
        System.out.println("Có " + countN + " số chia hết cho 5 mà không chia hết cho 6");
        int countOdd = CountOdd(listN);
        System.out.println("Có " + countOdd + " số trong mảng là số lẻ");
        int countBiggerAvg = CountBiggerAVG(listN);
        System.out.println("Có " + countBiggerAvg + " số trong mảng lớn hơn số trung bình");
        int[] listC;
        listC = ListOdd(listN);
        System.out.print("Các phần tử trong mảng c(Chứa số lẻ) là: ");
        for (int value : listC){
            System.out.print(value + ", ");
        }
        System.out.println("");
        ShowLoopNumber(listN);
    }

    public static int[] InputList() {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Nhập độ dài của mảng");
        n = scanner.nextInt();
        scanner.nextLine();

        int[] ListN = new int[n];
        int i = 0;
        while (i < ListN.length){
            System.out.print("Nhâp phần tử " + (i + 1) + ": ");
            ListN[i] = Integer.parseInt(scanner.nextLine());
            i++;
        }
        return ListN;
    }

    public static void ShowList(int [] ListN) {
        System.out.printf("%-20s%s", "Các phần tử của mảng: ", "");
        for (int value : ListN) {
            System.out.print(value + "\t");
        }
    }

    public static int CountN(int [] ListN) {
        int count = 0;
        for (int value : ListN) {
            if (value % 5 == 0 && value % 6 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int CountOdd(int [] listN) {
        int count = 0;
        for (int value : listN) {
            if (value % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int CountBiggerAVG(int [] listN) {
        int sum = 0;
        int count = 0;
        for (int value : listN) {
            sum += value;
        }
        double avg = sum / listN.length;
        for (int value : listN) {
            if (value >= avg) {
                count++;
            }
        }
        System.out.println("Số trung binh của mảng là: " + avg);
        return count;
    }

    public static int[] ListOdd(int [] listN) {
        int count = 0;
        for (int value : listN) {
            if (value % 2 != 0){
                count++;
            }
        }
        int[] listC = new int[count];
        int i = 0;
        for (int value : listN) {
            if (value % 2 != 0){
                listC[i] = value;
                i++;
            }
        }
        return listC;
    }

    public static void ShowLoopNumber(int[] listN) {
        int count;
        System.out.println("Các số được lặp lại là: ");
        for (int i = 0; i < listN.length; i++){
            count = 0;
            for (int y = 0; y < listN.length; y++) {
                if (listN[i] == listN[y]){
                    count++;
                }
            }
            if (count >= 2){
                System.out.println(listN[i] + " có " + count + " lần lặp");
            }
        }
    }
}
