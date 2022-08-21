package search_algorithm.dijkstra.dijkstra_class;

import lombok.Getter;

@Getter
public class Graph {
    private final int nodeSize; // 노드들의 수
    private final int[][] nodeCost; // 노드들간의 가중치를 저장할 변수

    public Graph(int nodeSize) {
        this.nodeSize = nodeSize;
        nodeCost = new int[nodeSize][nodeSize];

        this.arrayInitialization(nodeSize);
    }

    public void input(int i, int j, int w) {
        nodeCost[i][j] = w;
        nodeCost[j][i] = w;
    }

    // 인접 행렬 모든 값 무한대로 초기화
    private void arrayInitialization(int nodeSize) {
        for(int i = 0; i< nodeSize; ++i) {
            for(int j = 0; j< nodeSize; ++j) {
                nodeCost[i][j] = Integer.MAX_VALUE;
            }
        }
    }

}
