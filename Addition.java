public class Addition {
    public String add(LinkedList list1, LinkedList list2){
        // padding with zeros to make numbers the same length
        int length_diff = Math.abs(list1.num_items - list2.num_items);
        if (list1.num_items < list2.num_items){
            for (int i = 0; i < length_diff; i++){
                Node pad = new Node(0);
                Node temp = list1.head;
                list1.head = pad;
                pad.setNext(temp);
                list1.num_items++;
                //list1.add_to_list(0);
            }
        }
        if (list1.num_items > list2.num_items){
            for (int i = 0; i < length_diff; i++){
                Node pad = new Node(0);
                Node temp = list2.head;
                list2.head = pad;
                pad.setNext(temp);
                list2.num_items++;
                //list2.add_to_list(0);
            }
        }
        // for example 123 + 3 becomes 123 + 003
        Node node1 = list1.head;
        Node node2 = list2.head;
        int carry = 0;
        StringBuilder string_result = new StringBuilder();
        while (node1 != null && node2 != null) {
            int sum = node1.getItem() +node2.getItem() + carry;
            carry = sum / 10; //should be like a remainder
            int digit_result = sum % 10;
            string_result.append(digit_result);
            node1 = node1.getNext(); // update to next slot in the LL
            node2 = node2.getNext();
        }
        if (carry > 0){
            string_result.append(carry);
        }
        return string_result.toString();
    }
}
