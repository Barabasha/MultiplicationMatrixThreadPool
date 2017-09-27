class MultiplicationMatrix {
    private int matrixLength1;
    private int matrixHeight1;
    private int matrixLength2;

    MultiplicationMatrix(int matrixLength1, int matrixHeight1, int matrixLength2) {
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

        int[][] matrix3 = new int[matrixLength1][matrixLength2];

        for (int i = 0; i < matrixLength1; i++) {
            for (int j = 0; j < matrixLength2; j++) {
                for (int r = 0; r < matrixHeight1; r++) {
                    matrix3[i][j] += matrix1[i][r] * matrix2[r][j];
                }
            }
        }
        return matrix3;
    }
}
