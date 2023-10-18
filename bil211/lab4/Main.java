import java.util.HashMap;

public class Main{
    public static void main(String[] args){
        MyDoublyCircularLinkedList<Student> mylist = new
        MyDoublyCircularLinkedList<Student>();
        Student s1 = new Student("1",60);
        Student s2 = new Student("2",70);
        Student s3 = new Student("3",80);
        Student s4 = new Student("4",60);
        Student s5 = new Student("5",40);
        Student s6 = new Student("6",95);
        Student s7 = new Student("999",90);
        Student s8 = new Student("7",45);
        mylist.insert(1, s1); //1
        mylist.insert(2, s2); //1 2
        mylist.insert(3, s3); //1 2 3
        mylist.insert(4, s4); //1 2 3 4
        mylist.reverseInsert(1, s5); //1 2 3 4 5
        mylist.reverseInsert(1, s6); //1 2 3 4 5 6
        //test 1
        System.out.println("-------------------");
        mylist.printAll(); //1 2 3 4 5 6
        System.out.println("-------------------");
        //test 2
        mylist.remove(1); //2 3 4 5 6
        mylist.reverseRemove(2); //2 3 4 6
        mylist.insert(1, s7); //999 2 3 4 6
        System.out.println("*********************");
        mylist.printAll(); //999 2 3 4 6
        mylist.reversePrintAll(); //6 4 3 2 999
        mylist.search(s4); //4
        mylist.print(2); //2
        System.out.println("*********************");
        System.out.println( "Max: "+mylist.findMax());
        System.out.println("Min: "+mylist.findMin());
        System.out.println(mylist.ToHashMap());
        HashMap<Integer, Student> map = new HashMap<>();
        map.put(1,s4);
        map.put(2,s3);
        map.put(3,s1);
        mylist.fromHashMap(map);
        //test 3
        System.out.println("+++++++++++++");
        mylist.remove(7); //remove failed
        mylist.remove(1); //2 3 4 6
        mylist.insert(9, s8); //insert failed
        mylist.print(1);
        mylist.reverseRemove(-1); //reverseRemove failed
        mylist.search(s5); //search failed
        mylist.print(5); //print failed
        mylist.printAll(); //1 2 3 4 5 6
        System.out.println("+++++++++++++");
        }
    }
