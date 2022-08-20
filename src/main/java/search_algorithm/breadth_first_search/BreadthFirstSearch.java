package search_algorithm.breadth_first_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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

    private static final int VERTEX_SIZE = 5; // 정점의 개수
    private static final int EDGE_SIZE = 5; // 간선의 개수
    private static final int START_VERTEX = 3; // 탐색을 시작할 정점의 번호

    /**
     * 입력받은 정보를 바탕으로 생성된 그래프를 너비 우선 탐색 방식으로 탐색하는 메소드입니다.
     *
     * @param args - 프로그램 실행 시 외부로부터 받는 값입니다.
     */
    public static void main(String[] args) {
        LinkedList<Integer>[] adjList = adjListExtract(VERTEX_SIZE, EDGE_SIZE);
        boolean[] visited = new boolean[VERTEX_SIZE + 1]; // 방문 여부를 검사할 배열

        System.out.println(Arrays.toString(adjList)); // 탐색한 그래프 정보

        System.out.println("BFS - 인접리스트");
        bfsList(adjList, visited);
    }

    private static void bfsList(LinkedList<Integer>[] list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int vertex;
        visited[START_VERTEX] = true;
        queue.add(START_VERTEX);

        System.out.print("탐색 경로 순서: ");
        while (queue.size() != 0) { // 큐가 비어있지 않다면
            vertex = queue.poll(); // 큐의 첫번째 값을 반환하고 큐에서 제거
            System.out.print(vertex + " ");

            visitAdd(list, visited, queue, vertex);
        }
    }

    private static void visitAdd(LinkedList<Integer>[] list, boolean[] visited, Queue<Integer> queue, int vertex) {
        for (int w : list[vertex]) {
            if (!visited[w]) { // 해당 노드에 방문했는지 확인
                visited[w] = true;
                queue.add(w); // 방문하지 않았던 노드를 큐에 추가
            }
        }
    }

}
