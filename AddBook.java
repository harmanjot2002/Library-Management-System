import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

        JPanel panel = new JPanel();
        panel.setBounds(0, -25, 800, 550);
        f.add(panel);
        ImageIcon img = new ImageIcon("./BackgroungImg.png");
        JLabel bck = new JLabel();
        bck.setIcon(img);
        bck.setBounds(0, -25, 800, 550);
        bck.setLayout(null);
        panel.add(bck);
        JLabel heading = new JLabel("Add Book");
        heading.setBounds(260, 50, 250, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 55));
        heading.setForeground(new Color(102, 0, 51));
        bck.add(heading);

        String[] labelNames = { "BName", "Bid", "Price", "Author" };
        labels = new JLabel[labelNames.length];
        for (int i = 0; i < labels.length; i++) {
            labels[i] = new JLabel(labelNames[i] + ": ");
            labels[i].setBounds(200, 130 + i * 50, 200, 40);
            labels[i].setFont(new Font("Serif", Font.BOLD, 30));
            labels[i].setForeground(new Color(102, 0, 51));
            bck.add(labels[i]);
        }
        textFields = new JTextField[labelNames.length];
        for (int i = 0; i < textFields.length; i++) {
            textFields[i] = new JTextField();
            textFields[i].setBounds(350, 140 + i * 50, 193, 30);
            textFields[i].setFont(new Font("Serif", Font.BOLD, 15));
            bck.add(textFields[i]);
        }

        JButton btn = new JButton("Add Book");
        btn.setBounds(230, 350, 120, 50);
        btn.setFont(new Font("Serif", Font.BOLD, 15));
        btn.setBackground(new Color(63, 137, 255));
        btn.setForeground(Color.white);
        bck.add(btn);

        JButton back = new JButton("Back");
        back.setBounds(230, 430, 120, 50);
        back.setFont(new Font("Serif", Font.BOLD, 15));
        bck.add(back);
        back.setBackground(new Color(201,69,47));
        back.setForeground(Color.white);

        JButton displaybtn = new JButton("Display");
        displaybtn.setFont(new Font("Serif", Font.BOLD, 15));
        displaybtn.setBackground(new Color(153, 0, 153));
        displaybtn.setForeground(Color.white);
        displaybtn.setBounds(430, 350, 120, 50);
        bck.add(displaybtn);


        JButton exit = new JButton("Exit");
        exit.setBounds(430, 430, 120, 50);
        exit.setFont(new Font("Serif", Font.BOLD, 15));
        bck.add(exit);
        exit.addActionListener(e -> System.exit(0));
        exit.setBackground(new Color(64,64,64));
        exit.setForeground(Color.white);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookName = textFields[0].getText().trim();
                String bookId = textFields[1].getText().trim();
                String price = textFields[2].getText().trim();
                String author = textFields[3].getText().trim();

                if (bookName.isEmpty() || bookId.isEmpty() || price.isEmpty() || author.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Text field is required!");
                } else if (!price.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Price must be in digits only.");
                } else if (!author.matches("^[A-Za-z\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "Author should contain only letters.");
                } else if (!bookName.matches("^[A-Za-z\\s]+$")) {
                    JOptionPane.showMessageDialog(null, "Book Name should contain only letters.");
                } else {
                    try {
                        String url = "jdbc:mysql://localhost:3306/library";
                        String user = "root";
                        String password = "1234";
                        Connection connection = DriverManager.getConnection(url, user, password);

                        String query = "INSERT INTO books (Bid, Bname, Price, Author) VALUES (?, ?, ?, ?)";
                        //We cannot hardcode the values,so use ? here.
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, bookId);
                        preparedStatement.setString(2, bookName);
                        preparedStatement.setString(3, price);
                        preparedStatement.setString(4, author);

                        int rowsInserted = preparedStatement.executeUpdate();
                        if (rowsInserted > 0) {
                            f.dispose();
                            new RecAdded();
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to add the book.");
                        }

                        connection.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                    }
                }
            }
        });

        displaybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new Display();
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