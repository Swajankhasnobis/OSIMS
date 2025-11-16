package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddNewSubject extends JFrame implements ActionListener
{
    JLabel id,id1,id2,id3,id4,id5;
    JFrame f;
    JTextField t1;
    JButton b,b1;
    Choice ch1,ch2,ch3;

    AddNewSubject()
    {
        f=new JFrame("Add New Subject Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        id=new JLabel();
        id.setBounds(0,0,800,560);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/Add Subject.jpg"));
        Image i1=img.getImage().getScaledInstance(800,560,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);

        id1=new JLabel("Add New Subject Details");
        id1.setBounds(400,110,500,50);
        id1.setFont(new Font("Airal",Font.BOLD,30));
        id1.setForeground(new Color(84, 2, 224));
        id.add(id1);
        f.add(id);

        id2=new JLabel("Subject Code");
        id2.setBounds(400,200,150,30);
        id2.setFont(new Font("Arial",Font.BOLD,20));
        id2.setForeground(new Color(59, 25, 117));
        id.add(id2);

        ch1=new Choice();
        ch1.add("ESC501");
        ch1.add("PCCCS501");
        ch1.add("HSMC501");
        ch1.add("ESC502");
        ch1.add("PCCCS502");
        ch1.add("MC401");

        ch1.setBounds(600,200,150,30);
        ch1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch1);

        id3 = new JLabel("Subject Name");
        id3.setBounds(400,250,200,30);
        id3.setFont(new Font("Airal",Font.BOLD,20));
        id3.setForeground(new Color(59, 25, 117));
        id.add(id3);

        ch2=new Choice();
        ch2.add("Software Engineering");
        ch2.add("Compiler Design");
        ch2.add("Java");
        ch2.add("OS");
        ch2.add("Industrial Management");
        ch2.add("Constitution");

        ch2.setBounds(600,250,150,30);
        ch2.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch2);

        b = new JButton("Add Subject");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(400,300,150,40);

        id.add(b);

        b1=new JButton("Back");
        b1.setBackground(new Color(88,245,174));
        b1.setForeground(Color.BLACK);
        b1.setBounds(600,300,150,40);

        id.add(b1);

        b.addActionListener(this);
        b1.addActionListener(this);

        f.setVisible(true);
        f.setSize(800,560);
        f.setLocation(300,100);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            String subject_code = ch1.getSelectedItem();
            String subject_name = ch2.getSelectedItem();
            Random r = new Random();
            String subject_id=""+Math.abs(r.nextInt() % 100000);

            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into subject values('"+subject_id+"','"+subject_code+"','"+subject_name+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Subejct Details Successfully Inserted");
                f.setVisible(false);
            }
            catch(Exception ex)
            {
                System.out.println("The error is:"+ex);
            }
        }
        if(e.getSource()==b1)
        {
            f.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new AddNewSubject().setVisible(true);
    }
}
