
import java.util.LinkedList;



/**
 * hashTable
 */
public class hashTable<K,V> {

    private int capacity;
    private int size;
    public LinkedList<HashNode>[] arr;
    private class HashNode{
        K key;
        V value;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }


    public hashTable() {
        capacity=11;
        arr = (LinkedList<HashNode>[])new LinkedList[capacity];
        size=0;
    }


    public boolean contains(V value){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null){
                for (HashNode hNode : arr[i]) {
                    if(hNode.value.equals(value))
                        return true;
                }
            }
        }
        return false;
    }


    public boolean containsKey(K key){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=null){
                for (HashNode hNode : arr[i]) {
                    if(hNode.key.equals(key))
                        return true;
                }
            }
        }
        return false;
    }

    public int size(){return size;}


    public V get(K key){
        if(arr[hashValue(key)]==null)
            return null;
        for (HashNode hNode : arr[hashValue(key)]){
            if(hNode.key.equals(key)){
                return hNode.value;
            }
        }
        return null;
    }


    public V remove(K key){
        V val=null;
        if(arr[hashValue(key)]==null)
            return null;
        for (HashNode hNode : arr[hashValue(key)]){
            if(hNode.key.equals(key)){
                val = hNode.value;
                arr[hashValue(key)].remove(hNode);
                size--;
            }
        }
        return val;
    }


    public V put(K key, V value){
        if(get(key)!=null){
            return get(key);
        }
        if(((double)size())/capacity >= 0.6)
            resize();
        
        if(arr[hashValue(key)]==null)
            arr[hashValue(key)]= new LinkedList<HashNode>();


        HashNode k=new HashNode(key, value);
        arr[hashValue(key)].add(k);
        size++;
        return null;
    }


    public int hashCode(K key){
        String k=key.toString();
        return (k.charAt(3)-48) + ((k.charAt(2)-48)*2) + ((k.charAt(1)-48)*3) + ((k.charAt(0)-48)*4);
    }

    public int hashValue(K key){return hashCode(key)%capacity;}


    public void resize(){
        int newC=(int) Math.floor(1.5*capacity);
        LinkedList<HashNode>[] nArr=(LinkedList<HashNode>[])new LinkedList[newC];
        for (int i = 0; i < arr.length; i++) {
            nArr[i]=arr[i];
        }
        capacity=newC;
        arr=nArr;
    }

    @Override
    public String toString() {
        String retS=""; 
        for (int i = 0; i < arr.length; i++) { // Array contains a special linked list for each index. Linked Lists contains a HashNode object in each filled spot. 
            if(arr[i]==null)                  // If the hashnode's key is not in the array, we add the appropriate linked list according to hashnode's key.
                continue;                    //  Formula is arr[hashCode(key)%capacity].
            for (HashNode hNode : arr[i]) { //  In toString() method we add the values ​​of the hashNode in the linked list in each index of the array to retS and finally return it.
                retS=retS + hNode.value + ", "; // arr[i] might not be initialized so we have to check whether is null or not

            }
            retS=retS.substring(0, retS.length()-2);
            retS=retS+ "\n";
        }
        return retS.substring(0, retS.length()-1);
    }

    public static void main(String[] args) {
        hashTable<Integer,String> nTable=new hashTable<>();
        nTable.put(1007,"0"); //4+7 = 11%11=0
        nTable.put(1050,"1");
        nTable.put(1051,"2");
        System.out.println("İlk hal: \n"+nTable);
        System.out.println("----------------------");
        nTable.put(1007,"01"); // It won't add
        System.out.println("Aynı key değerinin eklenmesi: \n" +nTable); 
        System.out.println("----------------------");
        nTable.put(2003,"01");
        nTable.put(1201,"02");
        System.out.println("HashValue(key) değerleri aynı olanların eklenmesi: \n" +nTable);
        System.out.println("----------------------");
        System.out.println("Contains 02 key: " + nTable.contains("02"));
        System.out.println("Contains 03 key: " + nTable.contains("03"));
        System.out.println("----------------------");
        nTable.remove(2003);
        System.out.println("Remove 2003 key: \n"+ nTable);
   
    }
}