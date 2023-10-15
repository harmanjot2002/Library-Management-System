import javax.swing.*;
import java.awt.*;

public class RecAdded {
    public RecAdded() {
        JFrame f = new JFrame("Record Added");
        f.setSize(800, 550);
        f.setLayout(null);

        f.setContentPane(new JPanel(null));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int) (screenSize.getWidth() - f.getWidth()) / 2, (int) (screenSize.getHeight() - f.getHeight()) / 2);

        JPanel panel=new JPanel();
        panel.setBounds(0, -25,800,550) ;
        f.add(panel);
        ImageIcon img = new ImageIcon("./cele.jpeg");
        JLabel bck = new JLabel();
        bck.setIcon(img);
        bck.setBounds(0, -25, 800, 550);
        bck.setLayout(null);
        panel.add(bck);
        
        JLabel label=new JLabel("Record Added");
        label.setBounds(350,255,320,40);
        label.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
        label.setForeground(new Color(0, 79, 0));
        bck.add(label);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        RecAdded obj = new RecAdded();
    }
}