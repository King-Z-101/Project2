import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        //allowed ascii value
        //int[] deez = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 43, 42, 94};
        //LinkedList numbers = new LinkedList();
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                LinkedList left = new LinkedList();
                LinkedList right = new LinkedList();
                boolean leftSide = true;
                boolean rightSide = false;

                int operator = 0;
//                if (n != 48 && n != 49 && n != 50 && n != 51 && n != 52 && n != 53 && n != 54 && n != 55 && n != 56
//                        && n != 57 && n != 58 && n != 43 && n != 42 && n != 94) {
//                    continue;
                for (int i = 0; i < line.length(); i++){
                    int n = line.charAt(i);//u can use getNumericValue to find value/number passed
                    if (n == 32){continue;}
                    if (leftSide == true){
                        if (n == 43){
                            leftSide = false;
                            rightSide = true;
                            operator = 1;
                            continue;

                        }
                        else if (n == 42){
                            leftSide = false;
                            rightSide = true;
                            operator = 2;
                            continue;
                        }
                        else if (n == 94){
                            leftSide = false;
                            rightSide = true;
                            operator = 3;
                            continue;
                        }
                        else{
                            left.add_to_list(Character.getNumericValue(n));
                        }
                    }
                    if (rightSide == true){
                        right.add_to_list(Character.getNumericValue(n));
                    }
                }
                System.out.println(line);
                if (operator == 1){
                    Addition addition = new Addition();
                    addition.add(left,right);
                }
//                else if (operator == 2){
//                    Multiplication multiplication = new Multiplication();
//                    Multiplication.mult(left,right);
//                }
//                else if (operator == 3){
//                    Exponential exponential = new Exponential();
//                    exponential.exponent(left, right);
//                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
