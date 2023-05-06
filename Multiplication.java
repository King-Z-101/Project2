public class Multiplication {
    public String multiplication(LinkedList list1, LinkedList list2){
        Addition add = new Addition();
        // list 2 will be the "bottom" numbers of partial products multiplication
        //LinkedList result = new LinkedList();
        StringBuilder resultFinal = new StringBuilder();
        if (list1.head == null || list2.head == null){
            return "";
        }
        Node current2 = list2.head;
        LinkedList products1 = new LinkedList();
        LinkedList products2 = new LinkedList();
        int iterations = 0;
        String product1_string = "";
        while (!(current2.getNext() == null)){
            LinkedList partialProduct = new LinkedList();
            int carry = 0;
            for (int i = 0; i < list2.num_items - 1; i++) {
                partialProduct.add_to_list(0);
            }

            // multiply products here and create a string of each

            Node current1 = list1.head;
            while(!(current1 == null)){
                int product = (current1.getItem() * current2.getItem()) + carry;
                int digit = product % 10;
                carry = product / 10;
                partialProduct.add_to_list(digit);
                current1 = current1.getNext();
            }
            if (carry > 0){
                partialProduct.add_to_list(carry);
            }

            iterations ++;
            if (iterations == 1){
                products1 = partialProduct;
           }
//                product1_string = add.add(products1, partialProduct);
//
//            }
//            products1.clear_list();
//            for (int i = 0; i < iterations; i++){
//                products1.add_to_list(0);
//            }
//            for (int i =0; i < partialProduct.num_items; i++;){
//                products1.add_to_list(partialProduct.);
//            }
            if (iterations >= 2) {
                products2 = partialProduct;
                product1_string = add.add(products1, products2);
                products1.clear_list();
                for (int i = 1; i < product1_string.length(); i++) {
                    products1.add_to_list(Character.getNumericValue(product1_string.charAt(i)));
                }
            }
            partialProduct.clear_list();

            for (int i = 0; i < iterations; i++) {
                partialProduct.add_to_list(0);
            }

//            resultFinal.append(add.add(result, partialProduct));
            current2 = current2.getNext();
        }
        return product1_string;
    }
}
