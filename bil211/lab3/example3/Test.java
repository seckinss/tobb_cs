import java.io.IOException;

public class Test {
    public static void main(String args[]) throws IOException {
        Ngram g=new Ngram();
        g.extractNgrams("input.txt", "output.txt", new int[]{3, 5, 10});
        
    }
}
