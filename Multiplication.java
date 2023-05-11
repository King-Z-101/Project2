public class Multiplication {
    public String multiply(LinkedList list1, LinkedList list2) {
        if (list1 == null || list2 == null || list1.head == null || list2.head == null) {
            return "";
        }

        LinkedList resultList = new LinkedList();
        Node leftHead = list1.head;
        int leftPadding = 0;
        Addition addition = new Addition();

        while (leftHead != null) {
            int carry = 0;
            int leftDigit = leftHead.getItem();
            Node rightHead = list2.head;
            LinkedList currentProductList = new LinkedList();

            for (int i = 0; i < leftPadding; i++) {
                currentProductList.add_to_tail(0);
            }

            while (rightHead != null) {
                int rightDigit = rightHead.getItem();
                int product = leftDigit * rightDigit + carry;
                carry = product / 10;
                currentProductList.add_to_tail(product % 10);
                rightHead = rightHead.getNext();
            }

            if (carry > 0) {
                currentProductList.add_to_tail(carry);
            }

            resultList = addLinkedLists(resultList, currentProductList, addition);
            leftHead = leftHead.getNext();
            leftPadding++;
        }

        resultList = resultList.reverseLinkedList();
        return resultList.toString();
    }

    private LinkedList addLinkedLists(LinkedList list1, LinkedList list2, Addition addition) {
        if (list1 == null || list1.head == null) {
            return list2;
        }

        if (list2 == null || list2.head == null) {
            return list1;
        }

        String sumStr = addition.add(list1, list2);
        LinkedList result = new LinkedList();

        for (int i = 0; i < sumStr.length(); i++) {
            int digit = Character.getNumericValue(sumStr.charAt(i));
            result.add_to_list(digit);
        }

        return result;
    }
}
