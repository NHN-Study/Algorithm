package utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * 탐색을 위한 그래프 추출기능입니다.
 *
 * @author 박세완
 */
public final class GraphExtract {

    private static final Random rd = new Random();

    private GraphExtract () {}

    /**
     * 지정한 정보로 인접 리스트를 생성하기 위한 기능 메소드입니다.
     *
     * @param vertexSize - 탐색을 진행 할 그래프의 정점의 수입니다.
     * @param edgeSize - 탐색을 진행 할 그래프의 간선의 수입니다.
     * @param startVertex - 탐색을 시작할 정점의 시작 번호입니다.
     * @return 인접 리스트를 반환한다.
     */
    public static LinkedList<Integer>[] adjListExtract(int vertexSize, int edgeSize, int startVertex) {
        LinkedList<Integer>[] adjList = new LinkedList[vertexSize + 1];

        for (int i = 0; i <= vertexSize; i++) {
            adjList[i] = new LinkedList<>();
        }

        /*
        두 정점 사이에 여러개의 간선이 있을 수 있는 경우 생성
        v1, v2 각각 간선은 양방향 지원
         */
        for(int i = 0; i < edgeSize; i++) {
            int v1 = rd.nextInt(edgeSize);
            int v2 = rd.nextInt(edgeSize);

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i = 1; i <= vertexSize; i++) {
            Collections.sort(adjList[i]); // 방문 순서를 위한 오름차순 정렬을 기본
        }

        return adjList;
    }

}
