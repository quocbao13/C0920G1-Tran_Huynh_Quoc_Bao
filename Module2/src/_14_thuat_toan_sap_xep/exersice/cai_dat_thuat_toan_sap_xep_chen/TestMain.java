package _14_thuat_toan_sap_xep.exersice.cai_dat_thuat_toan_sap_xep_chen;

import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) {
        int[] a = {7,3,2,6,84,64,1,6,9,4,5,24,58};
        insertionSort(a);
    }

    public static void insertionSort(int[] list){
        int n = list.length;
        for (int i = 1; i < n; ++i) {
            int key = list[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
        System.out.println(Arrays.toString(list));
    }
}
