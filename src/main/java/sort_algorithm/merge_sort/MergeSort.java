package sort_algorithm.merge_sort;

/**
 * 병합 정렬 알고리즘
 * 병합 정렬 알고리즘은 비교 기반 정렬 알고리즘
 * 1) 주어진 리스트를 절반으로 분할하여 각 부분 리스트로 나눔
 * 2) 부분 리스트의 길이가 1이 아니라면 1번 과정을 계속 반복
 * 3) 부분리스트의 길이가 1이 됐다면 인접한 부분리스트 간 정렬 후 병합
 *  3-1) 이때 병합은 각 부분리스트의 첫번째 원소부터 순차적으로 비교
 * 4) 부분리스트의 길이가 기존 리스트의 길이와 같아질때까지 반복
 *
 * 병합 정렬은 N개의 데이터가 있는 리스트를 1개까지 쪼개어 트리로 나타나게 되면 "이진트리" 형태가 나옴
 * N개의 노드에 대한 이진트리의 높이: logN <- 해당 정보는 "힙정렬" 에서도 다룸
 * 이미 정렬된 두 부분 리스트는 최악의 상황이어도 두개의 서브리스트 원소개수만큼의 비교와 병합이 끝
 * n번째 레벨엘서 부분리스트의 개수가 2ⁿ, 한 부분리스트에 들어가있는 원소 개수는 N/2ⁿ
 * 이 두 개수를 곱하면 비교작업에 대한 시간 복잡도가 나오게 됨 -> O(N)
 * 비교작업 : O(N) 병합 작업: O(logN)
 * 시간복잡도: O(N) X O(logN) = O(NlogN)
 *
 * 다만 병합정렬같은 경우에는 정렬과정에서 추가적인 보조 배열공간을 사용하기 때문에 메모리 사용량이 많음
 * 부분 리스트에서 원본 리스트로 복사하는 과정은 시간 소요가 많기에 데이터가 많을경우 상대적으로 시간이 많이 소요됨
 *
 * @author 박세완
 * @see <a href="https://www.youtube.com/watch?v=ZRPoEKHXTJg">https://www.youtube.com/watch?v=ZRPoEKHXTJg</a>
 */
public class MergeSort {

    private static final int MIN = 0;
    private static final int MAX = 50;
    private static final int COLLECTION_SIZE = 10;

    /**
     * 지정한 범위 내의 숫자들을 병합정렬 방식으로 정렬한다.
     *
     * @param args - 프로그램 실행 시 외부로부터 받는 값입니다.
     */
    public static void main(String[] args) {

    }

}
