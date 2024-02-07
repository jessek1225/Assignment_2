import java.io.FileWriter;
import java.io.IOException;

public class Performance {
    public static void main(String[] args) {
        // Array sizes to test
        int[] arraySizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        // Sorting algorithms to test
        SortingAlgorithm[] sortingAlgorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort()
        };

        // Number of iterations
        int iterations = 20;

        try {
            // Create a FileWriter to write the results to a text file
            FileWriter writer = new FileWriter("performance_report.txt");

            // Iterate over each sorting algorithm
            for (SortingAlgorithm algorithm : sortingAlgorithms) {
                writer.write("Sorting algorithm - " + algorithm.getClass().getSimpleName() + "\n");

                // Iterate over each array size
                for (int size : arraySizes) {
                    // Create a Tester object with the current sorting algorithm
                    Tester tester = new Tester(algorithm);

                    // Run the test method with the current array size and iterations
                    double averageTime = tester.singleTest(size);

                    // Write the result to the file
                    writer.write("Sorted " + size + " elements in " + averageTime + " ms (avg)\n");
                }
            }

            // Close the FileWriter
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



