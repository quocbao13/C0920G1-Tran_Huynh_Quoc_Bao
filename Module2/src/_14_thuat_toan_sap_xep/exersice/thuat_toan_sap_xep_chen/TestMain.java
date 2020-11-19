package _14_thuat_toan_sap_xep.exersice.thuat_toan_sap_xep_chen;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[] a = {7,3,2,6,84,64,1,6,9,4,5,24,58};
        getSort(a);
    }

    public static void getSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
