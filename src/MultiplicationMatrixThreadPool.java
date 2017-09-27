class MultiplicationMatrixThreadPool {
    private int matrixLength1;
    private int matrixHeight1;
    private int matrixLength2;

    MultiplicationMatrixThreadPool(int matrixLength1, int matrixHeight1, int matrixLength2) {
        this.matrixLength1 = matrixLength1;
        this.matrixHeight1 = matrixHeight1;
        this.matrixLength2 = matrixLength2;
    }

    int[][] multiplicationMatrixs() throws Exception {

        if (matrixLength1 == 0 | matrixHeight1 == 0 | matrixLength2 == 0) {
            throw new Exception("Matrix is empty");
        }

        int[][] matrix1;
        MatrixResource mr1 = new MatrixResource(matrixLength1, matrixHeight1);
        matrix1 = mr1.matrixBuild();

        int[][] matrix2;
        MatrixResource mr2 = new MatrixResource(matrixHeight1, matrixLength2);
        matrix2 = mr2.matrixBuild();

        MultiplicationMatrixWithCallable matrix3 = new MultiplicationMatrixWithCallable(matrix1, matrix2);

        return matrix3.mulMatrix();
    }
}
