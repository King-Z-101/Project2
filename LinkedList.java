public class LinkedList {
    public Node head;
    public Node tail;
    public int num_items;
    public LinkedList() {
        this.head = null; //default head pointer
        this.num_items = 0;
    }

    // add_to_list will be used to build the linked list based on the file input
    public void add_to_list(int number) {
        Node newNode = new Node(number);
        this.num_items++;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void clear_list() {
        Node temp = this.head;
        temp.setNext(null);
        this.num_items = 0;
    }

    public String toString() {
        StringBuilder SB = new StringBuilder();
        Node current = this.head;
        while (current != null) {
            SB.append(current.getItem());
            current = current.getNext();
        }
        return SB.toString();
    }
}
