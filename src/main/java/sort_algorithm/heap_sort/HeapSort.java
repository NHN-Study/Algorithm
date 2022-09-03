package sort_algorithm.heap_sort;

import utils.RandomNumberExtract;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static utils.Swap.swap;

/**
 * 최대 힙 트리나 최소 힙 트리를 구성해 정렬을 하는 방법
 * 내림차순 정렬을 위해서는 최대 힙을 구성하고 오름차순 정렬을 위해서는 최소 힙을 구성하면 된다.
 * 과정 설명
 * 정렬해야 할 n개의 요소들로 최대 힙(완전 이진 트리 형태)을 만든다.
 * 내림차순을 기준으로 정렬
 * 그 다음으로 한 번에 하나씩 요소를 힙에서 꺼내서 배열의 뒤부터 저장하면 된다.
 * 삭제되는 요소들(최댓값부터 삭제)은 값이 감소되는 순서로 정렬되게 된다.
 *
 * 장점
 * 시간 복잡도가 좋은편
 * 힙 정렬이 가장 유용한 경우는 전체 자료를 정렬하는 것이 아니라 가장 큰 값 몇개만 필요할 때 이다.
 *
 * 시간복잡도를 계산한다면
 *
 * 힙 트리의 전체 높이가 거의 log₂n(완전 이진 트리이므로)이므로 하나의 요소를 힙에 삽입하거나 삭제할 때 힙을 재정비하는 시간이 log₂n만큼 소요된다.
 * 요소의 개수가 n개 이므로 전체적으로 O(nlog₂n)의 시간이 걸린다.
 * T(n) = O(nlog₂n)
 *
 */
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