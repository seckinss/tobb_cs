import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String args[]) {
        ArrayList<Integer> a =new ArrayList<>();
        int[] k=new int[100000];
        for (int i = 0; i < k.length; i++) {
            a.add(i);
            k[i]=i;
        }
        long l=System.nanoTime();
        int z=k[k.length-1];
        System.out.println(System.nanoTime()-l);
        l=System.nanoTime();
        a.get(k.length-1);
        System.out.println(System.nanoTime()-l);
    }
}
