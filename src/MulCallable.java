import java.util.concurrent.Callable;

public class MulCallable implements Callable<Integer> {
    private int[] line;
    private int[] column;

    MulCallable(int[] line, int[] column) throws Exception {
        this.line = line;
        this.column = column;
    }

    public Integer call() {
        int elem = 0;
        for (int i = 0; i < line.length; i++) {
            elem += line[i] * column[i];
        }
        return elem;
    }
}
