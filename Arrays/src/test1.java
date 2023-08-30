public class test1 {
    public static void main(String [] args) {

        System.out.println("Testing incorrect inputs");
        int[][] inputOne = { { 101, -11, 33 }, { 1, 24, 13 }, { -54, 10, 62} };
        int[][] inputTwo = { { 50, 98 }, { 17, 82 } };
        Matrix matrixOne  = new Matrix(inputOne);
        Matrix matrixTwo  = new Matrix(inputTwo);


        MatrixOperations operations = new MatrixOperations();

        boolean result = operations.sameSizeMatrix(matrixOne, matrixTwo);

        if (result) {
            System.out.println("sameSizeMatrix should return false for invalid matrices.");
        }

        Matrix resultAdd = operations.addMatrix(matrixOne, matrixTwo);

        if(resultAdd != null) {
            System.out.println("addMatrix should return null for invalid matrices.");
        }

        Matrix resultSubtract = operations.subtractMatrix(matrixOne, matrixTwo);

        if(resultSubtract != null) {
            System.out.println("subtractMatrix should return null for invalid matrices.");
        }

       Matrix resultProduct = operations.productMatrix(matrixOne, matrixTwo);

       if(resultProduct != null) {
            System.out.println("subtractMatrix should return null for invalid matrices.");
        }

        Matrix resultPrint = null;

        System.out.println("printMatrix should not print anything for a null Matrix");
        operations.printMatrix(resultPrint);


    }
}
