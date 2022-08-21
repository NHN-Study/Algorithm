package search_algorithm.dijkstra;

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
 * @author 박세완
 */
public class Dijkstra {
}
