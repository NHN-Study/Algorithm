package sort_algorithm.bubble_sort;

import utils.Swap;

/**
 * 설명작성란
 *
 * @author : 유호철
 * @since 1.0
 */
public class BubbleSort {
    public static void main(String[] args) {
        Integer[] arr = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]){
                    Swap.swap(arr,j,j+1);
                }
            }
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
