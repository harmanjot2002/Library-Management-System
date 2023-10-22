import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DelBook {
    public DelBook() {
        JFrame frame = new JFrame("Delete a Book");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(102, 0, 51), 3));

        JPanel panel = new JPanel(null);
        frame.add(panel);

        JLabel heading = new JLabel("Delete a Book");
        heading.setBounds(130, 30, 200, 50);
        heading.setFont(new Font("Serif", Font.BOLD, 30)); 
        heading.setForeground(new Color(102, 0, 51));
        panel.add(heading);

        JLabel label = new JLabel("Enter Book ID or Book Name to Delete:");
        label.setBounds(40, 100, 340, 30);
        label.setFont(new Font("Serif", Font.PLAIN, 20));  
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(90, 150, 220, 30); 
        panel.add(textField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(50, 210, 90, 30);
        deleteButton.setBackground(new Color(201, 69, 47));
        deleteButton.setForeground(Color.WHITE);
        panel.add(deleteButton);

        JButton displayButton = new JButton("Display");
        displayButton.setBounds(150, 210, 90, 30);
        displayButton.setBackground(new Color(153, 0, 153));
        displayButton.setForeground(Color.WHITE);
        panel.add(displayButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 210, 90, 30);
        cancelButton.setBackground(new Color(64, 64, 64));
        cancelButton.setForeground(Color.WHITE);
        panel.add(cancelButton);

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText().trim();
                if (!input.isEmpty()) {
                    String url = "jdbc:mysql://localhost:3306/library";
                    String user = "root";
                    String pwd = "1234";
                    String in = textField.getText();
                    String query = "Delete from books where Bid='" + in + "' or Bname='" + in + "';";
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection(url, user, pwd);
                        PreparedStatement ps = con.prepareStatement(query);
                        int rows = ps.executeUpdate(query);//Used with delete(means update like queries nd return no. of rows that are changed by our query.)
                        if (rows > 0) {
                            JOptionPane.showMessageDialog(null, "Book removed from Library");
                        } else {
                            JOptionPane.showMessageDialog(null, "No such book available");
                        }
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter Book ID or Name to delete.");
                }
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Display();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DelBook();
            }
        });
    }
}
