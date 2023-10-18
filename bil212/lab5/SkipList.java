


/**
 * SkipList
 */
public class SkipList {

    private final double PROB=0.5;
    private Node head;
    private int level;
    private int size;


    class Node{
        Node[] nextNodes;
        int key;
        String val;
        public Node(Integer key,String value, Integer level) {
            this.val = value;
            this.key=key;
            nextNodes = new Node[level];
        }
    }
    
    SkipList(){
        level=1;
        size=0;
        head=new Node(Integer.MIN_VALUE,"-inf",20);
    }
    public int size(){
        return size;
    }
    public Node skipSearch(Integer key){
        Node curNode=head;
        int k=0;
        for (int i = level - 1; i>=0; i--) {
            while (curNode.nextNodes[i] != null && curNode.nextNodes[i].key< key) {
                curNode = curNode.nextNodes[i];
                k++;
            }
        }
        System.out.println("Yatayda "+k+ " düğüm geçildi.");
        if(curNode.nextNodes[0]!=null && curNode.nextNodes[0].key<=key) {
            return curNode.nextNodes[0];
        } else {
            return curNode;
        }
    }
    public void insertNode(Integer key, String value){
        
        Node[] n=new Node[20];
        Node cur=head;
        for (int i=level-1; i >= 0; i--) {
            while (cur.nextNodes[i] != null && cur.nextNodes[i].key< key) {
                cur = cur.nextNodes[i];
            }
            n[i] = cur;
        }
        if(cur.nextNodes[0]!=null && cur.nextNodes[0].key<=key) { // Varolan key değerine sahip bir ekleme işlemi yapılacağında bütün value lar yenisi ile değişmelidir.
            cur.nextNodes[0].val=value;                          // skipSearch ile de yapılabilir fakat print methodunun insertNode'de çalışması mantıksız olurdu.
            return;
        }


        int newLevel=1;
        while(newLevel<20 && Math.random()<PROB) { // 1/2^20 yaklaşık 10^-6 eğer 20 den fazla çıkarsa newLevel = 19 yani 20. seviyede oluyor. 
            newLevel++;
        }
        Node node1=new Node(key, value, newLevel);
        if(newLevel>level) {
            for (int i = level; i < newLevel; i++) {
                n[i] = head;
            }
            level = newLevel;
        }
        for (int i = 0; i < newLevel; i++) {
            node1.nextNodes[i] = n[i].nextNodes[i];
            n[i].nextNodes[i] = node1;
        }
    
        size++;
    }
    public void remove(Integer key){
        Node[] nNode=new Node[20];
        Node cur=head;
        for(int i=level-1;i >= 0;i--) {
            while(cur.nextNodes[i] !=null &&cur.nextNodes[i].key<key) {
                cur= cur.nextNodes[i];
            }
            nNode[i]= cur;
        }
        cur=cur.nextNodes[0];
        if(cur!=null && cur.key==key){
            for (int i = 0; i < level; i++) {
                if(nNode[i].nextNodes[i]!=cur)
                    break;
                nNode[i].nextNodes[i]=cur.nextNodes[i];

            }
            while(level>1 && head.nextNodes[level-1] == null)
                level--;


            size--;
        }
    }
    @Override
    public String toString() {
        if(size==0){
            return "[]";
        }
        String lines ="";
        for (int i = level - 1; i >= 0; i--) {
            String line ="[";
            Node current = head.nextNodes[i];
            Node currentBelow = head.nextNodes[0];
            while (currentBelow != null) {
                if (current != null && current.key==currentBelow.key) {
                    line=line + "("+ current.key + ", " + current.val +")   " ;
                    current = current.nextNodes[i];
                } else {
                    String k=currentBelow.key+currentBelow.val;
                    for (int j = 0; j < k.length()+7; j++) {
                        line= line+" ";
                    }
                }
                currentBelow = currentBelow.nextNodes[0];
                
            }
            line=line.substring(0, line.length()-3);
            line = line +"]";
            lines= lines + line +"\n";
        }
        return lines.substring(0, lines.length()-1).toString();
    }
    public static void main(String[] args) { 
        SkipList test = new SkipList();
        test.insertNode(30, "A");
        test.insertNode(40, "B");
        test.insertNode(50, "C");
        test.insertNode(60, "D");
        test.insertNode(70, "E");
        test.insertNode(90, "F");
        test.insertNode(100, "G");
        test.insertNode(110, "J");
        test.insertNode(120, "K");
        test.insertNode(130, "N");
        test.insertNode(140, "L");
        test.insertNode(150, "M");
        test.insertNode(20, "O");
        test.insertNode(45, "p");
        System.out.println(test.skipSearch(-2).val);
        System.out.println("Size: " + test.size());
        System.out.println(test);
        System.out.println();
        test.insertNode(45, "C"); // Varolan key değerine sahip bir ekleme işlemi yapılacağında bütün value lar yenisi ile değişmelidir.
        test.remove(90);
        System.out.println(test);

     }
     
}