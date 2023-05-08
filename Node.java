public class Node {
    private int item;
    private Node next;

    //constructor
    public Node(int item) {
        this.item = item;
        this.next = null;
    }

    // getters
    public Node getNext() {
        return this.next;
    }

    // setters
    public void setNext(Node node) {
        this.next = node;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;

    }
}
