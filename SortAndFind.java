//Name: Rayan Bouamrane
//Student Number: 260788250

import java.util.Random;

public class SortAndFind {

    public static void main(String[] args) {

        int[][] matrix = generateRandomMatrix(6, 8);
        displayMatrix(matrix);
        sortMatrix(matrix);
        displayMatrix(matrix);

        System.out.println("The element " + 14 + " is in position ["
        + findElement(matrix, 14)[0] + ", " + findElement(matrix, 14)[1] + "]");
        System.out.println();

        System.out.println("The element " + 26 + " is in position ["
        + findElement(matrix, 26)[0] + ", " + findElement(matrix, 26)[1] + "]");
        System.out.println();

        System.out.println("The element " + 5 + " is in position ["
        + findElement(matrix, 5)[0] + ", " + findElement(matrix, 5)[1] + "]");
    }

    public static int[][] generateRandomMatrix(int m, int n) { //1a
        //new 2-dimensional array declared with size m x n
        int[][] matrix = new int[m][n];

        //entries of the matrix are assigned values of randNum.nextInt at
        //index i up to m, and index j up to n
        int seed = 123;
        Random randNum = new Random(seed);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int rad = randNum.nextInt(50);
                matrix[i][j] = rad;
            }
        return matrix;
    }

    private static void displayMatrix(int[][] matrix) { //1b
        //nested for loop prints each matrix element with a tab, and a new line after each row/sub-array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }

    private static void sortOneRow(int[] arr) { //1c
        //outer loop assigns index the value of i every iteration
        //this means only unsorted elements are iterated through
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;

            //inner loop checks if the element at index j is smaller than at "index", and assigns "index" j
            //this means "index" stores the index of the smallest element in the array
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index]) index = j;

            //this swaps the smallest element and the left-most unsorted element in the array
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
    }

    private static void sortOneColumn(int[][] matrix, int cNum) { //1d
        //very similar to sortOneRow, the if condition checks which element in the same column is larger
        for (int i = 0; i < matrix.length; i++) {
            int index = i;

            for (int row = i + 1; row < matrix.length; row++)
                if (matrix[row][cNum] < matrix[index][cNum]) index = row;

            int temp = matrix[i][cNum];
            matrix[i][cNum] = matrix[index][cNum];
            matrix[index][cNum] = temp;
        }
    }

    private static void sortMatrix(int[][] matrix) { //1e
        //each row/array of the matrix is passed through the sortOneRow method
        //the array, whose rows are now sorted, has all its columns sorted, from j = 0 up to the of one column
        for (int i = 0; i < matrix.length; i++)
            sortOneRow(matrix[i]);

        for (int j = 0; j < matrix[0].length; j++)
            sortOneColumn(matrix, j);
    }

    private static int[] findElement(int[][] matrix, int n) {
        //this loop begins at the bottom left of the matrix, the row index is "length - 1" (4) and column index = 1
        int column = 0;
        for (int row = matrix.length - 1; column < matrix[0].length && row >= 0; ) {

            //if the element at the index is smaller than n, we move up the matrix, row = row - 1
            //if the element is larger than n, we move right, column = column + 1
            //if the loop completes and no array is returned, the element is not in the matrix, return -1,-1
            if (n == matrix[row][column]) {
                int[] pos = {row, column};
                return pos;
            } else if (n < matrix[row][column])
                row--;
            else if (n > matrix[row][column])
                column++;
        }
        int[] notFound = {-1, -1};
        return notFound;
    }
}