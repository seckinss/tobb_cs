import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

public class Test2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of list: ");
        int N = scanner.nextInt();
        Random random = new Random();
        List<Integer> list = random.ints(N, 1, 100).boxed().collect(Collectors.toList());

        System.out.println("List: " + list);
        System.out.print("Enter the Number of Threads: ");
        int numThreads = scanner.nextInt();
        Thread[] printThreads = createThreadsToPrintSorted(list, numThreads);
        for (int i = 0; i < numThreads; i++) {
            try {
               printThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } 
        }  
    }
    private static Thread[] createThreadsToPrintSorted(List<Integer> list, int numThreads) 
    {
        Thread[] threads=new Thread[numThreads];
        class CustomThread extends Thread{
            ArrayList<Integer> intList=new ArrayList<>();
            static int index=0;
            static int threadc=0;
            int threadNum=0;
            CustomThread(){
                for (int j = 0; j < list.size()/numThreads; j++) {
                    intList.add(list.get(index));
                    index++;
                }
                threadNum=threadc;
                threadc++;
                notif
            }
            @Override
            public void run() {
                int sum = intList.parallelStream().mapToInt(Integer::intValue).sum();
                System.out.println("Thread "+ threadNum + " printing chunk of sorted list: "+intList + " Sum: "+ sum);
            }
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new CustomThread();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        pr
        /*
      numThread paremetresinde belirtilen sayı kadar Thread oluşturulur. 
      Her bir thread thread numarasını, (liste büyüklüğü / thread sayısı) 
büyüklüğündeki liste parçalarındaki elemanları ve bu elemanların toplamını
ekrana bastırır. 
      Her bir thread bu fonksiyon içerisinde başlatılır. Fonksiyon oluşturulan 
threadleri bir thread dizisi halinde döner.    

        ****liste büyüklüğü thread sayısına tam bölünen bir sayı olacaktır.
        ****Elemanların toplamı için lambda işlemi kullanmanız beklenmektedir.
        ****main thread'i, devam etmeden önce tüm iş parçacıkları bitene 
      kadar beklemelidir.  
        */
        return threads;
    } 
}
