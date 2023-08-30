public class test {
    public static void main(String [] args) {

        System.out.println("Testing sameSizeMatrix");
        int[][] inputOne = { { 3, -2 }, { 15, 99 } };
        int[][] inputTwo = { { 37, -9 }, { 5, 21 } };
        Matrix matrixOne  = new Matrix(inputOne);
        Matrix matrixTwo  = new Matrix(inputTwo);

        MatrixOperations operations = new MatrixOperations();

        boolean result = operations.sameSizeMatrix(matrixOne, matrixTwo);

        System.out.println("Result: " + result);

    }
}
