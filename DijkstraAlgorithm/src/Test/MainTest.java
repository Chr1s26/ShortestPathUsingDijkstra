package Test;


import java.util.Scanner;

import Model.Graph;
import Model.Node;
import Model.Path;

public class MainTest {
    public static void main(String[] args) {
  
        Graph graph = new Graph();

    
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

      
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addNode(D);
        graph.addNode(E);

        
        graph.addEdge(A, B, 1);
        graph.addEdge(A, C, 4);
        graph.addEdge(B, C, 2);
        graph.addEdge(B, D, 5);
        graph.addEdge(C, D, 1);
        graph.addEdge(D, E, 3);

   
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start node: ");
        String startNodeName = scanner.nextLine();
        System.out.print("Enter end node: ");
        String endNodeName = scanner.nextLine();

        Node startNode = graph.getNode(startNodeName);
        Node endNode = graph.getNode(endNodeName);

        if (startNode == null || endNode == null) {
            System.out.println("Invalid start or end node.");
            return;
        }

     
        graph.findShortestPath(startNode);

        
        Path path = graph.getShortestPath(endNode);
        System.out.print("Shortest path from " + startNode.getName() + " to " + endNode.getName() + ": ");
        path.printPath();
    }
}
