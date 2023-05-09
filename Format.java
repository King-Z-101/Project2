public class Format {
    private String output = "";
    public String formatOutput(LinkedList list1, LinkedList list2, int operator,String result){
        boolean left = true;
        boolean right = false;
        //boolean result = false;
        Node current1 = list1.head;
        Node current2 = list2.head;
        //Node current3 = list3.head;
        while (left == true){
            output += current1.getItem();
            if (current1.getNext() == null){
                left = false;
                right = true;
                continue;
            }
            else {
                current1 = current1.getNext();
            }
        }
        if (operator == 1 /*addition*/ ){
            output += " + ";
        }
        else if (operator == 2 /*multiplication*/ ){
            output += " * ";
        }
        else if (operator == 3 /*exponent*/ ){
            output += " ^ ";
        }
        while (right == true){
            output += current2.getItem();
            if (current2.getNext() == null){
                right = false;
                //result = true;
                continue;
            }
            else {
                current2 = current2.getNext();
            }
        }

        output += " = ";
        output += result;

//        while (result == true){
//            output += current3.getItem();
//            if (current3.getNext() == null){
//                result = false;
//                continue;
//            }
//            else {
//                current3 = current3.getNext();
//            }
//        }

        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
