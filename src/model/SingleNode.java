package model;

public class SingleNode {
    public Integer data;
    public SingleNode next;

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "[" +
                 data +
                ", " + next +
                ']';
    }
}
