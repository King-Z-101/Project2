public class Node {
    private int item;
    private Node next;
    //private Node prev = this;
    //constructor
    public Node(int item) {
        this.item = item;
    }
    // getters
    public Node getNext(){
        return this.next;
    }
//    public Node getPrev(){
//        return this.prev;
//    }


    // setters
    public void setNext(Node node){
        this.next = node;
    }

    public int getItem() {
        return item;
    }
//    public void setPrev(Node node){
//        this.prev = node;
//    }
}
