import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class BookStore implements ActionListener {
    private static JFrame f;
    private static ImageIcon imageIcon;
    private static JLabel imageLabel;
   public BookStore(){
         f= new JFrame("Book Store");
        f.setSize(600, 500);
        f.setLayout(null);
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int)(screenSize.getWidth()-f.getWidth())/2,(int)(screenSize.getHeight()-f.getHeight())/2);
        f.setUndecorated(true);
        f.getRootPane().setBorder(BorderFactory.createLineBorder(new Color(128, 0, 128), 3));
        
        JLabel heading=new JLabel("Book Store");
        heading.setBounds(170,50,400,50);
        heading.setFont(new Font("Serif", Font.BOLD, 55));
        heading.setForeground(new Color(128, 0, 128)); 
        f.add(heading);
        JButton addbtn=new JButton("Add");
       // addbtn.setBackground(Color.green);
        addbtn.setBackground(new Color(63, 152, 76));
        addbtn.setBounds(150,150,110,50);
        f.add(addbtn);
        addbtn.addActionListener(this);

        JButton deletebtn=new JButton("Delete");
       // deletebtn.setBackground(Color.red);
        deletebtn.setBackground(new Color(63, 137, 255));
          deletebtn.setBounds(340,150,110,50);
        f.add(deletebtn);

        JButton updatebtn=new JButton("Update");
       // updatebtn.setBackground(Color.blue);
        updatebtn.setBackground(new Color(206, 49, 39));
         updatebtn.setBounds(150,280,110,50);
        f.add(updatebtn);
        JButton exit =new JButton("Exit");
         //exit.setBackground(Color.blue);
         exit.setBackground(new Color(226, 18, 93));
        exit.setBounds(340,280,110,50);
          f.add(exit);

            JButton login=new JButton("Back to Login");
         //exit.setBackground(Color.blue);
         login.setBackground(new Color(226, 142, 93));
        login.setBounds(240,380,130,60);
          f.add(login);
          exit.addActionListener(e -> System.exit(0));
          JPanel panel2=new JPanel();
        panel2.setBounds(0,0,800, 600);
        panel2.setLayout(new BorderLayout());
        f.add(panel2);

          try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("./BackgroungImg.png"));
            int scaledWidth = 800;
            int scaledHeight = 600;
            BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = scaledImage.createGraphics();
            g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null);
            g.dispose();
            imageIcon = new ImageIcon(scaledImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(400, 50, 200, 300);
        panel2.add(imageLabel);

        
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            f.dispose();
            new Login();
          }
          });
    }

    
    public void actionPerformed(ActionEvent e) {
       f.dispose();
        new AddBook();
    }
    public static void main(String[] args) {
        new BookStore();
    }
}