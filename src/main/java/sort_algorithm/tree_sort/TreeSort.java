package sort_algorithm.tree_sort;

import sort_algorithm.tree_sort.tree_class.Node;

import java.util.List;
import java.util.Objects;

import static utils.RandomNumberExtract.numberExtract;

/**
 * 트리정렬
 * 이진 탐색 트리를 이용한 정렬 방식
 *
 * 1) 이진 검색 트리의 배열에서 요소를 삽입하여 이진 검색트리 형성
 * 2) 트리에서 순서대로 순회
 * 3) 요소를 정렬된 순서로 되돌림
 *
 * 이진 탐색트리에서 삽입 연산 (insertBTS) 와 중위 순회 연산 (inOrder) 가 필요
 * 트리 정렬에서 원소들을 비교하여 이진 탐색트리의 구성 시간 => O(logN)
 * N개의 노드에 대해서 이진탐색트리를 구성하고, 트리 정렬을 수행
 * 시간복잡도 => O(NlogN)
 *
 * @author 박세완
 */
public class TreeSort {

    private static Node root = null;
    private static int index = 0;
    private static Node temp;

    private static final int MIN = 0;
    private static final int MAX = 50;
    private static final int SIZE = 10;
    private static final List<Integer> NUMBER_LIST = numberExtract(MIN, MAX, SIZE);

    public static void main(String[] args) {
        System.out.println("정렬 전: " + NUMBER_LIST);

        treeSort();
    }

    private static void treeSort() {
        for (int i : NUMBER_LIST) {
            insertBST(i);
        }
        inOrder(root);

        System.out.println("정렬 후: " + NUMBER_LIST);
    }

    /**
     * 중위순회를 진행합니다.
     * 중위순회: 왼쪽 하위 트리를 방문 후 root 를 방문, 이후 오른쪽 하위 트리 방문
     *
     * @param node - 순회를 진행 할 노드 정보입니다. (최상단 노드)
     */
    private static void inOrder(Node node) {
        if(Objects.nonNull(node)) {
            inOrder(node.getLeft());
            NUMBER_LIST.set(index++, node.getValue());
            inOrder(node.getRight());
        }
    }

    /**
     * 이진 탐색 트리를 생성합니다.
     *
     * @param data - 정렬을 진행 할 데이터입니다.
     */
    private static void insertBST(int data) {
        Node newNode = new Node(data);
        if(Objects.isNull(root)) {
            root = newNode;
        } else {
            temp = root;
            loopTempCheck(data, newNode);
        }
    }

    private static void loopTempCheck(int data, Node newNode) {
        while (true) {
            if (tempCheck(data, newNode)) {
                return;
            }
        }
    }

    private static boolean tempCheck(int data, Node newNode) {
        if (temp.getValue() > data) { // 현재 삽입 값보다 노드의 값이 더 클경우
            if (Objects.isNull(temp.getLeft())) {
                temp.setLeft(newNode);
                return true;
            }
            temp = temp.getLeft();
        } else {
            if (Objects.isNull(temp.getRight())) {
                temp.setRight(newNode);
                return true;
            }
            temp = temp.getRight();
        }
        return false;
    }

}
