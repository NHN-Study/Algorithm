package sort_algorithm.selection_sort;

import java.util.List;

import static utils.RandomNumberExtract.numberExtract;

/**
 * 선택 정렬 알고리즘
 * 선택 정렬 알고리즘은 제자리 정렬 알고리즘의 하나
 * 1) 주어진 리스트 중 최소값 탐색
 * 2) 그 값을 배열의 가장 앞에있는 값의 위치와 교체
 * 3) 이 후 같은 방법으로 정렬
 *
 * 모든 인덱스에 접근해야하기에 기본적으로 O(N)을 가지고,
 * 루프 도중 현재 인덱스 값과 다른 인덱스 값들과 비교하여 최소값을 찾은 후 현재 위치와 swap 을 진행하는 부분에서 또 O(N)을 가짐
 * 시간복잡도: O(n²)
 *
 * n개 원소에 대해 n개의 메모리를 사용
 * 정렬을 위한 비교횟수는 많지만, 값 교환 횟수는 의외로 적음 (값의 교환이 많은 정렬에 효과적인 방식)
 * 알고리즘이 단순하며 사용할 수 있는 메모리가 제한적인 경우 사용 시 성능상의 이점 존재
 * 내림차순으로 정렬되어 있는 자료를 오름차순으로 재정렬할 때 최적의 효율 (ex. 역순 정렬 {5, 4, 3 ...})
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

        for(int i = 0; i < COLLECTION_SIZE - 1; i++) { // 마지막 값은 정렬을 필요로 하지 않기에 -1 (기준 값의 위치 값 표시)
            for(int j = i + 1; j < COLLECTION_SIZE; j++) { // 정렬할 숫자의 개수를 표시 (기준 값 제외한 값들로 비교)
                selectionSort(numberList, i, j); // 두 수를 검증 (비교)
            }
        }
        System.out.println("선택 정렬 후: " + numberList);
    }

    private static void selectionSort(List<Integer> numberList, int i, int j) {
        int temp;

        if(numberList.get(i) > numberList.get(j)) { // 비교를 진행하던 기준값이 비교값보다 큰 경우
            temp = numberList.get(i);
            numberList.set(i, numberList.get(j)); // 위치 교체
            numberList.set(j, temp);
        }
    }

}
