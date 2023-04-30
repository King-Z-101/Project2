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
                    Node number = new Node(line.charAt(i));
                    numbers.head = number;
                }
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
