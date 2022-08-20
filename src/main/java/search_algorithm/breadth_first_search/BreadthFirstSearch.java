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
 * [시간복잡도]
 * 정점의 수가 n, 간선의 수가 e 인 그래프
 *  - 그래프가 인접 리스트로 표현 된 경우 O(n + e)
 *  - 인접 행렬로 표현 된 경우 O(n²)
 *
 * [장점]
 * 최적화 된 탐색 보장
 *  너비를 우선으로 탐색하기 때문에 답이되는 경로가 여러개임에도 최단경로 보장
 * 최단 경로가 존재 시, 한 경로가 무한히 깊어진다 해도 최단경로를 반드시 찾을 수 있음
 *
 * [단점]
 * DFS(깊이 우선 탐색) 보다 구현이 좀 더 복잡
 *  ㄴ 노드의 수가 많을수록 필요없는 노드들까지 저장해야 하기에 더 큰 저장공간 필요
 * 최소 실행시간보다 오래 걸린다는 것이 기정사실화
 * 최악의 경우, 실행에 가장 긴 시간 소요
 *  ㄴ 노드의 수가 늘어나면 탐색해야하는 노드 또한 많아지기 때문에 비현실적
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
