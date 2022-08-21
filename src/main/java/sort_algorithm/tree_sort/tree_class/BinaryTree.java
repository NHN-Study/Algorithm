package sort_algorithm.tree_sort.tree_class;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 이진트리
 * 트리란 노드와 간선으로 이루어져 반복적으로 정의된 자료구조
 * 이진 트리는 트리의 종류 중 하나로 모든 노드가 두개의 서브트리를 가지고 있는 트리
 *  - 여기서 서브트리는 공백이 될수도있고, 하나의 서브트리만 가지거나 두개 모두 가질 수 있음
 *
 * BFS, DFS 모두 사용 가능
 * BFS - 큐(Queue) 활용
 * DFS - 재귀함수 또는 스택 활용
 *
 * @author 박세완
 */
public class BinaryTree {

    Node head;
    int size;

    /**
     * 생성자 입니다. head 는 비어있습니다.
     */
    public BinaryTree() {
        head = null;
        size = 0;
    }

    /**
     * 이진트리에 해당 노드를 삽입합니다.
     *
     * @param nd - 넣을 Node 입니다.
     */
    public void push(Node nd) {
        if (size == 0) {
            head = nd;
        }
        else {
            Node node = head;

            Queue<Node> q = new LinkedList<>();
            q.add(node);

            while (!q.isEmpty()) {
                Node temp = q.poll();

                if (temp.getLeft() == null) {
                    temp.setLeft(nd);
                    break;
                }
                else {
                    q.add(temp.getLeft());
                }

                if (temp.getRight() == null) {
                    temp.setRight(nd);
                    break;
                }
                else {
                    q.add(temp.getRight());
                }
            }
        }
        size++;
    }

    /**
     * 지정한 노드를 이진트리에서 제거하고 해당하는 Value 를 반환합니다.
     *
     * @param node - 제거할 노드입니다.
     * @return - 제거한 노드의 값을 반환합니다.
     */
    public int pop(Node node) {
        if (contain(node)) {
            Node lastNode = this.removeLastNode();

            if(head != null){
                if(isSame(head,node)){
                    head.setValue(lastNode.getValue());
                }
                else{
                    Queue<Node> q = new LinkedList<>();
                    q.add(head);

                    this.queueCheck(node, lastNode, q);
                }
            }
            size--;
            return 1;
        }
        return 0;
    }

    /**
     * 이진트리에 해당 노드가 존재하는지 확인합니다.
     *
     * @param node - 존재하는지 확인 할 노드의 정보입니다.
     * @return 노드의 존재 여부를 반환합니다.
     */
    public boolean contain(Node node) {
        boolean check = false;

        if (size != 0) {
            Queue<Node> q = new LinkedList<>();
            q.add(head);

            while (!q.isEmpty()) {
                Node temp = q.poll();

                if (this.isSame(temp,node)) {
                    check = true;
                    break;
                }

                if (temp.getLeft() != null) {
                    q.add(temp.getLeft());
                }

                if (temp.getRight() != null) {
                    q.add(temp.getRight());
                }
            }
        }
        return check;
    }

    /**
     * 지정한 노드로 BFS 탐색을 실시합니다.
     *
     * @param node - BFS 방식으로 탐색할 이진트리의 루트 노드입니다.
     */
    public void printBFS(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println(temp.getValue());

            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }

            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }
    }

    /**
     * 지정한 노드로 DFS 탐색을 실시합니다.
     *
     * @param node - DFS 방식으로 탐색할 이진트리의 루트 노드입니다.
     */
    public void printDFS(Node node) {

        if(node.getLeft() == null && node.getRight() == null){
            System.out.println(node.getValue());
        }else{
            if(node.getLeft() != null){
                printDFS(node.getLeft());
            }
            System.out.println(node.getValue());
            if(node.getRight() != null){
                printDFS(node.getRight());
            }
        }
    }

    private boolean isSame(Node a, Node b) {
        return a.getValue() == b.getValue() &&
                a.getLeft() == b.getLeft() &&
                a.getRight() == b.getRight();
    }

    private void queueCheck(Node node, Node lastNode, Queue<Node> q) {
        while(!q.isEmpty()){
            Node temp = q.poll();

            if(temp.getLeft() != null){
                if(isSame(temp.getLeft(), node)){
                    temp.getLeft().setValue(lastNode.getValue());
                    break;
                }
                q.add(temp.getLeft());
            }

            if(temp.getRight() != null && isSame(temp.getRight(), node)){
                temp.getRight().setValue(lastNode.getValue());
                break;
            }
        }
    }

    private Node removeLastNode() {
        Node last = head;

        if(size == 1){
            head = null;
        }
        else {
            Queue<Node> q = new LinkedList<>();
            q.add(last);

            while (!q.isEmpty()) {
                Node temp = q.poll();
                last = temp;

                if (temp.getLeft() != null) {
                    q.add(temp.getLeft());
                }

                if (temp.getRight() != null) {
                    q.add(temp.getRight());
                }
            }

            q.add(head);

            while(!q.isEmpty()){
                Node temp = q.poll();

                if(temp.getLeft() != null){
                    if(isSame(temp.getLeft(),last)){
                        temp.setLeft(null);
                        break;
                    }
                    q.add(temp.getLeft());
                }

                if(temp.getRight() != null){
                    if(isSame(temp.getRight(),last)){
                        temp.setRight(null);
                        break;
                    }
                    q.add(temp.getRight());
                }
            }
        }
        return last;
    }

}
