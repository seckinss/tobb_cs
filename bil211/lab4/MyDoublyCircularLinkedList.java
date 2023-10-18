import java.util.HashMap;

public class MyDoublyCircularLinkedList<T extends Comparable<T>>
{
    public MyDoublyCircularLinkedList(){
        size=0;
        head=null;
    }
    public class MyNode{
        T data;
        MyNode nextNode;
        MyNode prevNode;
        public MyNode(T data) {
            this.data=data;
            nextNode=null;
            prevNode=null;
        }
    }
    public int size; //ilk değeri 0
    private MyNode head; //ilk değeri null
    private MyNode tail;
    public void insert(int index,T data){
        if(index<=0||index>size+1){
            System.out.println("insert failed");
            return;
        }
        MyNode newNode= new MyNode(data);
        if(size==0){
            head=newNode;
            tail=newNode;
            head.prevNode=tail;
            head.nextNode=tail;
        }
        else{
            if(index==1){
                newNode.nextNode=head;
                newNode.prevNode=tail;
                head.prevNode=newNode;
                tail.nextNode=newNode;
                head=newNode;
            }
            else
                if(index==size+1){
                    newNode.nextNode = head;
                    newNode.prevNode = tail;
                    head.prevNode = newNode;
                    tail.nextNode = newNode;
                    tail = newNode;
                }
                else{
                    MyNode curNode=head;
                    for (int i = 1; i < index-1; i++) {
                        curNode=curNode.nextNode;
                    }
                    // newNode.nextNode=curNode.nextNode;
                    // newNode.prevNode=curNode;
                    // curNode.nextNode.prevNode=newNode;
                    // curNode.nextNode=newNode;
                    newNode.nextNode=curNode.nextNode;
                    newNode.nextNode.prevNode=newNode;
                    newNode.prevNode=curNode;
                    curNode.nextNode=newNode; // i wanted to solve this problem in two way, both correct.
                }
            
        }
        size=size+1;
    }
    public void reverseInsert(int index, T data){
        if(index<=0||index>size+1){
            System.out.println("reserve insert failed");
            return;
        }
        insert(size+2-index,data);
    }
    public void remove(int index){
        if(index<=0||index>size){
            System.out.println("remove failed");
            return;
        }
        MyNode rNode=null;
        if(size==1){
            rNode=head;
            head=null;
            tail=null;
        }
        else{
            if(index==1){
                rNode=head;
                head=rNode.nextNode;
                head.prevNode=tail;
                tail.nextNode=head;
            }
            if(index==size){
                rNode=tail;
                tail=rNode.prevNode;
                tail.nextNode=head;
                head.prevNode=tail;
            }
            if(index<size&&index>1){
                MyNode curNode=head;
                for (int i = 1; i < index-1; i++) {
                    curNode=curNode.nextNode;
                }
                curNode.nextNode=curNode.nextNode.nextNode;
                curNode.nextNode.prevNode=curNode;
            }
        }
            size=size-1;
    }
    public void reverseRemove(int index){
        if(index<=0||index>size){
            System.out.println("reserveRemove failed");
            return;
        }
        remove(size+1-index);
    }
    public void search(T d){
        MyNode curNode=head;
        for (int i = 1; i <= size; i++) {
            if(curNode.data.equals(d)){
                System.out.println(i);
                return;
            }
            curNode=curNode.nextNode;
        }
        System.out.println("search failed");
    }
    public void print(int index){
       MyNode curNode=head;
        if(index>size||index<1){
            System.out.println("print failed");
            return;
        }
        for (int i = 1; i < index; i++) {
            curNode=curNode.nextNode;
        }
        System.out.println(curNode.data);
    }
    public void printAll(){
        if(size==0){
            System.out.println("printAll failed");
            return;
        }
        MyNode curNode=head;
        for (int i = 1; i <size; i++) {
            System.out.print(curNode.data+", ");
            curNode=curNode.nextNode;
        }
        System.out.println(curNode.data);
    }
    public void reversePrintAll(){
        if(size==0){
            System.out.println("reservePrintAll failed");
            return;
        }
        MyNode curNode=tail;
        for (int i = 1; i <size; i++) {
            System.out.print(curNode.data+", ");
            curNode=curNode.prevNode;
        }
        System.out.println(curNode.data);
    
    }
    public HashMap<Integer,T> ToHashMap(){
        if(size==0){
            System.out.println("ToHashMap failed");
            return null;
        }
        HashMap<Integer,T> map =new HashMap<>();
        MyNode curNode=head;
        for (int i = 1; i < size; i++) {
            map.put(i,curNode.data);
                curNode=curNode.nextNode;
        }
        return map;
    }
    public void fromHashMap(HashMap<Integer,T> map){
        head=null;
        tail=null;
        size=0;
        for (T val : map.values()) {
            insert(size+1,val);
        }
        printAll();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
    }
    public T findMin(){
        if(size==0){
            System.out.println("There is no min node");
            return null;
        }
        T minT;
        MyNode curNode=head;
        minT=curNode.data;
        for (int i = 1; i <size; i++) {
            curNode=curNode.nextNode;
            if(minT.compareTo(curNode.data)>0)
                minT=curNode.data;
        }
        return minT;
    }
    public T findMax(){
       if(size==0){
            System.out.println("There is no min node");
            return null;
        }
        T maxT;
        MyNode curNode=head;
        maxT=curNode.data;
        for (int i = 1; i <size; i++) {
            curNode=curNode.nextNode;
            if(maxT.compareTo(curNode.data)<0)
                maxT=curNode.data;
        }
        return maxT;
    }
}

