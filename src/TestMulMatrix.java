import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestMulMatrix {

    @Test (expected = Exception.class)
    public void testEmpty() throws Exception {
        MultiplicationMatrix m1 = new MultiplicationMatrix(0, 0, 0);
        MultiplicationMatrixThreadPool m2 = new MultiplicationMatrixThreadPool(0, 0, 0);
        int[][] matrix1 = m1.multiplicationMatrixs();
        int[][] matrix2 = m2.multiplicationMatrixs();
        assertArrayEquals(matrix1, matrix2);
    }

    @Test
    public void testLittleMatrixs() throws Exception {
        long start = System.currentTimeMillis();
        MultiplicationMatrix m1 = new MultiplicationMatrix(2, 3, 4);
        int[][] matrix1 = m1.multiplicationMatrixs();
        long end = System.currentTimeMillis();
        MultiplicationMatrixThreadPool m2 = new MultiplicationMatrixThreadPool(2, 3, 4);
        int[][] matrix2 = m2.multiplicationMatrixs();
        long finish = System.currentTimeMillis();
        System.out.println("Time for little matrixs");
        System.out.println("Multiplication with one thread: "+ (end-start));
        System.out.println("Multiplication with multi-threads: "+ (finish - end));
        System.out.println();
        assertArrayEquals(matrix1, matrix2);
    }

    @Test
    public void testMediumMatrixs() throws Exception {
        long start = System.currentTimeMillis();
        MultiplicationMatrix m1 = new MultiplicationMatrix(100, 150, 200);
        int[][] matrix1 = m1.multiplicationMatrixs();
        long end = System.currentTimeMillis();
        MultiplicationMatrixThreadPool m2 = new MultiplicationMatrixThreadPool(100, 150, 200);
        int[][] matrix2 = m2.multiplicationMatrixs();
        long finish = System.currentTimeMillis();
        System.out.println("Time for medium matrixs");
        System.out.println("Multiplication with one thread: "+ (end-start));
        System.out.println("Multiplication with multi-threads: "+ (finish - end));
        System.out.println();
        assertArrayEquals(matrix1, matrix2);
    }

    @Test
    public void testLargeMatrixs() throws Exception {
        long start = System.currentTimeMillis();
        MultiplicationMatrix m1 = new MultiplicationMatrix(1000, 1500, 2000);
        int[][] matrix1 = m1.multiplicationMatrixs();
        long end = System.currentTimeMillis();
        MultiplicationMatrixThreadPool m2 = new MultiplicationMatrixThreadPool(1000, 1500, 2000);
        int[][] matrix2 = m2.multiplicationMatrixs();
        long finish = System.currentTimeMillis();
        System.out.println("Time for large matrixs");
        System.out.println("Multiplication with one thread: "+ (end-start));
        System.out.println("Multiplication with multi-threads: "+ (finish - end));
        System.out.println();
        assertArrayEquals(matrix1, matrix2);
    }
}
