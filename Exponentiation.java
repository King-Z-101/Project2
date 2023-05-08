public class Exponential {
    public String exponent(LinkedList list1, LinkedList list2){
        long result;
        StringBuilder x = new StringBuilder();
        StringBuilder n = new StringBuilder();
        boolean left = true;
        boolean right = false;
        boolean loopContinue = true;
        Node leftInt = list1.head;
        Node rightInt = list2.head;
        while (loopContinue == true) {
            while (left == true) {
                x.append(leftInt.getItem());
                if (leftInt.getNext() == null) {
                    left = false;
                    right = true;
                    continue;
                } else {
                    leftInt = leftInt.getNext();
                }
            }

            while (right == true) {
                n.append(rightInt.getItem());
                if (rightInt.getNext() == null) {
                    right = false;
                    loopContinue = false;
                    continue;
                } else {
                    rightInt = rightInt.getNext();
                }
            }
        }
        //now we have the x^n as strings (need to be converted to integers
        int integer = Integer.parseInt(x.toString());
        int exponent = Integer.parseInt(n.toString());
        //use the algorithm to find the result (call exp_by_squaring)
        result = exp_by_squaring(integer, exponent);
        return String.valueOf(result);
    }
    public long exp_by_squaring(long x, long n) {
        if (n < 0) {
            return exp_by_squaring(1 / x, -n);
        }
        else if (n == 0) {return 1;}
        //check if number is even
        else if (n % 2 == 0){return exp_by_squaring(x * x, n / 2);}
        //check if number is odd
        else if (n % 2 != 0) {return x * exp_by_squaring(x * x, (n - 1) / 2);}
        return x;
    }
}
