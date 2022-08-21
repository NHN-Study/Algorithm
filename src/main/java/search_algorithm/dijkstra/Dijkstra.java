package search_algorithm.dijkstra;

import search_algorithm.dijkstra.dijkstra_class.Graph;
import search_algorithm.dijkstra.dijkstra_class.Node;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 다익스트라 알고리즘
 * 그래프에서 한 정점에서 다른 정점까지의 최단 경로를 구하는 알고리즘 (BFS 기반, Greedy 알고리즘 기반)
 * 1) 탐색을 시작 할 노드와 탐색할 도착 노드를 설정
 * 2) '최단 거리 테이블' 을 초기화
 *  2-1) 최단 거리 테이블: 1차원 배열, N개 노드까지 오는데 필요한 최단 거리를 기록
 * 3) 현재 위치한 노드의 인접 노드 중 방문하지 않은 노드를 구별
 * 4) 방문하지 않은 노드 중 거리가 가장 짧은 노드 선택 후 방문 처리
 * 5) 3 ~ 4 의 과정을 반복
 *
 * 각 정점마다 인접한 간선들을 탐색하는 과정
 * - 각 노드는 최대 한번씩 방문하기 때문에 모든 간선은 최대 한번씩 검사 => O(E)
 * 우선순위 큐에 [거리, 정점] 정보를 넣고 뺴는 과정
 * - 최악의 경우는 모든 간선을 검사할때마다 거리 값 리스트가 갱신, 우선순위 큐에 정보가 저장되는 경우
 * - E개의 간선을 검사할 때마다 우선순위 큐를 유지해야함 => O(ElogE)
 * 시간복잡도: O[E] + O(ElogE) = O(ElogE)
 *
 * [장점]
 * 그래프가 큰 경우에도 사용할 수 있음
 * 특정한 하나의 정점에서 다른 모든 정점으로가는 최선의 선택을 하는 알고리즘
 *
 * [단점]
 * 음수인 가중치를 가진 간선이 있는 경우에는 사용할 수 없음
 *  - 이전 노드까지 계산해둔 최소거리 값이 최소하로 보장 할 수 없음.
 *  - 다 익스트라 알고리즘은 정점을 지날수록 가중치가 증가한다는 전제하에 사용
 *      - 하지만 음의 가중치가 있다면 정점을 지날수록 가중치가 감소할 수 있다는 전제가 깔려 사용 불가
 *
 * 예제그래프
 * @see <a href="https://gomgomkim.tistory.com/19">...</a>
 * @author 박세완
 */
public class Dijkstra {
    private static final int VERTEX_SIZE = 6; // 값 변경 시 노드 추가 입력받아야함
    private static final int START_INDEX = 0;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Graph graph = new Graph(VERTEX_SIZE);

        inputDistance(graph); // 간선 길이 입력

        System.out.println("===========");
        for(int i=0; i<VERTEX_SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("===========");

        PriorityQueue<Node> queue = new PriorityQueue<>(); // 노드까지의 거리를 저장할 우선순위 큐
        int[] distance = new int[VERTEX_SIZE]; // 최단 거리를 저장할 변수
        boolean[] check = new boolean[VERTEX_SIZE]; // 해당 노드를 방문했는지 체크할 변수

        // 거리값 초기화. 무한대를 int 자료형의 최대값으로 표현
        for(int i=0; i<VERTEX_SIZE; ++i){
            distance[i] = Integer.MAX_VALUE;
        }

        // 시작노드값 초기화
        queue.add(new Node(START_INDEX, 0));
        distance[START_INDEX] = 0;
        check[START_INDEX] = true;

        // 결과값 출력
        for(int i=0; i<VERTEX_SIZE; ++i){
            if(distance[i] == 2147483647) System.out.print("∞ ");
            else System.out.print(distance[i]+" ");
        }
        System.out.println();

        // 연결노드 거리값 갱신
        for(int i=0; i<VERTEX_SIZE; ++i){
            if(!check[i] && graph.getNodeCost()[START_INDEX][i] != Integer.MAX_VALUE){
                distance[i] = graph.getNodeCost()[START_INDEX][i];
                queue.add(new Node(graph.getNodeCost()[START_INDEX][i], i));
            }
        }

        // 결과값 출력
        for(int i=0; i<VERTEX_SIZE; ++i){
            if(distance[i] == 2147483647) System.out.print("∞ ");
            else System.out.print(distance[i]+" ");
        }
        System.out.println("");

        while(!queue.isEmpty()){
            // 원래는 모든 노드가 true 될때까지 인데
            // 노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번
            // 원하지 않으면 각각의 노드가 모두 true 인지 확인하는 식으로 구현
            int min_index = -1;

            // 노드 최소값 꺼내기
            Node node = queue.poll();
            min_index = Objects.requireNonNull(node).getIndex();

            // 다른 노드를 거쳐서 가는 것이 더 비용이 적은지 확인
            check[min_index] = true;
            for(int i=0; i<VERTEX_SIZE; ++i){
                if(!check[i] && graph.getNodeCost()[min_index][i] != Integer.MAX_VALUE){
                    if(distance[min_index] + graph.getNodeCost()[min_index][i] < distance[i]){
                        distance[i] = distance[min_index] + graph.getNodeCost()[min_index][i];
                        queue.add(new Node(distance[i], i));
                    }
                }
            }

            // 결과값 출력
            for(int i=0; i<VERTEX_SIZE; ++i){
                if(distance[i] == 2147483647) System.out.print("∞ ");
                else System.out.print(distance[i]+" ");
            }
            System.out.println();
        }
    }

    private static void inputDistance(Graph graph) {
        System.out.print("0번과 1번 노드 사이의 거리 입력: ");
        graph.input(0, 1, sc.nextInt());
        System.out.print("0번과 2번 노드 사이의 거리 입력: ");
        graph.input(0, 2, sc.nextInt());
        System.out.print("0번과 5번 노드 사이의 거리 입력: ");
        graph.input(0, 5, sc.nextInt());
        System.out.print("1번과 2번 노드 사이의 거리 입력: ");
        graph.input(1, 2, sc.nextInt());
        System.out.print("1번과 3번 노드 사이의 거리 입력: ");
        graph.input(1, 3, sc.nextInt());
        System.out.print("2번과 3번 노드 사이의 거리 입력: ");
        graph.input(2, 3, sc.nextInt());
        System.out.print("2번과 5번 노드 사이의 거리 입력: ");
        graph.input(2, 5, sc.nextInt());
        System.out.print("3번과 4번 노드 사이의 거리 입력: ");
        graph.input(3, 4, sc.nextInt());
        System.out.print("4번과 5번 노드 사이의 거리 입력: ");
        graph.input(4, 5, sc.nextInt());
    }

}
