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
        f.setSize(800, 600);
        f.setLayout(null);
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation((int)(screenSize.getWidth()-f.getWidth())/2,(int)(screenSize.getHeight()-f.getHeight())/2);
        
        JLabel heading=new JLabel("Book Store");
        heading.setBounds(50,50,400,40);
        heading.setFont(new Font("Monotype Corsiva", Font.ITALIC, 50));
        heading.setForeground(new Color(128, 0, 128)); 
        f.add(heading);
        JButton addbtn=new JButton("Add");
        addbtn.setBackground(Color.green);
        addbtn.setBounds(130,150,110,50);
        f.add(addbtn);
        addbtn.addActionListener(this);

        JButton deletebtn=new JButton("Delete");
        deletebtn.setBackground(Color.red);
          deletebtn.setBounds(130,250,110,50);
        f.add(deletebtn);

        JButton updatebtn=new JButton("Update");
        updatebtn.setBackground(Color.blue);
        updatebtn.setBounds(130,350,110,50);
        f.add(updatebtn);

        JPanel panel1=new JPanel();
        panel1.setBounds(0,0,400,600);
        panel1.setBackground(new Color(	222,184,135));

        f.add(panel1);

          JPanel panel2=new JPanel();
        panel2.setBounds(400,0,400,600);
        panel2.setLayout(new BorderLayout());
        f.add(panel2);

          try {
            BufferedImage originalImage = ImageIO.read(getClass().getResource("./libImg.jpeg"));
            int scaledWidth = 400;
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
    }

    public void actionPerformed(ActionEvent e) {
       f.dispose();
        new AddBook();
    }
    public static void main(String[] args) {
        new BookStore();
    }
}