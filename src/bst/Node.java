package bst;

import java.util.LinkedList;

public class Node {

    private String key;
    private int record;
    private Node left;
    private Node right;

    public Node(String key, int record){
        this.key = key;
        this.record = record;
        this.left = null;
        this.right = null;
    }

    public Node() {
        this.key = null;
        this.record = -1;
        this.left = null;
        this.right = null;
    }

    public String getKey() {
        return key;
    }

    public int getRecord() {
        return record;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setRecord(int record) {
        this.record = record;
    }
}
