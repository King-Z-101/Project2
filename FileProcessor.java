import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        //PrintWriter outFile = new PrintWriter("output.txt");
        try (Scanner scan = new Scanner(infile);
             PrintWriter outFile = new PrintWriter("output.txt")){
            while (scan.hasNext()) {
                // TODO: Process each line of the input file here.
                String line = scan.nextLine();
                LinkedList left = new LinkedList();
                LinkedList right = new LinkedList();
                boolean leftSide = true;
                boolean rightSide = false;

                int operator = 0;

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
                String outputLine = "";
                Format format = new Format();
                boolean plugText = false;
                String result = "";
                if (operator == 1){
                    Addition addition = new Addition();
                    result = addition.add(left,right);
                    //correctly formats the output line (new class created)
                    outputLine = format.formatOutput(left, right, operator, result);
                    plugText = true;
                }
                else if (operator == 2){
                    Multiplication Mult = new Multiplication();
                    result = Mult.multiplication(left,right);
                    outputLine = format.formatOutput(left, right, operator, result);
                    plugText = true;
                }
                else if (operator == 3){
                    Exponential exponential = new Exponential();
                    result = exponential.exponent(left, right);
                    outputLine = format.formatOutput(left, right, operator, result);
                    plugText = true;
                }
                if (plugText == true){
                    outFile.println(outputLine);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
