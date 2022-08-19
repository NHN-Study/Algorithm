package sort_algorithm.insertion_sort;

import java.util.List;

import static utils.RandomNumberExtract.numberExtract;

/**
 * 삽입 정렬 알고리즘
 * 삽입 정렬 알고리즘의 정렬 흐름은 다음과 같다
 * 1) 첫번째 인덱스가 시작 기준값, 두번째 인덱스부터 비교, 정렬
 * 2) 비교할 값이 기준값보다 작다면 기준값과 위치를 교환
 * 3) 정렬이 마무리 되면 세번째 인덱스의 값을 왼쪽 인덱스와 비교해가면서 알맞은 위치에 넣음
 * 4) 이미 정렬된 배열 부분과도 비교하며 비교할 값이 들어갈 위치를 찾아냄으로써 정렬을 완성
 *
 * [최선의 경우]
 * 비교 횟수 : 이동 없이 1번의 비교만 이루어 짐
 * (외부 루프: (n - 1)번)
 * 시간복잡도: O(n)
 *
 * [최악의 경우 (입력 자료가 역순)]
 * 비교횟수 : 외부 루프 안의 각 반복마다 i번 비교 수행
 * (외부 루프: (n - 1) + (n + 2) + ... + 2 + 1 = n * (n - 1) / 2 = O(n²)
 * 교환횟수 : 외부 루프의 각 단계마다 (i + 2)번의 비교 수행
 * (외부 루프: (n * (n - 1) / 2 + 2 * (n - 1) = (n² + 3n - 4) / 2 = O(n²)
 * 시간복잡도: O(n²)
 *
 * [장점]
 * 선택정렬과 버블정렬에 비해 빠른 속도
 * 안전한 정렬방법
 * 레코드의 수가 적을 경우 알고리즘 자체가 매우 간단해 다른 복잡한 정렬방법보다 유리
 * 대부분의 레코드가 이미 정렬되어있는 경우에 매우 효율적
 *
 * [단점]
 * 비교적 많은 레코드들의 이동을 포함
 * 레코드 수가 많고 레코드 크기가 클 경우 적합 X
 *
 * @author 박세완
 */
public class InsertionSort {

    private static final int MIN = 0;
    private static final int MAX = 50;
    private static final int COLLECTION_SIZE = 10;

    /**
     * 지정한 범위 내의 숫자들을 삽입정렬 방식으로 정렬한다
     *
     * @param args - 프로그램 실행 시 외부로부터 받는 값입니다.
     */
    public static void main(String[] args) {
        List<Integer> numberList = numberExtract(MIN, MAX, COLLECTION_SIZE);
        System.out.println("삽입 정렬 전: " + numberList);

        for(int i = 1; i < numberList.size(); i++) {
            insertionSort(numberList, i);
        }
        System.out.println("삽입 정렬 후: " + numberList);
    }

    private static void insertionSort(List<Integer> numberList, int i) {
        int temp = numberList.get(i);
        int k = i - 1;

        while (k >= 0 && numberList.get(k) > temp) { // k번째 인덱스의 값이 i번째 인덱스의 값보다 클 경우
            numberList.set(k + 1, numberList.get(k)); // k + 1 번째 인덱스의 값을 k번째 인덱스의 값으로 변경
            k--;
        }
        numberList.set(k + 1, temp); // 조건 불충일시, k + 1 번째 인덱스의 값을 i번째 인덱스의 값으로 지정
    }

}

































