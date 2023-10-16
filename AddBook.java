import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddBook {
    private static JLabel[] labels;
    private static JTextField[] textFields;
    public AddBook() {
        JFrame f = new JFrame("Add Book");
        f.setSize(600, 500);
        f.setLayout(null);
        f.setUndecorated(true);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(102, 0, 51), 3));

        f.setContentPane(new JPanel(null));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int) (screenSize.getWidth() - f.getWidth()) / 2, (int) (screenSize.getHeight() - f.getHeight()) / 2);

        JPanel panel=new JPanel();
        panel.setBounds(0, -25,800,550) ;
        f.add(panel);
        ImageIcon img = new ImageIcon("./BackgroungImg.png");
        JLabel bck = new JLabel();
        bck.setIcon(img);
        bck.setBounds(0, -25, 800, 550);
        bck.setLayout(null);
        panel.add(bck);
        JLabel heading=new JLabel("Add Book");
        heading.setBounds(260, 50, 250, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 55));
        heading.setForeground(new Color(102, 0, 51)); 
        bck.add(heading);

        String[] labelNames = {"BName", "Bid", "Price", "Author"};
        labels = new JLabel[labelNames.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelNames[i]+": ");
            labels[i].setBounds(200, 130 + i * 50, 200, 40);
            labels[i].setFont(new Font("Serif", Font.BOLD, 30));
            labels[i].setForeground(new Color(153, 0, 76));
            bck.add(labels[i]);
        }
        textFields = new JTextField[labelNames.length];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField();
            textFields[i].setBounds(350, 140 + i * 50, 193, 30);
            textFields[i].setFont(new Font("Serif", Font.BOLD, 15));
            bck.add(textFields[i]);
        }

        JButton btn=new JButton("Add Book");
        btn.setBounds(230,350,120,50);
        btn.setFont(new Font("Serif", Font.BOLD, 15));
        btn.setBackground(new Color(63, 137, 255));
        bck.add(btn);

          JButton back=new JButton("Back");
        back.setBounds(430,350,120,50);
        back.setFont(new Font("Serif", Font.BOLD, 15));
        bck.add(back);
        back.setBackground(new Color(226, 18, 93));
          JButton exit=new JButton("Exit");
        exit.setBounds(330,430,120,50);
        exit.setFont(new Font("Serif", Font.BOLD, 15));
        bck.add(exit);
        exit.addActionListener(e -> System.exit(0));
        exit.setBackground(new Color(226, 18, 93));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textFields[0].getText().trim();
                String input2=textFields[1].getText().trim();
                  String input3=textFields[2].getText().trim();
                    String input4=textFields[3].getText().trim();

                if (input.isEmpty() || input2.isEmpty() || input3.isEmpty() || input4.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Text field is required!");
                }else if (!input3.matches("\\d+")){
                        JOptionPane.showMessageDialog(null, "Price must be in digits only.");
                    }
                    else if (!input4.matches("^[A-Za-z\\s]+$")) {
                        JOptionPane.showMessageDialog(null, "Author should contain only letters.");
                    }
                   else if (!input.matches("^[A-Za-z\\s]+$")) {
                        JOptionPane.showMessageDialog(null, "Book Name should contain only letters.");
                    } else {
                        f.dispose();
                   new RecAdded();
                }
    }
});
            
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              f.dispose();
             new BookStore();
            }
            });
    }
    

    public static void main(String[] args) {
        AddBook obj = new AddBook();
    }
}