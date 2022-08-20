package sort_algorithm.merge_sort;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomNumberExtract.numberExtract;

/**
 * 병합 정렬 알고리즘
 * 병합 정렬 알고리즘은 비교 기반 정렬 알고리즘
 * 1) 주어진 리스트를 절반으로 분할하여 각 부분 리스트로 나눔
 * 2) 부분 리스트의 길이가 1이 아니라면 1번 과정을 계속 반복
 * 3) 부분리스트의 길이가 1이 됐다면 인접한 부분리스트 간 정렬 후 병합
 *  3-1) 이때 병합은 각 부분리스트의 첫번째 원소부터 순차적으로 비교
 * 4) 부분리스트의 길이가 기존 리스트의 길이와 같아질때까지 반복
 * <p>
 * 병합 정렬은 N개의 데이터가 있는 리스트를 1개까지 쪼개어 트리로 나타나게 되면 "이진트리" 형태가 나옴
 * N개의 노드에 대한 이진트리의 높이: logN <- 해당 정보는 "힙정렬" 에서도 다룸
 * 이미 정렬된 두 부분 리스트는 최악의 상황이어도 두개의 서브리스트 원소개수만큼의 비교와 병합이 끝
 * n번째 레벨엘서 부분리스트의 개수가 2ⁿ, 한 부분리스트에 들어가있는 원소 개수는 N/2ⁿ
 * 이 두 개수를 곱하면 비교작업에 대한 시간 복잡도가 나오게 됨 -> O(N)
 * 비교작업 : O(N) 병합 작업: O(logN)
 * 시간복잡도: O(N) X O(logN) = O(NlogN)
 * <p>
 * 다만 병합정렬같은 경우에는 정렬과정에서 추가적인 보조 배열공간을 사용하기 때문에 메모리 사용량이 많음
 * 부분 리스트에서 원본 리스트로 복사하는 과정은 시간 소요가 많기에 데이터가 많을경우 상대적으로 시간이 많이 소요됨
 *
 * @author 박세완
 * @see <a href="https://www.youtube.com/watch?v=ZRPoEKHXTJg">https://www.youtube.com/watch?v=ZRPoEKHXTJg</a>
 */
public class MergeSort {

    private static final int MIN = 1;
    private static final int MAX = 6;
    private static final int COLLECTION_SIZE = 6;

    private static final List<Integer> sortList = new ArrayList<>();

    /**
     * 지정한 범위 내의 숫자들을 병합정렬 방식으로 정렬한다.
     *
     * @param args - 프로그램 실행 시 외부로부터 받는 값입니다.
     */
    public static void main(String[] args) {
        List<Integer> numberList = numberExtract(MIN, MAX, COLLECTION_SIZE);

        for(int i = 0; i < COLLECTION_SIZE; i++) {
            sortList.add(0);
        }

        System.out.println("병합 정렬 전: " + numberList);

        listDivide(numberList, 0, COLLECTION_SIZE - 1);

        System.out.println("병합 정렬 후: " + numberList);
    }

    private static void listDivide(List<Integer> list, int left, int right) {
        if (left < right) { // 데이터의 개수가 2개 이상일 경우 실행
            int mid = (left + right) / 2; // 기존 리스트를 반으로 나누기 위한 변수

            listDivide(list, left, mid); // 왼쪽 부분리스트 재귀 호출
            listDivide(list, mid + 1, right); // 오른쪽 부분리스트 재귀 호출

            merge(list, left, mid, right); // 각 부분리스트들의 데이터를 병합하는 과정
        }
    }

    private static void merge(List<Integer> list, int left, int mid, int right) {
        int i = left; // 좌측 부분리스트
        int j = mid + 1; // 우측 부분리스트
        int sortIndex = left; // 정렬을 시작 할 인덱스 위치

        while (i <= mid && j <= right) {
            if (list.get(i) < list.get(j)) { // 기준값이 비교값보다 클 경우 비교값 먼저 값 대입
                sortList.set(sortIndex++, list.get(i++));
                System.out.println("left: " + left + " mid: " + mid + " merge 기준값이 비교값보다 작을때 조건: " + sortList);
            } else { // 기준값이 비교값보다 작을경우 그대로 값 대입
                sortList.set(sortIndex++, list.get(j++));
                System.out.println("right: " + right + " mid:" + mid + " merge 기준값이 비교값보다 클때 조건: " + sortList);
            }
        }
        sortIndex = sortList(list, mid, right, i, j, sortIndex);

        for (int index = left; index < sortIndex; index++) {
            list.set(index, sortList.get(index));
        }
    }

    private static int sortList(List<Integer> list, int mid, int right, int i, int j, int sortIndex) {
        while (i <= mid) { // 부분리스트 중 기준값 데이터가 남아있는 경우
            sortList.set(sortIndex++, list.get(i++)); // 기준값 삽입
            System.out.println("mid: " + mid + " sortList 기준값 남음: " + sortList);
        }

        while (j <= right) { // 부분리스트 중 비교값 데이터가 남아있는 경우
            sortList.set(sortIndex++, list.get(j++)); // 비교값 삽입
            System.out.println("right: " + right + " sortList 비교값 남음: " + sortList);
        }
        return sortIndex;
    }

}
