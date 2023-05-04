import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        Linked_List numbers = new Linked_List();
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                for (int i = 0; i < line.length(); i++){
                    char c = line.charAt(i);   //u can use getNumericValue to find value/number passed
                    Node number = new Node(c);
                    //numbers.head = number;
                    numbers.num_items++;
                    if (numbers.num_items == 1){
                        numbers.head = number;
                        continue;
                    }
                    else{
                        number.setNext(numbers.head);
                        numbers.head = number;
                    }
                }
                System.out.println(line);
                Node indexNode = numbers.head;
                for (int i = 0; i < numbers.num_items; i++){
                    //start at header node and move through the linked list until we find the operator we're working with
                    if (indexNode.getItem() == 43) { //addition ascii
                        Addition add = new Addition();
                        add.add(numbers);

                    }
                    else if (indexNode.getItem() == 42){ //Multiplication ascii
                        Multiplication mult = new Multiplication();
                        mult.multiplication(numbers);

                    }
                    else if (indexNode.getItem() == 94){   //exponent ascii
                        Exponential exponent = new Exponential();
                        exponent.exponent(numbers);

                    }
                    indexNode = indexNode.getNext();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
