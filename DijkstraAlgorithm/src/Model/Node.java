package Model;

public class Node {
    private String name;
    private boolean visited;
    private int distance;
    private Node previous;

    public Node(String name) {
        this.name = name;
        this.visited = false;
        this.distance = Integer.MAX_VALUE; 
        this.previous = null;
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}

