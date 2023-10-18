import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.*;

public class Main{
    public static void main(String[] args) {
        JFrame mainf=new JFrame("PaintV2");
        mainf.setSize(1000,700);
        mainf.setLocation(355, 206);
        mainf.setLayout(new BorderLayout());
        JPanel topPanel=new JPanel();
        topPanel.setPreferredSize(new Dimension(1000,175));
        topPanel.setBackground(Color.BLUE);
        topPanel.setLayout(new BorderLayout());
        TopTopPanel toptopPanel=new TopTopPanel();
        JPanel diptopPanel=new JPanel();
        diptopPanel.setLayout(new FlowLayout());
        diptopPanel.setPreferredSize(new Dimension(1000,75));
        Dimension ds=new Dimension(140,65);
        JButton drawrec=new JButton("Dikdörtgen Çiz");
        JButton drawoval=new JButton("Oval Çiz");
        JButton drawlines=new JButton("Kalemle Çiz");
        JButton move=new JButton("Taşı");
        drawrec.setPreferredSize(ds);
        drawoval.setPreferredSize(ds);
        drawlines.setPreferredSize(ds);
        move.setPreferredSize(ds);
        diptopPanel.add(drawrec,toptopPanel);
        diptopPanel.add(drawoval);
        diptopPanel.add(drawlines);
        diptopPanel.add(move);
        topPanel.add(toptopPanel,BorderLayout.NORTH);
        topPanel.add(diptopPanel,BorderLayout.CENTER);
        DrawPanel drawPanel=new DrawPanel(){};
        drawrec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype=1;
            }
        });
        drawoval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype=2;
            }
        });
        drawlines.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype=3;
            }
        });
        move.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype=4;
            }
        });
        mainf.add(drawPanel,BorderLayout.CENTER);
        mainf.add(topPanel,BorderLayout.NORTH);
        toptopPanel.setDPanel(drawPanel);
        diptopPanel.setBackground(Color.red);
        toptopPanel.setBackground(Color.WHITE);
        topPanel.setBackground(Color.BLUE);
        drawPanel.setBackground(Color.GREEN);
        mainf.setVisible(true);
    }
}
class DrawPanel extends JPanel {
    Color c=Color.BLACK;
    int processtype=0;
    DrawPanel(){

    }
    @Override
    protected void paintComponent(Graphics g) {
        
    }
    @Override
    public void addMouseListener(MouseListener l) {
        
    }
}
class TopTopPanel extends JPanel implements MouseInputListener{ 
    private DrawPanel referanceDPanel;
    TopTopPanel(){
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1000,100));
        addMouseListener(this);     
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(79, 113, 190));
        g.fillRect((int)((double)getSize().width/5-35),getSize().height/5+4 , (int)((double)getSize().width/10-5), 35);
        g.setColor(Color.RED);
        g.fillRect((int)((double)getSize().width/5-35) + (int)(1.0*getSize().width/10),getSize().height/5+4 ,  (int)((double)getSize().width/10-5), 35);
        g.setColor(new Color(0,176,80));
        g.fillRect((int)((double)getSize().width/5-35) + (int)(2.0*getSize().width/10),getSize().height/5+4 ,  (int)((double)getSize().width/10-5), 35);
        g.setColor(Color.YELLOW);
        g.fillRect((int)((double)getSize().width/5-35) + (int)(3.0*getSize().width/10),getSize().height/5+4 ,  (int)((double)getSize().width/10-5), 35);
        g.setColor(new Color(240,131,48));
        g.fillRect((int)((double)getSize().width/5-35) + (int)(4.0*getSize().width/10),getSize().height/5+4 ,  (int)((double)getSize().width/10-5), 35);
        g.setColor(new Color(128,0,128));
        g.fillRect((int)((double)getSize().width/5-35) + (int)(5.0*getSize().width/10),getSize().height/5+4 ,  (int)((double)getSize().width/10-5), 35);
        g.setColor(Color.BLACK);
        g.fillRect((int)((double)getSize().width/5-35) + (int)(6.0*getSize().width/10),getSize().height/5+4 ,  (int)((double)getSize().width/10-5), 35);  
        referanceDPanel.setBackground(referanceDPanel.c);
    }
    @Override
    public void mouseClicked(MouseEvent e) { //used pressed no needed but had to override 
    }
    @Override
    public void mousePressed(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        if(x>(int)((double)getSize().width/5-35)&&y>getSize().height/5+4&&x<(int)((double)getSize().width/5-35) + (int)((double)getSize().width/10-5)&&y<getSize().height/5+39){
            referanceDPanel.c=new Color(79, 113, 190);
        }
        if(x>(int)((double)getSize().width/5-35) + (int)(1.0*getSize().width/10)&&y>getSize().height/5+4&&x<(int)((double)getSize().width/5-35) + (int)(6.0*getSize().width/10) + (int)((double)getSize().width/10-5)&&y<getSize().height/5+39){
            referanceDPanel.c=Color.RED;
        }
        if(x>(int)((double)getSize().width/5-35)+ (int)(2.0*getSize().width/10)&&y>getSize().height/5+4&&x<(int)((double)getSize().width/5-35) + (int)(6.0*getSize().width/10) + (int)((double)getSize().width/10-5)&&y<getSize().height/5+39){
            referanceDPanel.c=new Color(0,176,80);
        }
        if(x>(int)((double)getSize().width/5-35) + (int)(3.0*getSize().width/10)&&y>getSize().height/5+4&&x<(int)((double)getSize().width/5-35) + (int)(6.0*getSize().width/10) + (int)((double)getSize().width/10-5)&&y<getSize().height/5+39){
            referanceDPanel.c=Color.YELLOW;
        }
        if(x>(int)((double)getSize().width/5-35) + (int)(4.0*getSize().width/10)&&y>getSize().height/5+4&&x<(int)((double)getSize().width/5-35) + (int)(6.0*getSize().width/10) + (int)((double)getSize().width/10-5)&&y<getSize().height/5+39){
            referanceDPanel.c=new Color(240,131,48);
        }
        if(x>(int)((double)getSize().width/5-35) + (int)(5.0*getSize().width/10)&&y>getSize().height/5+4&&x<(int)((double)getSize().width/5-35) + (int)(5.0*getSize().width/10) + (int)((double)getSize().width/10-5)&&y<getSize().height/5+39){
            referanceDPanel.c=new Color(128,0,128);
        }
        if(x>(int)((double)getSize().width/5-35) + (int)(6.0*getSize().width/10)&&y>getSize().height/5+4&&x<(int)((double)getSize().width/5-35) + (int)(6.0*getSize().width/10) + (int)((double)getSize().width/10-5)&&y<getSize().height/5+39){
            referanceDPanel.c=Color.BLACK;       
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) { 
    }
    @Override
    public void mouseDragged(MouseEvent e) {
       
    }
    @Override
    public void mouseMoved(MouseEvent e) {
    }
    public void setDPanel(DrawPanel drawPanel){
        referanceDPanel=drawPanel; // taking drawpanel as referance to change color type
    }
}