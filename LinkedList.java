public class LinkedList {
    public Node head;
    public int num_items;

    public LinkedList() {
        this.head = null; //default head pointer
        this.num_items = 0;
    }
    // add_to_list will be used to build the linked list based on the file input
    public void add_to_list(int number){
        Node newNode = new Node(number);
        if (head == null){
            head = newNode;

        }
        else {
            Node current = head;
            while (current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
