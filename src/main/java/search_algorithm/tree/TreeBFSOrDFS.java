package search_algorithm.tree;

import sort_algorithm.tree_sort.tree_class.BinaryTree;
import sort_algorithm.tree_sort.tree_class.Node;

import java.util.ArrayList;
import java.util.List;

import static utils.RandomNumberExtract.*;

/**
 * 이진트리를 이용한 BFS/DFS 탐색 알고리즘입니다.
 *
 * @author 박세완
 */
public class TreeBFSOrDFS {

    private static final int NODE_SIZE = 40;
    private static final int MIN = 1;
    private static final int MAX = 40;
    private static final List<Integer> NUMBER_LIST = numberExtract(MIN, MAX, NODE_SIZE);
    private static int count = 0;
    private static int enter = 1;

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        List<Node> nodeList = new ArrayList<>();

        System.out.println("이진트리");

        for (Integer number : NUMBER_LIST) {
            System.out.print(" " + number + " ");
            if((count == enter) || enter == 1) {
                System.out.println();
                enter = enter * 2;
                count = 0;
            }
            Node node = new Node(number);
            nodeList.add(node);
            count ++;
        }

        for (Node node : nodeList) {
            binaryTree.push(node);
        }
        System.out.println();

        System.out.println("BFS 탐색");
        binaryTree.printBFS(nodeList.get(0));

        System.out.println("DFS 탐색");
        binaryTree.printDFS(nodeList.get(0));
    }

}
