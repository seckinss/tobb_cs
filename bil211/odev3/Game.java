import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import java.util.ArrayList;                                                                                                       

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;

public class Game extends JFrame {
    AirCraft refAirCraft;
    boolean gameAlive=true;
    ArrayList<Items> threadL=new ArrayList<>();
    Game(){
        setTitle("Game");
        setSize(500,500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        JPanel mainp=new JPanel(){
            
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); 

                for (int i = 0; i < threadL.size(); i++) {
                    if(!threadL.get(i).isAlive)
                        continue;
                    if(threadL.get(i) instanceof AirCraft){
                        Rectangle airc=new Rectangle(threadL.get(i).p.x,threadL.get(i).p.y, 10, 10);
                        for (int j = i+1; j < threadL.size(); j++) {
                            if(threadL.get(j).isAlive==false)
                                continue;
                            if(threadL.get(j) instanceof Bullet){
                                Rectangle bulletr= new Rectangle(threadL.get(j).p.x,threadL.get(j).p.y, 5, 5);
                                if(airc.intersects(bulletr)){
                                    if(((Bullet)threadL.get(j)).refItem!=null&&((Bullet)threadL.get(j)).refItem.equals(threadL.get(i)))
                                        continue;
                                    if(((Bullet)threadL.get(j)).bulletColor.getRGB()==Color.BLUE.getRGB()){
                                        threadL.get(i).isAlive=false;
                                        threadL.get(j).isAlive=false;
                                    }
                                    else{
                                        threadL.get(j).isAlive=false;
                                    }
                                }
                            }
                            if(threadL.get(j) instanceof Enemy){
                                Rectangle enemy= new Rectangle(threadL.get(j).p.x,threadL.get(j).p.y, 10, 10);
                                if(airc.intersects(enemy)){
                                    threadL.get(i).isAlive=false;
                                    threadL.get(j).isAlive=false;    
                                }
                            }
                        }
                        g.setColor(Color.RED);
                        g.fillRect(threadL.get(i).p.x, threadL.get(i).p.y, 10, 10);
                    }
                    if(threadL.get(i) instanceof Enemy){
                        Rectangle enemyr=new Rectangle(threadL.get(i).p.x,threadL.get(i).p.y, 10, 10);
                        for (int j = i+1; j < threadL.size(); j++) {
                            if(threadL.get(j).isAlive==false)
                                continue;
                            if(threadL.get(j) instanceof Friend || (threadL.get(j) instanceof Bullet)||threadL.get(j) instanceof AirCraft){
                                if(threadL.get(j) instanceof Bullet){
                                    Rectangle bulletr= new Rectangle(threadL.get(j).p.x,threadL.get(j).p.y, 5, 5);
                                    if(enemyr.intersects(bulletr)){
                                        if(((Bullet)threadL.get(j)).refItem!=null&&((Bullet)threadL.get(j)).refItem.equals(threadL.get(i))){
                                            continue;
                                        }
                                        if(((Bullet)threadL.get(j)).bulletColor.getRGB()==new Color(128,0,128).getRGB()||((Bullet)threadL.get(j)).bulletColor.getRGB()==Color.ORANGE.getRGB()){
                                            threadL.get(i).isAlive=false;
                                            threadL.get(j).isAlive=false;
                                        }
                                        else
                                            threadL.get(j).isAlive=false;
                                    }
                                }
                            }
                                if(threadL.get(j) instanceof Friend || threadL.get(j) instanceof AirCraft){
                                    Rectangle enemy= new Rectangle(threadL.get(j).p.x,threadL.get(j).p.y, 10, 10);
                                    if(enemyr.intersects(enemy)){
                                        threadL.get(i).isAlive=false;
                                        threadL.get(j).isAlive=false;
                                    }
                                }
                        }
                            g.setColor(Color.BLACK);
                            g.fillRect(threadL.get(i).p.x, threadL.get(i).p.y, 10, 10);
                        }
                    if(threadL.get(i) instanceof Friend){
                        Rectangle friendrect=new Rectangle(threadL.get(i).p.x,threadL.get(i).p.y, 10, 10);
                        for (int j = i+1; j < threadL.size(); j++) {
                            if(threadL.get(j).isAlive==false)
                                continue;
                            if(threadL.get(j) instanceof Bullet){
                                if(((Bullet)threadL.get(j)).refItem!=null&&((Bullet)threadL.get(j)).refItem.equals(threadL.get(i)))
                                    continue;
                                Rectangle bulletr= new Rectangle(threadL.get(j).p.x,threadL.get(j).p.y, 5, 5);
                                if(friendrect.intersects(bulletr)){
                                    if(((Bullet)threadL.get(j)).bulletColor.getRGB()==Color.BLUE.getRGB()){
                                        threadL.get(i).isAlive=false;
                                        threadL.get(j).isAlive=false;
                                    }
                                    else
                                        threadL.get(j).isAlive=false;
                                }
                            }
                            if(threadL.get(j) instanceof Enemy){
                                Rectangle enemy= new Rectangle(threadL.get(j).p.x,threadL.get(j).p.y, 10, 10);
                                if(friendrect.intersects(enemy)){
                                    threadL.get(i).isAlive=false;
                                    threadL.get(j).isAlive=false;
                                }
                            }
                        }
                        g.setColor(Color.GREEN);
                        g.fillRect(threadL.get(i).p.x, threadL.get(i).p.y, 10, 10);
                    }
                    if(threadL.get(i) instanceof Bullet){
                        Rectangle bRectangle=new Rectangle(threadL.get(i).p.x,threadL.get(i).p.y, 5, 5);
                        for (int j = i+1; j < threadL.size(); j++) {
                            if(!threadL.get(j).isAlive)
                                continue;
                            
                            if(threadL.get(j) instanceof Bullet){
                                Rectangle bulletr= new Rectangle(threadL.get(j).p.x,threadL.get(j).p.y, 5, 5);
                                if(bRectangle.intersects(bulletr)){
                                    if(!(((Bullet)threadL.get(i)).refItem.equals(((Bullet)threadL.get(j)).refItem))){
                                        threadL.get(i).isAlive=false;
                                        threadL.get(j).isAlive=false;
                                    }
                                }
                            }
                        }
                        g.setColor(((Bullet)threadL.get(i)).bulletColor);
                        g.fillRect(threadL.get(i).p.x, threadL.get(i).p.y, 5, 5);
                    }
                }
                
            }
        };
        addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("klkl");
                if(e.getKeyChar()==119){
                    refAirCraft.p.setLocation(refAirCraft.p.x, refAirCraft.p.y-10);
                    if(refAirCraft.p.y<0)
                        refAirCraft.p.setLocation(refAirCraft.p.x, refAirCraft.p.y+10);
                }
                if(e.getKeyChar()==97){
                    refAirCraft.p.setLocation(refAirCraft.p.x-10, refAirCraft.p.y);
                    if(refAirCraft.p.x<0)
                        refAirCraft.p.setLocation(refAirCraft.p.x+10, refAirCraft.p.y);
                }
                if(e.getKeyChar()==115){
                    refAirCraft.p.setLocation(refAirCraft.p.x, refAirCraft.p.y+10);
                    if(refAirCraft.p.y>=480)
                        refAirCraft.p.setLocation(refAirCraft.p.x, refAirCraft.p.y-10);
                }
                if(e.getKeyChar()==100){
                    refAirCraft.p.setLocation(refAirCraft.p.x+10, refAirCraft.p.y);
                    if(refAirCraft.p.x>490)
                        refAirCraft.p.setLocation(refAirCraft.p.x-10, refAirCraft.p.y);
                }
                repaint();
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Bullet rightBullet=new Bullet(true,refAirCraft.p,Color.ORANGE,refAirCraft);
                Bullet leftBullet=new Bullet(false,refAirCraft.p,Color.ORANGE,refAirCraft);
                rightBullet.start();
                leftBullet.start();
            }
        });
        mainp.setBackground(Color.gray);
        add(mainp,BorderLayout.CENTER);
        setVisible(true);;
    }
    public class Enemy extends Items {
        Enemy(){
            boolean k=true;
            while(k){
                k=false;
                p=new Point((int)(Math.random()*50)*10,(int)(Math.random()*50)*10);
                Rectangle newrec=new Rectangle(p.x,p.y,10,10);
                for (int i = 0; i < threadL.size(); i++) {
                    Rectangle irec=new Rectangle(threadL.get(i).p.x,threadL.get(i).p.y,10,10);
                    if(newrec.intersects(irec))
                        k=k||true;
                }
                if(p.x==250&&p.y==250){
                    k=true;
                }
            }
            threadL.add(this);
        }
        @Override
        public void run() {
            int c=1;
            while(isAlive&&gameAlive){
                int random=(int)(Math.random()*4)+1;
                if(random==1){
                    if(p.x+10>=500)
                        continue;
                    p.move(p.x+10, p.y);
                }
                if(random==2){
                    if(p.x-10<0)
                        continue;
                    p.move(p.x-10, p.y);
                }
                if(random==3){
                    if(p.y+10>=480){
                        continue;
                    }
                    p.move(p.x, p.y+10);
                }
                if(random==4){
                    if(p.y-10<0)
                        continue;
                    p.move(p.x, p.y-10);
                }
                if(c==3){
                    c=1;
                    Bullet rightBullet=new Bullet(true,p,Color.BLUE,this);
                    Bullet leftBullet=new Bullet(false,p,Color.BLUE,this);
                    rightBullet.start();
                    leftBullet.start();
                }
                c++;
                repaint();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public class AirCraft extends Items {
        AirCraft(){
            p=new Point(250,250);
            refAirCraft=this;
            threadL.add(this);
        }
        @Override
        public void run() {
            while(isAlive){
                boolean hasAircraft=true;
                boolean hasEnemy=false;
                for (int j = 0; j < threadL.size(); j++) {
                    if(threadL.get(j) instanceof Enemy){
                        hasEnemy=hasEnemy||threadL.get(j).isAlive;
                    }
                    if(threadL.get(j) instanceof AirCraft){
                        hasAircraft=threadL.get(j).isAlive;
                    }
                }
                if(!hasAircraft){
                    gameAlive=false;
                    JOptionPane.showMessageDialog(null, "Oyunu Kaybettiniz");
                    return;
                }
                if(!hasEnemy){
                    gameAlive=false;
                    JOptionPane.showMessageDialog(null, "Oyunu Kazandınız");
                    return;

                }
            }
        }
    }

    public class Friend extends Items {
        Friend(){
            boolean k=true;
            while(k){
                k=false;
                p=new Point((int)(Math.random()*50)*10,(int)(Math.random()*50)*10);
                Rectangle newrec=new Rectangle(p.x,p.y,10,10);
                for (int i = 0; i < threadL.size(); i++) {
                    Rectangle irec=new Rectangle(threadL.get(i).p.x,threadL.get(i).p.y,10,10);
                    if(newrec.intersects(irec))
                        k=k||true;
                }
                if(p.x==250&&p.y==250){
                    k=true;
                }
            }
            threadL.add(this);
        }
        @Override
        public void run() {
            int c=1;
            while(isAlive&&gameAlive){
                int random=(int)(Math.random()*4)+1;
                if(random==1){
                    if(p.x+10>=500)
                        continue;
                    p.move(p.x+10, p.y);
                }
                if(random==2){
                    if(p.x-10<0)
                        continue;
                    p.move(p.x-10, p.y);
                }
                if(random==3){
                    if(p.y+10>=480){
                        continue;
                    }
                    p.move(p.x, p.y+10);
                }
                if(random==4){
                    if(p.y-10<0)
                        continue;
                    p.move(p.x, p.y-10);
                }
                if(c==3){
                    c=1;
                    Bullet rightBullet=new Bullet(true,p,new Color(128,0,128),this);
                    Bullet leftBullet=new Bullet(false,p,new Color(128,0,128),this);
                    rightBullet.start();
                    leftBullet.start();
                }
                c++;
                repaint();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public class Items extends Thread{
        boolean isAlive=true;
        Point p;
    }
    public class Bullet extends Items{
        boolean rightBullet;
        Color bulletColor;
        Items refItem;
        Bullet(boolean b,Point startPoint,Color c,Items i){
            p=new Point((int)(Math.random()*50)*10,(int)(Math.random()*50)*10);
            while(p.x==250&&p.y==250){
                p=new Point((int)(Math.random()*50)*10,(int)(Math.random()*50)*10);
            }
            threadL.add(this);
            rightBullet=b;
            p=new Point(startPoint.x+2,startPoint.y+2);
            bulletColor=c;
            refItem=i;
        }
        public void run() {
            while(isAlive&&gameAlive){
                if(rightBullet){
                    p.setLocation(p.x-10, p.y);
                }
                else
                    p.setLocation(p.x+10, p.y);
                if(p.x>=500||p.x<=0||p.y>=500||p.y<=0){
                    isAlive=false;
                    return;
                    
                }
                repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
