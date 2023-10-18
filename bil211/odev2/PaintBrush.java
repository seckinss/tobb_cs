import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*; 
import java.awt.event.*;
import java.util.ArrayList;

public class PaintBrush {
    public static void main(String[] args) {
        JFrame mainf = new JFrame("PaintBrush");
        mainf.setSize(1000, 700);
        mainf.setLocation(355, 206);
        mainf.setLayout(new BorderLayout());
        mainf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1000, 175));
        topPanel.setLayout(new BorderLayout());
        TopTopPanel toptopPanel = new TopTopPanel();
        JPanel diptopPanel = new JPanel();
        diptopPanel.setLayout(new FlowLayout());
        diptopPanel.setPreferredSize(new Dimension(1000, 75));
        Dimension buttonDimension = new Dimension(140, 60);
        JButton drawrec = new JButton("Dikdörtgen Çiz");
        JButton drawoval = new JButton("Oval Çiz");
        JButton drawlines = new JButton("Kalemle Çiz");
        JButton move = new JButton("Taşı");
        JPanel blueline = new JPanel();
        blueline.setBackground(Color.BLUE);
        blueline.setPreferredSize(new Dimension(1000, 5));
        drawrec.setPreferredSize(buttonDimension);
        drawoval.setPreferredSize(buttonDimension);
        drawlines.setPreferredSize(buttonDimension);
        move.setPreferredSize(buttonDimension);
        diptopPanel.add(drawrec, toptopPanel);
        diptopPanel.add(drawoval);
        diptopPanel.add(drawlines);
        diptopPanel.add(move);
        topPanel.add(toptopPanel, BorderLayout.NORTH);
        topPanel.add(diptopPanel, BorderLayout.CENTER);
        topPanel.add(blueline, BorderLayout.SOUTH);
        DrawPanel drawPanel = new DrawPanel();
        drawrec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype = 1;
            }
        });
        drawoval.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype = 2;
            }
        });
        drawlines.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype = 3;
            }
        });
        move.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPanel.processtype = 4;
            }
        });
        mainf.add(drawPanel, BorderLayout.CENTER);
        mainf.add(topPanel, BorderLayout.NORTH);
        toptopPanel.setDPanel(drawPanel);
        mainf.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    Color c = Color.BLACK;
    int processtype = 0;
    int formerX, formerY;
    ArrayList<Item> Itemlist = new ArrayList<>();

    DrawPanel() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (processtype == 1) {
                    Itemlist.add(new Rectang(new CustomPoint(e.getPoint(), c)));
                }
                if (processtype == 2) {
                    Itemlist.add(new Oval(new CustomPoint(e.getPoint(), c)));
                }
                if (processtype == 3) {
                    Itemlist.add(new Line(new CustomPoint(e.getPoint(), c)));
                }
                if (processtype == 4) {
                    for (int i = Itemlist.size() - 1; i >= 0; i--) {
                        if (Itemlist.get(i) instanceof Oval) {
                            Oval item1 = (Oval) Itemlist.get(i);
                            Point center = new Point((int) ((item1.points.get(0).p.x + item1.points.get(1).p.x) / 2.0), (int) ((item1.points.get(0).p.y + item1.points.get(1).p.y) / 2.0));
                            double xform = ((e.getX() - center.getX()) * (e.getX() - center.getX()))  / ((item1.points.get(0).p.x - item1.points.get(1).p.x) * (item1.points.get(0).p.x - item1.points.get(1).p.x) / 4.0);
                            double yform = ((e.getY() - center.getY()) * (e.getY() - center.getY()))  / ((item1.points.get(0).p.y - item1.points.get(1).p.y) * (item1.points.get(0).p.y - item1.points.get(1).p.y) / 4.0);
                            if (xform + yform <= 1) {
                                Itemlist.remove(i);
                                Itemlist.add(item1);
                                formerX = e.getPoint().x;
                                formerY = e.getPoint().y;
                                return;
                            }
                        }
                        if (Itemlist.get(i) instanceof Rectang) {
                            Rectang item1 = (Rectang) Itemlist.get(i);
                            int bigx, smallx, bigy, smally;
                            if (item1.points.get(0).p.x > item1.points.get(1).p.x) {
                                bigx = item1.points.get(0).p.x;
                                smallx = item1.points.get(1).p.x;
                            } else {
                                bigx = item1.points.get(1).p.x;
                                smallx = item1.points.get(0).p.x;
                            }
                            if (item1.points.get(0).p.y > item1.points.get(1).p.y) {
                                bigy = item1.points.get(0).p.y;
                                smally = item1.points.get(1).p.y;
                            } else {
                                bigy = item1.points.get(1).p.y;
                                smally = item1.points.get(0).p.y;
                            }
                            if (e.getPoint().x <= bigx && e.getPoint().x >= smallx && e.getPoint().y <= bigy && e.getPoint().y >= smally) {
                                Itemlist.remove(i);
                                Itemlist.add(item1);
                                formerX = e.getPoint().x;
                                formerY = e.getPoint().y;
                                return;
                            }
                        }
                    }
                    processtype = 5;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (processtype == 1) {
                    Itemlist.get(Itemlist.size() - 1).addPoint(new CustomPoint(e.getPoint(), c));
                }
                if (processtype == 2) {
                    Itemlist.get(Itemlist.size() - 1).addPoint(new CustomPoint(e.getPoint(), c));
                }
                if (processtype == 3) {
                    Itemlist.get(Itemlist.size() - 1).addPoint(new CustomPoint(e.getPoint(), c));
                }
                if (processtype == 4) {
                    if (Itemlist.get(Itemlist.size() - 1) instanceof Oval) {
                        Oval oItem = (Oval) (Itemlist.get(Itemlist.size() - 1));
                        oItem.points.get(0).p.setLocation(oItem.points.get(0).p.x + e.getX() - formerX, oItem.points.get(0).p.y + e.getY() - formerY);
                        oItem.points.get(1).p.setLocation(oItem.points.get(1).p.x + e.getX() - formerX, oItem.points.get(1).p.y + e.getY() - formerY);
                        formerY = e.getY();
                        formerX = e.getX();
                    }
                    if (Itemlist.get(Itemlist.size() - 1) instanceof Rectang) {
                        Rectang item1 = (Rectang) Itemlist.get(Itemlist.size() - 1);
                        item1.points.get(0).p.setLocation(item1.points.get(0).p.x + e.getX() - formerX, item1.points.get(0).p.y + e.getY() - formerY);
                        item1.points.get(1).p.setLocation(item1.points.get(1).p.x + e.getX() - formerX, item1.points.get(1).p.y + e.getY() - formerY);
                        formerX = e.getX();
                        formerY = e.getY();
                    }
                }
                if(processtype==5)
                    processtype=4;
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (processtype == 1) {
                    Itemlist.get(Itemlist.size() - 1).addPoint(new CustomPoint(e.getPoint(), c));
                }
                if (processtype == 2) {
                    Itemlist.get(Itemlist.size() - 1).addPoint(new CustomPoint(e.getPoint(), c));
                }
                if (processtype == 3) {
                    Itemlist.get(Itemlist.size() - 1).addPoint(new CustomPoint(e.getPoint(), c));
                }
                if (processtype == 4) {
                    if (Itemlist.get(Itemlist.size() - 1) instanceof Oval) {
                        Oval oItem = (Oval) (Itemlist.get(Itemlist.size() - 1));
                        oItem.points.get(0).p.setLocation(oItem.points.get(0).p.x + e.getX() - formerX, oItem.points.get(0).p.y + e.getY() - formerY);
                        oItem.points.get(1).p.setLocation(oItem.points.get(1).p.x + e.getX() - formerX, oItem.points.get(1).p.y + e.getY() - formerY);
                        formerY = e.getY();
                        formerX = e.getX();
                    }
                    if (Itemlist.get(Itemlist.size() - 1) instanceof Rectang) {
                        Rectang item1 = (Rectang) Itemlist.get(Itemlist.size() - 1);
                        item1.points.get(0).p.setLocation(item1.points.get(0).p.x + e.getX() - formerX, item1.points.get(0).p.y + e.getY() - formerY);
                        item1.points.get(1).p.setLocation(item1.points.get(1).p.x + e.getX() - formerX, item1.points.get(1).p.y + e.getY() - formerY);
                        formerX = e.getX();
                        formerY = e.getY();
                    }
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < Itemlist.size(); i++) {
            ArrayList<CustomPoint> s = Itemlist.get(i).points;
            g.setColor(Itemlist.get(i).points.get(0).c);
            if (Itemlist.get(i) instanceof Oval) {
                int bigx, smallx, bigy, smally;
                if (s.get(0).p.x > s.get(1).p.x) {
                    bigx = s.get(0).p.x;
                    smallx = s.get(1).p.x;
                } else {
                    bigx = s.get(1).p.x;
                    smallx = s.get(0).p.x;
                }
                if (s.get(0).p.y > s.get(1).p.y) {
                    bigy = s.get(0).p.y;
                    smally = s.get(1).p.y;
                } else {
                    bigy = s.get(1).p.y;
                    smally = s.get(0).p.y;
                }
                g.fillOval(smallx, smally, bigx - smallx, bigy - smally);
            }
            if (Itemlist.get(i) instanceof Line) {
                for (int j = 1; j < Itemlist.get(i).points.size(); j++) {
                    g.setColor(Itemlist.get(i).points.get(j).c);
                    g.drawLine(s.get(j - 1).p.x, s.get(j - 1).p.y, s.get(j).p.x, s.get(j).p.y);
                }
            }
            if (Itemlist.get(i) instanceof Rectang) {
                int bigx, smallx, bigy, smally;
                if (s.get(0).p.x > s.get(1).p.x) {
                    bigx = s.get(0).p.x;
                    smallx = s.get(1).p.x;
                } else {
                    bigx = s.get(1).p.x;
                    smallx = s.get(0).p.x;
                }
                if (s.get(0).p.y > s.get(1).p.y) {
                    bigy = s.get(0).p.y;
                    smally = s.get(1).p.y;
                } else {
                    bigy = s.get(1).p.y;
                    smally = s.get(0).p.y;
                }
                g.fillRect(smallx, smally, bigx - smallx, bigy - smally);
            }
        }
    }
}

class TopTopPanel extends JPanel implements MouseInputListener {
    private DrawPanel referanceDPanel;

    TopTopPanel() {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1000, 100));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(79, 113, 190));
        g.fillRect((int) (getWidth() / 6.25), getHeight() / 5 + 4, (int) (getWidth() / 11.182), 37);
        g.setColor(Color.RED);
        g.fillRect((int) (getWidth() / 6.25) + (int) (1 * getWidth() / 10.16), getHeight() / 5 + 4, (int) (getWidth() / 11.182), 37);
        g.setColor(new Color(0, 176, 80));
        g.fillRect((int) (getWidth() / 6.25) + (int) (2 * getWidth() / 10.16), getHeight() / 5 + 4, (int) (getWidth() / 11.182), 37);
        g.setColor(Color.YELLOW);
        g.fillRect((int) (getWidth() / 6.25) + (int) (3 * getWidth() / 10.16), getHeight() / 5 + 4, (int) (getWidth() / 11.182), 37);
        g.setColor(new Color(240, 131, 48));
        g.fillRect((int) (getWidth() / 6.25) + (int) (4 * getWidth() / 10.16), getHeight() / 5 + 4, (int) (getWidth() / 11.182), 37);
        g.setColor(new Color(128, 0, 128));
        g.fillRect((int) (getWidth() / 6.25) + (int) (5 * getWidth() / 10.16), getHeight() / 5 + 4, (int) (getWidth() / 11.182), 37);
        g.setColor(Color.BLACK);
        g.fillRect((int) (getWidth() / 6.25) + (int) (6 * getWidth() / 10.16), getHeight() / 5 + 4, (int) (getWidth() / 11.182), 37);
    }

    @Override
    public void mouseClicked(MouseEvent e) { // no needed but had to override
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= (int) (getWidth() / 6.25) && x < (int) (getWidth() / 6.25) + (int) (getWidth() / 11.182) && y >= getHeight() / 5 + 4 && y < getHeight() / 5 + 39) {
            referanceDPanel.c = new Color(79, 113, 190);
        }
        if (x >= (int) (getWidth() / 6.25) + (int) (1 * getWidth() / 10.16) && x < (int) (getWidth() / 6.25) + (int) (1 * getWidth() / 10.16) + (int) (getWidth() / 11.182) && y >= getHeight() / 5 + 4 && y < getHeight() / 5 + 39) {
            referanceDPanel.c = Color.RED;
        }
        if (x >= (int) (getWidth() / 6.25) + (int) (2 * getWidth() / 10.16) && x < (int) (getWidth() / 6.25) + (int) (2 * getWidth() / 10.16) + (int) (getWidth() / 11.182) && y >= getHeight() / 5 + 4 && y < getHeight() / 5 + 39) {
            referanceDPanel.c = new Color(0, 176, 80);
        }
        if (x >= (int) (getWidth() / 6.25) + (int) (3 * getWidth() / 10.16) && x < (int) (getWidth() / 6.25) + (int) (3 * getWidth() / 10.16) + (int) (getWidth() / 11.182) && y >= getHeight() / 5 + 4 && y < getHeight() / 5 + 39) {
            referanceDPanel.c = Color.YELLOW;
        }
        if (x >= (int) (getWidth() / 6.25) + (int) (4 * getWidth() / 10.16) && x < (int) (getWidth() / 6.25) + (int) (4 * getWidth() / 10.16) + (int) (getWidth() / 11.182) && y >= getHeight() / 5 + 4 && y < getHeight() / 5 + 39) {
            referanceDPanel.c = new Color(240, 131, 48);
        }
        if (x >= (int) (getWidth() / 6.25) + (int) (5 * getWidth() / 10.16) && x < (int) (getWidth() / 6.25) + (int) (5 * getWidth() / 10.16) + (int) (getWidth() / 11.182) && y >= getHeight() / 5 + 4 && y < getHeight() / 5 + 39) {
            referanceDPanel.c = new Color(128, 0, 128);
        }
        if (x >= (int) (getWidth() / 6.25) + (int) (6 * getWidth() / 10.16) && x < (int) (getWidth() / 6.25) + (int) (6 * getWidth() / 10.16) + (int) (getWidth() / 11.182) && y >= getHeight() / 5 + 4 && y < getHeight() / 5 + 39) {
            referanceDPanel.c = Color.BLACK;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) { // no needed but had to override
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
    public void mouseMoved(MouseEvent e) { // no needed but had to override

    }

    public void setDPanel(DrawPanel drawPanel) {
        referanceDPanel = drawPanel; // taking drawpanel as a referance to change color type
    }
}

class Line extends Item {
    Line(CustomPoint start) {
        super(start);
    }
}

class Item {
    ArrayList<CustomPoint> points;

    Item(CustomPoint start) {
        points = new ArrayList<>();
        points.add(start);
    }

    void addPoint(CustomPoint point) {
        points.add(point);
    }
}

class Oval extends Item {

    Oval(CustomPoint start) {
        super(start);
        addPoint(start);
    }

    void addPoint(CustomPoint point) {
        points.add(1, point);
        if (points.size() > 2) {
            points.remove(2);
        }
    }
}

class Rectang extends Item {
    Rectang(CustomPoint start) {
        super(start);
        addPoint(start);
    }

    void addPoint(CustomPoint point) {
        points.add(1, point);
        if (points.size() > 2) {
            points.remove(2);
        }
    }
}

class CustomPoint {
    public Point p;
    Color c;

    CustomPoint(Point point, Color color) {
        p = point;
        c = color;
    }
}