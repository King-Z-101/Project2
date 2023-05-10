import java.util.ArrayList;
import java.util.List;

public class Multiplication {
    public String multiplication(LinkedList list1, LinkedList list2) {
        Addition add = new Addition();
        if (list1.head == null || list2.head == null) {
            return "";
        }
        Node current2 = list2.head;
        LinkedList products1 = new LinkedList();
        LinkedList products2 = new LinkedList();
        int iterations = 0;
        while (!(current2 == null)) {
            LinkedList partialProduct = new LinkedList();
            int carry = 0;
            Node current1 = list1.head;
            while (!(current1 == null)) {
                int product = (current1.getItem() * current2.getItem()) + carry;
                int digit = product % 10;
                carry = product / 10;
                partialProduct.add_to_tail(digit);
                current1 = current1.getNext();
            }
            if (carry > 0) {
                List<Integer> carry_list = new ArrayList<>();
                while (carry > 0) {
                    carry_list.add(carry % 10);
                    carry /= 10;
                }
                for (int i = carry_list.size() - 1; i >= 0; i--) {
                    partialProduct.add_to_tail(carry_list.get(i));
                }
            }
            iterations++;
            if (iterations == 1) {
                products1 = partialProduct;
            } else {
                int numZeros = iterations - 1;
                LinkedList shifted = new LinkedList();
                Node shiftedNode = products1.head;
                while (shiftedNode != null) {
                    shifted.add_to_tail(shiftedNode.getItem());
                    shiftedNode = shiftedNode.getNext();
                }
                for (int i = 0; i < numZeros; i++) {
                    shifted.addZeroToEnd();
                }
                products2 = partialProduct;

                // Reverse the linked lists before sending to the Addition class
                LinkedList reversedShifted = shifted.reverseLinkedList();
                LinkedList reversedProducts2 = products2.reverseLinkedList();

                LinkedList tempLL = new LinkedList();
                String products1_as_string = add.add(reversedShifted, reversedProducts2);

                // Reverse the result received from the Addition class
                String reversedResult = new StringBuilder(products1_as_string).reverse().toString();

                for (int i = 0; i < reversedResult.length(); i++) {
                    tempLL.add_to_tail(Character.getNumericValue(reversedResult.charAt(i)));
                }
                products1 = tempLL;
            }
            current2 = current2.getNext();
        }
        StringBuilder result = new StringBuilder();
        Node current = products1.head;
        while (current != null) {
            result.append(current.getItem());
            current = current.getNext();
        }
        return result.toString();
    }
}
