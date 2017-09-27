public class MatrixResource {

    private int line;
    private int column;

    MatrixResource(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int[][] matrixBuild() {
        int elem = 0;
        int[][] matrix = new int[line][column];
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = elem;
                elem++;
            }
        }
        return matrix;
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < this.line; i++) {
            for (int j = 0; j < this.column; j++) {
                System.out.format("%6d", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
