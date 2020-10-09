package com.algorithm.all.graph;

/**
 * @ClassNameEdge
 * @Description
 * @Author Yao Xin
 * @Date2020/10/9 15:06
 **/
public class Edge {
    private int weight;
    private Node from;
    private Node to;

    public Edge() {
    }

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }
}
