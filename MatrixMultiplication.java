import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MatrixMultiplierThread extends Thread {
    private final int[][] result;
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int row;

    public MatrixMultiplierThread(int[][] result, int[][] matrix1, int[][] matrix2, int row) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }

    @Override
    public void run() {
        int cols = matrix2[0].length;
        for (int col = 0; col < cols; col++) {
            result[row][col] = 0;
            for (int i = 0; i < matrix1[row].length; i++) {
                result[row][col] += matrix1[row][i] * matrix2[i][col];
            }
        }
    }
}

public class MatrixMultiplication {
    public static void main(String[] args) {
        // Set the dataSize for the matrices
        int dataSize = 3000;

        int[][] matrix1 = generateRandomMatrix(dataSize);
        int[][] matrix2 = generateRandomMatrix(dataSize);

        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int[][] result = new int[rows][cols];

        // Set the number of threads
        int numThreads = 1;

        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        // Record start time
        long startTime = System.currentTimeMillis();

        // Create threads for each row
        for (int i = 0; i < rows; i++) {
            Runnable worker = new MatrixMultiplierThread(result, matrix1, matrix2, i);
            executor.execute(worker);
        }

        executor.shutdown();

        try {
            // Wait for all threads to finish
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Record end time
        long endTime = System.currentTimeMillis();

        // Display the result
        System.out.println("Matrix Result (partial) Thread:");
        //displayPartialMatrix(result);

        // Calculate time taken in seconds
        double timeTakenInSeconds = (endTime - startTime) / 1000.0;

        // Display time taken to complete multiplication in seconds
        System.out.println("Time Taken: " + timeTakenInSeconds + " seconds");
    }

    private static int[][] generateRandomMatrix(int size) {
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = random.nextInt(100); // Adjust the upper bound as needed
            }
        }
        return matrix;
    }

    private static void displayPartialMatrix(int[][] matrix) {
        int rowsToDisplay = Math.min(5, matrix.length);
        int colsToDisplay = Math.min(5, matrix[0].length);

        for (int i = 0; i < rowsToDisplay; i++) {
            System.out.println(Arrays.toString(Arrays.copyOf(matrix[i], colsToDisplay)));
        }

        if (rowsToDisplay < matrix.length || colsToDisplay < matrix[0].length) {
            System.out.println("...");
        }
    }
}