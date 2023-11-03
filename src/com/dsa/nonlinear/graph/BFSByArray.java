package com.dsa.nonlinear.graph;

import com.dsa.model.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSByArray {
    public List<GraphNode> nodeList = null;

    public int[][] adjancencyMatrix = null;

    public BFSByArray(List<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjancencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void bfs() {
        nodeList.forEach(n -> {
            if (!n.isVisited()) {
                bfsNodeVisit(n);
            }
        });
    }

    public void bfsNodeVisit(GraphNode node) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode presentNode = queue.remove();
            presentNode.setVisited(true);
            System.out.println(presentNode.getData() + " ");
            List<GraphNode> neighbors = getNeigbhors(presentNode);
            neighbors.forEach(neighbor -> {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            });
        }
    }

    private List<GraphNode> getNeigbhors(GraphNode presentNode) {
        List<GraphNode> neighbors = new ArrayList<>();

        for (int i = 0; i < adjancencyMatrix.length; i++) {
            if (adjancencyMatrix[presentNode.getNodeIndex()][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }
        return neighbors;
    }

    private void addUndirectedEdge(int i, int j) {
        i--;
        j--;
        adjancencyMatrix[i][j] = 1;
        adjancencyMatrix[j][i] = 1;
    }

    public static void main(String[] args) {
        //Initialize a Arraylist for storing all the graph nodes
        List<GraphNode> nodeList = new ArrayList<>();

        //create 10 nodes: v1-v10
        for (int i = 1; i < 11; i++) {
            nodeList.add(new GraphNode("V" + i, i - 1));
        }

        //Constructor
        BFSByArray graph = new BFSByArray(nodeList);

        //add edges
        graph.addUndirectedEdge(1, 2);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(2, 5);
        graph.addUndirectedEdge(3, 6);
        graph.addUndirectedEdge(3, 10);
        graph.addUndirectedEdge(4, 7);
        graph.addUndirectedEdge(5, 8);
        graph.addUndirectedEdge(6, 9);
        graph.addUndirectedEdge(7, 8);
        graph.addUndirectedEdge(8, 9);
        graph.addUndirectedEdge(9, 10);

        //bfs from v1
        System.out.println("Printing BFS from source: V1");
        graph.bfs();
    }
}
