package search_algorithm.breadth_first_search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static utils.GraphExtract.adjArrayExtract;
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
        int[][] adjArray = adjArrayExtract(VERTEX_SIZE, EDGE_SIZE);
        boolean[] listVisited = new boolean[VERTEX_SIZE + 1]; // 인접 리스트 방문 여부를 검사할 배열
        boolean[] arrayVisited = new boolean[VERTEX_SIZE + 1]; // 인접 행렬 방문 여부를 검사할 배열

        System.out.println("탐색할 인접 리스트 그래프: " + Arrays.toString(adjList));
        System.out.println("==============");
        System.out.println("탐색할 인접 행렬 그래프: " + Arrays.deepToString(adjArray));

        System.out.println("\nBFS - 인접리스트");
        bfsList(adjList, listVisited);
        System.out.println("\n==============");
        System.out.println("BFS - 인접행렬");
        bfsArray(adjArray, arrayVisited);
    }

    private static void bfsList(LinkedList<Integer>[] list, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int vertex;
        visited[START_VERTEX] = true;
        queue.add(START_VERTEX);

        System.out.print("인접 리스트 탐색 경로 순서: ");
        while (queue.size() != 0) { // 큐가 비어있지 않다면
            vertex = queue.poll(); // 큐의 첫번째 값을 반환하고 큐에서 제거
            System.out.print(vertex + " ");

            listVisitAdd(list, visited, queue, vertex);
        }
    }

    private static void bfsArray(int[][] array, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int n = array.length - 1;
        int vertex;

        queue.add(START_VERTEX);
        visited[START_VERTEX] = true;

        System.out.print("인접 행렬 탐색 경로 순서: ");
        while (!queue.isEmpty()) {
            vertex = queue.poll();
            System.out.print(vertex + " ");

            arrayVisitAdd(n, array, visited, queue, vertex);
        }

    }

    private static void listVisitAdd(LinkedList<Integer>[] list, boolean[] visited, Queue<Integer> queue, int vertex) {
        for (int w : list[vertex]) {
            if (!visited[w]) { // 해당 노드에 방문했는지 확인
                visited[w] = true;
                queue.add(w); // 방문하지 않았던 노드를 큐에 추가
            }
        }
    }

    private static void arrayVisitAdd(int n, int[][] array, boolean[] visited, Queue<Integer> queue, int vertex) {
        for (int i = 1; i <= n ; i++) {
            if (array[vertex][i] == 1 && !visited[i]) {
                queue.add(i);
                visited[i] = true;
            }
        }
    }

}
