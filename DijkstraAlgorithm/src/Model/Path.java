package Model;

import java.util.List;

public class Path {
    private List<Node> nodes;

    public Path(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void printPath() {
        for (int i = 0; i < nodes.size(); i++) {
            System.out.print(nodes.get(i).getName());
            if (i < nodes.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}

