import java.io.*;
import java.util.*;

public class A3_Tester {

    static boolean isWeirdEqual(int[] a, int[] b) {

        // So it compiles and runs
        return false;
    }


    public static void test_all_cases() {
        int i;
        int total_tests = 13;
        int passed_tests = 0;

        System.out.println("======= Assignment 3 - Test Cases =======");

        for (i = 0; i <= total_tests; i++) {
            try {
                // Test files input00.txt to input13.txt
                String inputFileName = "input" + String.format("%02d", i) + ".txt"; 
                String outputFileName = "output" + String.format("%02d", i) + ".txt";
                String file = "input/" + inputFileName;
                boolean result = readFile(file);

                file = "output/" + outputFileName;

                Scanner in = new Scanner(new File(file));
                String expected = in.nextLine();
                in.close();

                String actual = result ? "YES" : "NO";

                if (expected.equals(actual)) {
                    System.out.println("Test " + String.format("%02d", i) + ": PASS");
                    passed_tests++;
                } else {
                    System.out.println("Test " + String.format("%02d", i) + ": FAIL! \t**\t **");
                    System.out.println("\tExpected: [" + expected + "]");
                    System.out.println("\tActual:   [" + actual + "]");
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        }

        System.out.println("========================================");
        System.out.println("Test Results: " + (passed_tests - 1) + "/" + total_tests + " tests passed.");
    }

    private static boolean readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int j = 0; j < n; j++){
            a[j] = in.nextInt();
        }
        
        for(int j = 0; j < n; j++){
            b[j] = in.nextInt();
        }
        
        in.close();
        return isWeirdEqual(a, b);

    }
    
    public static void main(String[] args) {
        /* Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        test_all_cases();
    }
}