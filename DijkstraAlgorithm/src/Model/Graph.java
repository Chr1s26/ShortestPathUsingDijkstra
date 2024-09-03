package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {
    private List<Node> nodes;
    private List<Edge> edges;

    public Graph() {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Node startNode, Node endNode, int weight) {
        Edge edge = new Edge(startNode, endNode, weight);
        edges.add(edge);
    }

    public List<Edge> getEdgesFromNode(Node node) {
        List<Edge> result = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getStartNode().equals(node)) {
                result.add(edge);
            }
        }
        return result;
    }

    public void findShortestPath(Node startNode) {
        startNode.setDistance(0);

        List<Node> unvisitedNodes = new ArrayList<>(nodes);

        while (!unvisitedNodes.isEmpty()) {
        	
            Node currentNode = getClosestNode(unvisitedNodes);
            currentNode.setVisited(true);
            unvisitedNodes.remove(currentNode);
            //B,C,D,E
          //A => B,C
           //A => B is 1 , A=>C is 4 , A<=B A<=C
            
            //B =>
            for (Edge edge : getEdgesFromNode(currentNode)) {
                Node targetNode = edge.getEndNode();
                if (!targetNode.isVisited()) {
                    int newDist = currentNode.getDistance() + edge.getWeight();
                    if (newDist < targetNode.getDistance()) {
                        targetNode.setDistance(newDist);
                        targetNode.setPrevious(currentNode);
                    }
                }
            }
        }
    }
    //B 
    private Node getClosestNode(List<Node> unvisitedNodes) {
        Node closestNode = null;
        int smallestDistance = Integer.MAX_VALUE;
        //smallestDistance is 1
        for (Node node : unvisitedNodes) {
            if (node.getDistance() < smallestDistance) {
                smallestDistance = node.getDistance();
                closestNode = node;
            }
        }

        return closestNode;
    }

    public Path getShortestPath(Node targetNode) {
        List<Node> pathNodes = new ArrayList<>();
        for (Node node = targetNode; node != null; node = node.getPrevious()) {
            pathNodes.add(node);
        }
        Collections.reverse(pathNodes);
        return new Path(pathNodes);
    }

    public Node getNode(String name) {
        for (Node node : nodes) {
            if (node.getName().equals(name)) {
                return node;
            }
        }
        return null;
    }
}
