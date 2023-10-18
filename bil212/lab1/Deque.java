
public class Deque<T> {
    private MyStack<Integer> mainStack;
    private MyStack<Integer> tempStack;

    public Deque() {
        mainStack = new MyStack<>(100);
        tempStack = new MyStack<>(100);
    }

    public void addFirst(int i) {  // It can only take integer value due to Driver.java file,
        mainStack.push(i);      // To be generic, Driver.java:7 should be changed to " Deque<Integer> u = new Deque<Integer>(); "
    }

    public void addLast(int i) {
        while(!mainStack.empty()){
            tempStack.push(mainStack.pop());
        }
        tempStack.push(i);
        while(!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }
    }

    public int size() {
        return mainStack.capacity();
    }

    public int first() {
        return mainStack.peek();
    }

    public int last() {
        while(!mainStack.empty())
            tempStack.push(mainStack.pop());
        int last=tempStack.peek();
        while(!tempStack.empty())
            mainStack.push(tempStack.pop());
        return last;
    }

    public void removeFirst() {
        mainStack.pop();
    }

    public void removeLast() {
        while(!mainStack.empty())
            tempStack.push(mainStack.pop());
        tempStack.pop();
        while(!tempStack.empty())
            mainStack.push(tempStack.pop());
    }

    public boolean isEmpty() {
        return mainStack.empty();
    }

    public void reverse() { 
        MyStack<Integer> tempStack2=new MyStack<Integer>(100);
        while(!mainStack.empty()){
            tempStack.push(mainStack.pop());
        }
        while(!tempStack.empty()){
            tempStack2.push(tempStack.pop());
        }
        while(!tempStack2.empty()){
            mainStack.push(tempStack2.pop());
        }
    }

    public String toString() {
        String rString="";
        while(!mainStack.empty()){
            int value=mainStack.pop();
            rString+=value+", ";
            tempStack.push(value);
        }
        while(!tempStack.empty()){
            mainStack.push(tempStack.pop());
        }
        if(rString.length()>2)
            return rString.substring(0, rString.length()-2);
        else
            return "Deque is empty";
    }


    public class MyStack<T>{
        private int t;
        private Object[] arr;
        private int size;
    
        MyStack(int size){
            this.size=size; // size of stack array
            arr=new Object[this.size];
            t=-1;
        }
    
        int capacity(){
            return t+1; // number of data in stack
        }
    
        boolean empty(){
            if(t==-1)
                return true;
            return false;
            
        }
    
        T peek(){
            if(!empty())
                return (T) arr[t];
            return null; // If stack empty returns null //
        }
        void push(T element){
            if(t==arr.length-1)
                return;
            else
                arr[++t] = element;
        }
        T pop(){
            if(empty()){
                return null; // If stack empty pops null //
            }
            else
                return (T) arr[t--];
        }
    }
    
}
