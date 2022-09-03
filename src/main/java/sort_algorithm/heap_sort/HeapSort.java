package sort_algorithm.heap_sort;

import utils.RandomNumberExtract;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static utils.Swap.swap;

public class HeapSort {
    public static void main(String[] args) {
        List<Integer> index = RandomNumberExtract.numberExtract(1, 10, 10);
        Integer[] arr = index.toArray(Integer[]::new);
        // 정렬전 값

        Arrays.stream(arr).forEach(value -> System.out.print(value + " "));
        System.out.println();

        // 배열을 힙으로
        buildHeap(arr);
        // 힙 정렬
        heapSort(arr);
        //정렬 후 값
        System.out.println("정렬후 값 : ");
        Arrays.stream(arr)
                .forEach(value -> System.out.print(value + " "));
        System.out.println();

        Queue queue = new PriorityQueue(); // 실제 구현 큐랑 비교
        System.out.println("실제 Java 제공 Q");
        for (Integer value : arr) {
            queue.offer(value);
        }
        System.out.println(queue);
    }

    static void heapSort(Integer[] arr) {
        int eNN = arr.length - 1;
        while (eNN > 0) {
            swap(arr, 0, eNN);
            eNN--;
            pushDown(arr, 0, eNN);
        }
    }

    //eNN = endNodeNumber
    //tNN = tempNodeNumber
    static void buildHeap(Integer[] arr) {
        int eNN = arr.length - 1; // 마지막 노드
        int tNN = eNN / 2 + 1; //1번째 리프노드 번호

        while (tNN >= 1) {
            tNN--; // 자식을 가지고 있는 마지막 노드부터 시작
            pushDown(arr, tNN, eNN);
        }
    }

    static void pushDown(Integer[] arr, int tNN, int eNN) {
        int y = findLarger(arr, tNN, eNN);
        //자식 노드중에서 루트 노드보다 더 큰 값을 가지는 노드 번호 얻어냄

        while (arr[tNN] < arr[y]) {
            swap(arr, tNN, y);
            tNN = y;
            y = findLarger(arr, tNN, eNN);
            // leaf노드 쪽으로 내려가면서 값의 제자리를 찾아간다.
        }
    }

    static int findLarger(Integer[] arr, Integer tNN, Integer eNN) {
        int tmp = tNN * 2 + 1; //오른쪽 자식 노드의 번호
        int y = tNN;

        if (tmp <= eNN) {//자식 노드가 두개인 경우
            if (arr[tNN] < arr[tmp]) //오른쪽 자식 노드의 value가 더 크다면
                y = tmp;
            if (arr[y] < arr[tmp - 1]) //왼쪽 자식 노드의 value가 더 크다면
                y = tmp - 1;
        } else if (tmp - 1 <= eNN) { //자식 노드가 1개인 경우
            if (arr[tNN] < arr[tmp - 1]) // 자식 노드의 value가 더 크다면
                y = tmp - 1;
        }
        return y;
    }
}