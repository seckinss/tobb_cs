import java.awt.*;
import javax.swing.*;
public class K {
    class BorderLayoutExample {
        public static void main(String[] args) {
            JFrame frame = new JFrame("BorderLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            
            frame.add(new JButton("North"), BorderLayout.NORTH);
            frame.add(new JButton("South"), BorderLayout.SOUTH);
            frame.add(new JButton("East"), BorderLayout.EAST);
            frame.add(new JButton("West"), BorderLayout.WEST);
            frame.add(new JButton("Center"), BorderLayout.CENTER);
            
            frame.setVisible(true);
        }
    }
    class FlowLayoutExample {
        public static void main(String[] args) {
            JFrame frame = new JFrame("FlowLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new FlowLayout());
            
            for (int i = 1; i <= 5; i++) {
                frame.add(new JButton("Button " + i));
            }
            
            frame.setVisible(true);
        }
    }
    class GridLayoutExample {
        public static void main(String[] args) {
            JFrame frame = new JFrame("GridLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new GridLayout(3, 2));
            
            for (int i = 1; i <= 6; i++) {
                frame.add(new JButton("Button " + i));
            }
            
            frame.setVisible(true);
        }
    }
    class BoxLayoutExample {
        public static void main(String[] args) {
            JFrame frame = new JFrame("BoxLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
             // Yatay düzenleme için BoxLayout.X_AXIS, dikey düzenleme için BoxLayout.Y_AXIS kullanılabilir.
            frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

            for (int i = 1; i <= 5; i++) { 
                frame.add(new JButton("Button " + i));
                frame.add(Box.createRigidArea(new Dimension(0, 10))); // Aralıkları ayarlamak için
            }
            frame.setVisible(true);
        }
    }
    class GridBagLayoutExample {
        public static void main(String[] args) {
            JFrame frame = new JFrame("GridBagLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLayout(new GridBagLayout());
    
            GridBagConstraints gbc = new GridBagConstraints();
    
            for (int i = 1; i <= 6; i++) {
                gbc.gridx = (i - 1) % 2; // Sütun indeksi
                gbc.gridy = (i - 1) / 2; // Satır indeksi
    
                frame.add(new JButton("Button " + i), gbc);
            }
    
            frame.setVisible(true);
        }
    }
    class WayMac{
        public static void main(String[] args) {
            CenteredButtonsExample.main(args);
        }
    class CenteredButtonsExample {
        public static void main(String[] args) {
        JFrame frame = new JFrame("Centered Buttons Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Dikey düzenleme için BoxLayout.Y_AXIS kullanılabilir.
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // Üst ve alt boşluğu dolduracak boş kutuları oluşturun
        frame.add(Box.createVerticalGlue());

        // Butonları tutacak bir panel oluşturun ve yatay olarak düzenleyin
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        
        // ButtonPanel'i ortalamak için boşlukları ekleyin
        buttonPanel.add(Box.createHorizontalGlue());

        for (int i = 1; i <= 3; i++) {
            buttonPanel.add(new JButton("Button " + i));
            if (i != 3) {
                buttonPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Aralıkları ayarlamak için
            }
        }
        
        // ButtonPanel'i ortalamak için boşlukları ekleyin
        buttonPanel.add(Box.createHorizontalGlue());

        frame.add(buttonPanel);

        // Üst ve alt boşluğu dolduracak boş kutuları oluşturun
        frame.add(Box.createVerticalGlue());

        frame.setVisible(true);
    }
}

        }
    
    public static void main(String[] args) {
        FlowLayoutExample.main(args);
    }
}
