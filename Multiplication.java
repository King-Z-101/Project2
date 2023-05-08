import java.util.ArrayList;
import java.util.List;

public class Multiplication {
    public String multiplication(LinkedList list1, LinkedList list2){
        Addition add = new Addition();
        // list 2 will be the "bottom" numbers of partial products multiplication
        if (list1.head == null || list2.head == null){
            return "";
        }
        Node current2 = list2.head;
        LinkedList products1 = new LinkedList();
        LinkedList products2 = new LinkedList();
        int iterations = 0;
        String product1_string = "";
        while (!(current2 == null)){
            LinkedList partialProduct = new LinkedList();
            int carry = 0;
            Node current1 = list1.head;
            // nested loop starts
            while(!(current1 == null)) {
                // multiply products here and create a string of each
                int product = (current1.getItem() * current2.getItem()) + carry;
                int digit = product % 10;
                carry = product / 10;
                partialProduct.add_to_list(digit);
                current1 = current1.getNext();
            }
            if (carry > 0) {
                // carry could be multiple digit, so split carry into individual digits.
                List<Integer> carry_list = new ArrayList<>();
                carry_list.add(carry);
                while (carry > 0) {
                    carry_list.add(carry % 10);
                    carry /= 10;
                }
                for (int i = carry_list.size() - 1; i >= 0; i--) {
                    partialProduct.add_to_list(carry_list.get(i));
                }
            }
            iterations ++;
            if (iterations == 1){
                products1 = partialProduct;
           } else {
                products2 = partialProduct;
                LinkedList tempLL = new LinkedList();
                String products1_as_string = add.add(products1, products2);
                for (int i = 0; i < products1_as_string.length(); i ++){
                    tempLL.add_to_list(Character.getNumericValue(products1_as_string.charAt(i)));
                }
                products1 = tempLL;
            }
            current2 = current2.getNext();
            //partialProduct.clear_list();

        }
        StringBuilder result = new StringBuilder();
        Node current = products1.head;
        while (current != null){
            result.append(current.getItem());
            current = current.getNext();
        }
        return result.reverse().toString();
    }
}
