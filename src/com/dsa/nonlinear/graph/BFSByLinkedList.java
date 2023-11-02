package com.dsa.nonlinear.graph;

import com.dsa.model.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSByLinkedList {

    private List<GraphNode> nodeList = null;

    public BFSByLinkedList(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void bfsTraversal() {
        nodeList.stream().forEach(n -> {if (!n.isVisited()) {
        bfsVisitNode(n);}
        });
    }

    public void bfsVisitNode(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode presentNode = queue.remove();
            presentNode.setVisited(true);
            System.out.println("Visited " + presentNode.getData());
            presentNode.getNeighbors().forEach(n -> {
                if (!n.isVisited()) {
                    queue.add(n);
                    n.setVisited(true);
                }
            });
        }
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode start = nodeList.get(i - 1);
        GraphNode end = nodeList.get(j - 1);
        start.getNeighbors().add(end);
        end.getNeighbors().add(start);
    }

    public static void main(String[] args) {
//Initialize a Arraylist for storing all the graph nodes
        List<GraphNode> nodeList = new ArrayList<>();


        //create 10 nodes: v1-v10
        for(int i=1;i<11; i++) {
            nodeList.add(new GraphNode("V"+i));
        }


        //Constructor
        BFSByLinkedList graph = new BFSByLinkedList(nodeList);


        //add edges
        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(2,5);
        graph.addUndirectedEdge(3,6);
        graph.addUndirectedEdge(3,10);
        graph.addUndirectedEdge(4,7);
        graph.addUndirectedEdge(5,8);
        graph.addUndirectedEdge(6,9);
        graph.addUndirectedEdge(7,8);
        graph.addUndirectedEdge(8,9);
        graph.addUndirectedEdge(9,10);


        //bfs from v1
        System.out.println("Printing BFS from source: V1");
        graph.bfsTraversal();
    }
}
