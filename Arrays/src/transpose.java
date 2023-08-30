public class transpose {
    public static void main(String [] args) {

        System.out.println("Testing transposeMatrix");
        int[][] inputOne = { { 6, 30, 54 }, { -36, 18, 47 }, { -3, 57, 29 } };
        Matrix matrixOne  = new Matrix(inputOne);

        MatrixOperations operations = new MatrixOperations();

        Matrix result = operations.transposeMatrix(matrixOne);

        System.out.println("Results of transposing a 3x3 matrix: ");
        System.out.println("Row 1, Element 1: " + result.matrix[0][0]);
        System.out.println("Row 1, Element 2: " + result.matrix[0][1]);
        System.out.println("Row 1, Element 3: " + result.matrix[0][2]);
        System.out.println("Row 2, Element 1: " + result.matrix[1][0]);
        System.out.println("Row 2, Element 2: " + result.matrix[1][1]);
        System.out.println("Row 2, Element 3: " + result.matrix[1][2]);
        System.out.println("Row 3, Element 1: " + result.matrix[2][0]);
        System.out.println("Row 3, Element 2: " + result.matrix[2][1]);
        System.out.println("Row 3, Element 3: " + result.matrix[2][2]);

    }

}
