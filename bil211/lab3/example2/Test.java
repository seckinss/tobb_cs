import java.io.IOException;

public class Test {
    public static void main(String args[]) throws IOException {
        Ngram n=new Ngram();
        n.extractNgrams("input.txt", "output.txt", new int[]{1, 2});
    }
}
