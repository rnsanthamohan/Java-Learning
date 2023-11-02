package com.dsa.model;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    private String data;

    private boolean isVisited;

    private List<GraphNode> neighbors = new ArrayList<>();

    public GraphNode(String value) {
        this.data = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<GraphNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<GraphNode> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
