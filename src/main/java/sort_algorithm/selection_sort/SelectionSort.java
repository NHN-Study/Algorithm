package sort_algorithm.selection_sort;

import java.util.List;

import static utils.RandomNumberExtract.numberExtract;

/**
 * 선택 정렬 알고리즘
 *
 * @author 박세완
 */
public class SelectionSort {

    public static void main(String[] args) {

        List<Integer> numberList = numberExtract(0, 30, 10);
        System.out.println(numberList);

    }

}
