import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddBook {
    private static JLabel[] labels;
    private static JTextField[] textFields;
    public AddBook() {
        JFrame f = new JFrame("Add Book");
        f.setSize(800, 550);
        f.setLayout(null);

        f.setContentPane(new JPanel(null));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int) (screenSize.getWidth() - f.getWidth()) / 2, (int) (screenSize.getHeight() - f.getHeight()) / 2);

        JPanel panel=new JPanel();
        panel.setBounds(0, -25,800,550) ;
        f.add(panel);
        ImageIcon img = new ImageIcon("./imagee.jpeg");
        JLabel bck = new JLabel();
        bck.setIcon(img);
        bck.setBounds(0, -25, 800, 550);
        bck.setLayout(null);
        panel.add(bck);

        String[] labelNames = {"BName", "Bid", "Price", "Author"};
        labels = new JLabel[labelNames.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelNames[i]+": ");
            labels[i].setBounds(500, 130 + i * 50, 200, 40);
            labels[i].setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
            labels[i].setForeground(Color.blue);
            bck.add(labels[i]);
        }
        textFields = new JTextField[labelNames.length];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField();
            textFields[i].setBounds(650, 130 + i * 50, 193, 40);
            textFields[i].setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
            bck.add(textFields[i]);
        }

        JButton btn=new JButton("Add Book");
        btn.setBounds(600,370,120,50);
        btn.setFont(new Font("Monotype Corsiva", Font.BOLD, 15));
        bck.add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textFields[0].getText().trim();
                String input2=textFields[1].getText().trim();
                  String input3=textFields[2].getText().trim();
                    String input4=textFields[3].getText().trim();

                if (input.isEmpty() || input2.isEmpty() || input3.isEmpty() || input4.isEmpty()) {
                    JOptionPane.showMessageDialog(f, "Text field is required!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                   new RecAdded();
                }
    }
});
            
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        AddBook obj = new AddBook();
    }
}