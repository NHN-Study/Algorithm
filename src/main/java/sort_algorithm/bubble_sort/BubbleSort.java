package sort_algorithm.bubble_sort;

import utils.Swap;

/**
 * 버블 정렬 알고리즘
 * 버블 정렬 알고리즘은 흔히 쉽게 구현 할수 있는 알고리즘 종류중의 하나이다.
 * 서로 인접한 2개의 원소를 비교해서 정렬한다.(선택 정렬과 매우 흡사)
 *
 * 비교 횟수
 * 최상, 평균, 최악 모두 일정
 * n-1, n-2, … , 2, 1 번 = n(n-1)/2
 *
 * 교환 횟수
 * 입력 자료가 역순으로 정렬되어 있는 최악의 경우,
 * 한 번 교환하기 위하여 3번의 이동(SWAP 함수의 작업)이 필요하므로 (비교 횟수 * 3) 번 = 3n(n-1)/2
 * 입력 자료가 이미 정렬되어 있는 최상의 경우, 자료의 이동이 발생하지 않는다.
 * T(n) = O(n²)
 *
 *
 * 장점
 * 구현이 매우 간단하다.
 * 단점
 * 순서에 맞지 않은 요소를 인접한 요소와 교환한다.
 * 하나의 요소가 가장 왼쪽에서 가장 오른쪽으로 이동하기 위해서는
 * 배열에서 모든 다른 요소들과 교환되어야 한다.
 * 특히 특정 요소가 최종 정렬 위치에 이미 있는 경우라도 교환되는 일이 일어난다.
 * 일반적으로 자료의 교환 작업(SWAP)이 자료의 이동 작업(MOVE)보다
 * 더 복잡하기 때문에 버블 정렬은 단순성에도 불구하고 거의 쓰이지 않는다.
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
