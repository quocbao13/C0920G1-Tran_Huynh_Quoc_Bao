package luyen_tap_1.Libs;

import java.util.Scanner;

public class NumberN {
    public static void searchNumber(){
        int[] number = new int []{6,7,8,2,9,1,4};
        System.out.println("Nhap so bat ky:");
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        boolean check = true;
        for(int i = 0 ; i < number.length; i++){
            if(k==number[i]) {
                System.out.println("yes");
                check = false;
                break;
            }
        }
        if(check == true){
            System.out.println("no");
        }
    }
    public static void searchN(){
        int[] numberAbc = new int[] {5,7,8,2,5,3,1};
        System.out.println("Inter Number: ");
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt();
        int count = 0;
        for(int i = 0;i<numberAbc.length;i++){
            if(l==numberAbc[i]){
                count++;
            }
        }
        System.out.println("so lan xuat hien la: " +  count);

    }
    public static void searchString(){
        String[] searchStr = new String[] {"Dog","Cat","House","Car"};
        System.out.println("Inter key: ");
        Scanner scanner = new Scanner(System.in);
        String c = scanner.nextLine();
        for(int i = 0; i<searchStr.length;i++){
            if(searchStr[i].toLowerCase().contains(c.toLowerCase())){
                System.out.println(searchStr[i]);

            }
        }
    }
}
