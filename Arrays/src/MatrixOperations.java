import java.util.Scanner;
public class MatrixOperations {
    private int columns;

    public boolean sameSizeMatrix(Matrix m1, Matrix m2){
        if (m1.getRows() == m2.getRows() && m1.getColumns() == m2.getColumns()){

        }else{
        return false;
        }

        return true;
    }
    public Matrix addMatrix(Matrix m1, Matrix m2){
        boolean check = sameSizeMatrix(m1, m2);
        int[][] arr1 = m1.getMatrix();
        int[][] arr2 = m2.getMatrix();
        Matrix m3;
        if(check == true){
            int rows = m1.getRows();
            int columns = m2.getColumns();
            int[][] sum = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < columns; k++) {
                    sum[i][k] = arr1[i][k] + arr2[i][k];
                }
            }
            m3 = new Matrix(sum);
            return m3;
        } else{
            return null;
        }
    }
    public Matrix subtractMatrix(Matrix m1, Matrix m2){
        boolean check = sameSizeMatrix(m1, m2);
        int[][] arr1 = m1.getMatrix();
        int[][] arr2 = m2.getMatrix();
        Matrix m3;
        if(check == true){
            int rows = m1.getRows();
            int columns = m2.getColumns();
            int[][] sum = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < columns; k++) {
                    sum[i][k] = arr1[i][k] - arr2[i][k];
                }
            }
            m3 = new Matrix(sum);
            return m3;
        } else{
            return null;
        }

    }
    public Matrix transposeMatrix(Matrix m1){
        int[][] arr1 = m1.getMatrix();
        Matrix m3;
        if(m1 != null) {
            int rows = m1.getRows();
            int columns = m1.getColumns();
            int[][] transpose = new int[columns][rows];
            int add;
            for (int c = 0; c < columns; c++) {
                for (int d = 0; d < rows; d++) {
                    add = arr1[d][c];
                    transpose[c][d] = add;
                }
            }
            m3 = new Matrix(transpose);
            return m3;
        } else{
            return null;
        }
    }
    public Matrix productMatrix(Matrix m1, Matrix m2){
        int[][] arr1 = m1.getMatrix();
        int[][] arr2 = m2.getMatrix();
        Matrix m3;
        if(m1.getColumns() == m2.getRows()) {
            int rows1 = m1.getRows();
            int rows2 = m2.getRows();
            int columns1 = m1.getColumns();
            int columns2 = m2.getColumns();
            int[][] product = new int[rows1][columns2];
            int[][] sum = new int[rows1][columns2];
            int rows = product.length;
            int columns = product[0].length;
            int add;
            for (int c = 0; c < rows; c++) {
                for (int d = 0; d < columns; d++) {
                    add = 0;
                    for(int i = 0; i < rows2; i++){
                        add = add + arr1[c][i] * arr2[i][d];
                        product[c][d] = add;
                    }
                }
            }
            m3 = new Matrix(product);
            return m3;
        } else{
            return null;
        }
    }
    public void printMatrix(Matrix m1){
        if (m1 == null){
            return;
        } else {
            int[][] arr1 = m1.getMatrix();
            int rows = m1.getRows();
            int columns = m1.getColumns();
            for (int i = 0; i < rows; i++) {
                for (int k = 0; k < columns; k++) {
                   System.out.println(arr1[i][k] + " ");
                }
            }
            return;
        }

    }
}
