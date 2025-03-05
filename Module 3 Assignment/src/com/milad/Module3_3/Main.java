package com.milad.Module3_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        BFS();
    }

    /**
     * Breadth First Search function that visits the graph level by level
     */
    private static void BFS() {
        LinkedList<Node> nodesQueue = new LinkedList<>(); // FIFO queue of what nodes to visit
        nodesQueue.add(graph.getFirst());
        while(!nodesQueue.isEmpty()) {
            Node currentNode = nodesQueue.pollFirst(); // Getting the FIFO from the queue
            for (Integer point : currentNode.getNodes()) { // Getting all the nodes from its next level
                int graphPoint = point - 1; // Since node key is 1 greater than its graph index
                // Queuing next point if it hasn't been visited and is not already inside queue
                if (!graph.get(graphPoint).isVisited() && !nodesQueue.contains(graph.get(graphPoint))) {
                    nodesQueue.add(graph.get(graphPoint));
                }
            }
            System.out.println("Explored " + currentNode);
            currentNode.setVisited(true);
        }
        System.out.println("Finished Breadth First Search!");
    }
    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("src/com/milad/Module3_3/tree.txt"));
        while(scan.hasNext()){
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for(int i = 1; i < keys.length;i++){
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }
}
