import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MultiplicationMatrixWithCallable {
    private int[][] matrix1;
    private int[][] matrix2;

    MultiplicationMatrixWithCallable(int[][] matrix1, int[][] matrix2) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    int[][] mulMatrix() throws Exception {
        int[][] mulResult = new int[matrix1.length][matrix2[0].length];
        int[] lineMatrix1 = new int[matrix1[0].length];
        int[] columnMatrix2 = new int[matrix1[0].length];
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future> results = new ArrayList<>();
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int r = 0; r < matrix1[0].length; r++) {
                    lineMatrix1[r] = matrix1[i][r];
                    columnMatrix2[r] = matrix2[r][j];
                }
                MulCallable elemMatrix = new MulCallable(lineMatrix1, columnMatrix2);
                Future result = service.submit(elemMatrix);
                results.add(result);
                mulResult[i][j] = (int) result.get();
            }
        }

        for (Future result : results) {
            result.get();
        }

        service.shutdown();

        return mulResult;
    }
}