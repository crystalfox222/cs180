import java.util.Scanner;

public class Matrix {

    protected int[][] matrix;
    private int columns;
    private int rows;
    Scanner scan = new Scanner(System.in);

    public Matrix(int[][] m){
        this.matrix = m;
        this.rows = this.matrix.length;
        this.columns = this.matrix[0].length;
    }
    public int setRows(){
        this.rows = this.matrix.length;
        return rows;
    }
    public int setColumns(){
        this.columns = this.matrix[0].length;
        return columns;
    }
    public int getRows(){
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getMatrix() {
        return matrix;
    }
}
