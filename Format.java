public class Format {
    private String output = "";
    public String formatOutput(LinkedList list1, LinkedList list2, int operator,String result){
        boolean left = true;
        boolean right = false;
        StringBuilder leftNum = new StringBuilder();
        StringBuilder rightNum = new StringBuilder();
        Node current1 = list1.head;
        Node current2 = list2.head;
        //deleting leftover 0's
        while (current1 != null){
            leftNum.append(current1.getItem());
            current1 = current1.getNext();
        }
        StringBuilder normalLeft = new StringBuilder();
        normalLeft = leftNum.reverse();
        boolean deleteLeft = true;
        int j = 0;
        while (deleteLeft == true){
            if (Character.getNumericValue(normalLeft.charAt(0)) == 0){
                normalLeft.deleteCharAt(j);
                j++;
            }
            else {
                deleteLeft = false;
            }

        }
        output += normalLeft;

        if (operator == 1 /*addition*/ ){
            output += " + ";
        }
        else if (operator == 2 /*multiplication*/ ){
            output += " * ";
        }
        else if (operator == 3 /*exponent*/ ){
            output += " ^ ";
        }

        while (current2 != null){
            rightNum.append(current2.getItem());
            current2 = current2.getNext();
        }
        StringBuilder normalRight = new StringBuilder();
        normalRight = rightNum.reverse();
        boolean deleteRight = true;
        int i = 0;
        while (deleteRight == true){
            if (Character.getNumericValue(normalRight.charAt(0)) == 0){
                normalRight.deleteCharAt(i);
                i++;
            }
            else {
                deleteRight = false;
            }

        }
        output += normalRight;
        output += " = ";
        output += result;

        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
