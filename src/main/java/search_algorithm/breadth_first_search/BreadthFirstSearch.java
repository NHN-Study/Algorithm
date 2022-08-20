package search_algorithm.breadth_first_search;

import java.util.Arrays;
import java.util.LinkedList;

import static utils.GraphExtract.adjListExtract;

/**
 * 너비 우선 탐색 (BFS)
 * 너비 우선 탐색의 탐색 방식은 다음과 같다.
 * 1) 시작 정점을 지난 이후 깊이가 1인 모든 정점을 방문
 * 2) 1인 모든 정점 방문을 마쳤다면, 깊이가 2인 모든 정점 방문
 * 3) 이런식으로 한 단계씩 깊이를 더해가며 해당 깊이에 있는 모든 정점들을 방문
 * 4) 더 이상 깊이가 없어 방문할 곳이 없을 시 탐색 종료
 *
 *
 * @author 박세완
 */
public class BreadthFirstSearch {

    private static final int VERTEX_SIZE = 9; // 정점의 개수 (간선보다 항상 -1)
    private static final int EDGE_SIZE = 10; // 간선의 개수
    private static final int START_VERTEX = 1; // 탐색을 시작할 정점의 번호

    public static void main(String[] args) {
        LinkedList<Integer>[] adjList = adjListExtract(VERTEX_SIZE, EDGE_SIZE, START_VERTEX);
        boolean visited[] = new boolean[VERTEX_SIZE + 1]; // 방문 여부를 검사할 배열

        System.out.println(Arrays.toString(adjList));
    }

}
