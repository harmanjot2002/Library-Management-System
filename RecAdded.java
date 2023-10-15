import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;

public class RecAdded {
    public RecAdded() {
        JFrame f = new JFrame("Record Added");
        f.setSize(350, 200);
        f.setLayout(null);

        f.setContentPane(new JPanel(null));
        f.setUndecorated(true);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(128, 0, 128), 3));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int) (screenSize.getWidth() - f.getWidth()) / 2, (int) (screenSize.getHeight() - f.getHeight()) / 2);

        JPanel panel=new JPanel();
        panel.setBounds(0, -25,350,200) ;
        f.add(panel);
        ImageIcon img = new ImageIcon("./loginBGI.jpg");
        JLabel bck = new JLabel();
        bck.setIcon(img);
        bck.setBounds(0, 0, 350, 200);
        bck.setLayout(null);
        panel.add(bck);
        
        JLabel label=new JLabel("Record Added");
        label.setBounds(230,50,200,40);
        label.setFont(new Font("Serif", Font.BOLD, 30));
        label.setForeground(new Color(0, 79, 0));
        bck.add(label);

        JButton add=new JButton("Book Store");
     add.setBackground(new Color(226, 142, 93));
    add.setBounds(200,120,130,40);
      bck.add(add);
        JButton exit =new JButton("Exit");

        exit.setBackground(new Color(226, 18, 93));
       exit.setBounds(350,120,110,40);
         bck.add(exit);

         exit.addActionListener(e -> System.exit(0));
         add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  f.dispose();
                  new BookStore();
            }
        
        });
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        RecAdded obj = new RecAdded();
    }
}