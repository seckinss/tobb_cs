import java.io.*;
import java.util.Scanner;


public class Game extends AbstractGame implements Serializable{
    boolean isGameActive;
    public Board getBoard(){
        return board;
    }
    Player a;
    Player b;
    Player turn;
    Game(String A,String B){
        isGameActive=true;
        board=new Board();
        a=new Player(A,"Red");
        b=new Player(B,"Black");
        turn=a;
    }
    @Override
    void play(String from, String to) {
        if(isGameActive==false){
            System.out.println("hatali hareket");
            return;
        }
        int k=-1;
        Item playableItem;
        for (int i = 0; i < board.items.length; i++) {
            if(board.items[i].getPosition().equals(from)){
                if(turn.tasrenk.equals(board.items[i].color)){
                    k=i;
                    break;
                }
            }
        }
        if(k==-1){
            System.out.println("hatali hareket");
            return;
        }
        playableItem=board.items[k];
        playableItem.move(to);
        if(turn.equals(a)){
            turn=b;
        }
        else
            turn=a;
        if(playableItem.getPosition().equals(from)){
            System.out.println("hatali hareket");
            if(turn.equals(a)){
                turn=b;
            }
            else
                turn=a;
        }
        puanHesapla(a);
        puanHesapla(b);
        if(playableItem.isCheck())
            if(playableItem.isCheckMate()){
                isGameActive=false;
                if(turn.equals(a)) 
                    System.out.println("ŞAH MAT! "+ b + " oyunu kazandı. "+ b +"'in puanı: "+b.puan +", "+ a +"'nin puanı: "+a.puan);
                else
                    System.out.println("ŞAH MAT! "+ a + " oyunu kazandı. "+ a +"'in puanı: "+a.puan +", "+ b +"'nin puanı: "+b.puan);
            }
        
    }

    @Override
    void save_binary(String address) {
        ObjectOutputStream k=null;
        try {
            k=new ObjectOutputStream(new FileOutputStream(address));
            k.writeObject(isGameActive);
            k.writeObject(board);
            for (int i = 0; i < board.items.length; i++) {
                k.writeObject(board.items[i]);
                k.writeUTF(board.items[i].getPosition());
            }
            k.writeObject(a);
            k.writeObject(b);
            k.writeObject(turn);
            k.close();
        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    void save_text(String address) {
        PrintWriter out=null;
        try {
            out = new PrintWriter(new FileOutputStream(address));
        } catch (FileNotFoundException e) {
        }
        out.println(isGameActive);
        for (int i = 0; i < board.items.length; i++) {
            if(i==31){
                out.print(board.items[i].getPosition());
            }
            else{
                out.print(board.items[i].getPosition()+"|");
            }
        }
        out.println();
        out.println(a.isim+","+a.tasrenk+","+a.puan);
        out.println(b.isim+","+b.tasrenk+","+b.puan);
        out.println(turn.isim+","+turn.tasrenk+","+turn.puan);
        out.close();
    }

    @Override
    void load_text(String address) {
        Scanner s=null;
        try {
            s=new Scanner(new File(address));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        isGameActive=Boolean.parseBoolean(s.nextLine());
        String arraydefine=s.nextLine();
        String[] arrposes= arraydefine.split("[|]");
        for (int i = 0; i <board.items.length; i++) {
            if(arrposes[i].equals("xx")){
                board.items[i].isAlive=false;
                board.items[i].setPosition(arrposes[i]);
            }
            else{
                board.items[i].isAlive=true;
                board.items[i].setPosition(arrposes[i]);
            }
        }
        String[] item1= s.nextLine().split("[,]");
        a.isim=item1[0];
        a.tasrenk=item1[1];
        a.puan=Float.parseFloat(item1[2]);
        String[] item2= s.nextLine().split("[,]");
        b.isim=item2[0];
        b.tasrenk=item2[1];
        b.puan=Float.parseFloat(item2[2]);
        String[] item3= s.nextLine().split("[,]");
        turn.isim=item3[0];
        turn.tasrenk=item3[1];
        turn.puan=Float.parseFloat(item3[2]);
        if(turn.tasrenk.equals(b.tasrenk))
            turn=b;
        else
            turn=a;
    }
    @Override
    void load_binary(String address) {
        ObjectInputStream k=null;
        try {
            k=new ObjectInputStream(new FileInputStream(address));
            isGameActive=((Boolean)k.readObject());
            int x=board.items[0].itemNum;
            board=((Board)k.readObject());
            for (int i = 0; i < board.items.length; i++) {
                board.items[i]=((Item)k.readObject());
                board.items[i].setPosition(k.readUTF());
                Item.arr[x+i]=board.items[i];
                board.items[i].itemNum=x+1;
            }
            a=((Player)k.readObject());
            b=((Player)k.readObject());
            turn=((Player)k.readObject());
            if(turn.tasrenk.equals(b.tasrenk))
                turn=b;
            else
                turn=a;

        } catch (FileNotFoundException e) {
            System.out.println("hatali hareket");
        } catch (IOException e) {
            System.out.println("hatali hareket");
        } catch (ClassNotFoundException e) {
            System.out.println("hatali hareket");
        }
    }
    
    public void puanHesapla(Player p){
        p.puan=0;
        for (int i = 0; i < board.items.length; i++) {
            if(!board.items[i].color.equals(p.tasrenk))
                if(!board.items[i].isAlive)
                    p.puan+=board.items[i].pointVal;
        }
    }
}