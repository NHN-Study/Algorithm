package sort_algorithm.selection_sort;

import java.util.List;

import static utils.RandomNumberExtract.numberExtract;

/**
 * 선택 정렬 알고리즘
 *
 * @author 박세완
 */
public class SelectionSort {

    private static final int MIN = 0;
    private static final int MAX = 50;
    private static final int COLLECTION_SIZE = 10;

    /**
     * 지정한 범위 내의 숫자들을 선택정렬 방식으로 정렬한다.
     *
     * @param args - 프로그램 실행 시 외부로부터 받는 값입니다.
     */
    public static void main(String[] args) {
        List<Integer> numberList = numberExtract(MIN, MAX, COLLECTION_SIZE);

        System.out.println("선택 정렬 전: " + numberList);

        for(int i = 0; i < COLLECTION_SIZE - 1; i++) {
            for(int j = i + 1; j < COLLECTION_SIZE; j++) {
                selectionSort(numberList, i, j);
            }
        }
        System.out.println("선택 정렬 후: " + numberList);
    }

    private static void selectionSort(List<Integer> numberList, int i, int j) {
        int temp;

        if(numberList.get(i) > numberList.get(j)) {
            temp = numberList.get(i);
            numberList.set(i, numberList.get(j));
            numberList.set(j, temp);
        }
    }

}
