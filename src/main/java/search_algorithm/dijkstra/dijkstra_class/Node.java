package search_algorithm.dijkstra.dijkstra_class;

import lombok.Getter;

@Getter
public class Node implements Comparable<Node> {

    private final int weight;
    private final int index;

    public Node(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.weight, node.weight);
    }

}
