import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Test1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the list of numbers separated by space: ");
        String input = scanner.nextLine();

        String[] inputArray = input.split("\\s+");
        List<Integer> randomList = new ArrayList<>();
        for (String str : inputArray) {
            int number = Integer.parseInt(str);
            randomList.add(number);
        }

      Predicate<Integer> isOdd = (num) -> num%2==1;
      List<Integer> OddNumbers = randomList.parallelStream().filter(isOdd).toList();
// Predicate isOdd ve lambda ifadeleri kullanılarak listeyi yalnızca çift sayıları tutacak şekilde filtreler. Veriler liste yapısında toplanır.                         

      Function<Integer, Integer> cube = (a)-> a*a*a;
// // verilen integer a sayısının küpünü döner
      List<Integer> cubes = randomList.parallelStream().map(cube).toList();
// // Listedeki her sayı, Function cube ve lambda ifadeleri kullanılarak Küpü ile eşlenir (map edilir). Veriler liste yapısında toplanır.
      Comparator<Integer> ascendingOrder  = (a,b) -> a.compareTo(b);
// //Verilen a ve b sayısı compareTo metodu kullanılarak kıyaslanır
      List<Integer> A_sortedList = randomList.parallelStream().sorted(ascendingOrder).toList();
// // Liste artan sırayla tekrar sıralanır. Veriler Liste yapısında toplanır.

      Comparator<Integer> minNumber = (a,b) -> a.compareTo(b);
// //Verilen a ve b sayısı compareTo metodu kullanılarak kıyaslanır
      int min = randomList.parallelStream().min(minNumber).get();
// // Liste içerisindeki minimum değer belirlenir.
        
      double average =randomList.parallelStream().mapToInt(Integer::intValue).average().getAsDouble();

// //liste içerisindeki değerler integer'a çevrilir ve değerlerin ortalaması hesaplanır (Hint: mapToInt(Integer::intValue))

        System.out.println("Random list: " + randomList);
        System.out.println("Odd numbers: " + OddNumbers);
        System.out.println("Cubes: " + cubes);
        
        
        System.out.println("Sorted list Ascending: " + A_sortedList);

        System.out.println("Min number: " + min);
        System.out.println("Average: " + average);
    }
}















