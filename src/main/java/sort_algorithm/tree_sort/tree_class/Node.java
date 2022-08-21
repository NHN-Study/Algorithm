package sort_algorithm.tree_sort.tree_class;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {

    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }

}
