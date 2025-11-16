package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddFeeStructure extends JFrame implements ActionListener
{
    JLabel id,id1,id2,id3,id4,id5;
    JFrame f;
    JTextField tf1;
    JButton b,b1;
    Choice ch1,ch2,ch3;

    AddFeeStructure()
    {
        f=new JFrame("Add Fee Structure");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        id=new JLabel();
        id.setBounds(0,0,800,560);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/Fee Structure.jpg"));
        Image i1=img.getImage().getScaledInstance(800,560,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);

        id1=new JLabel("Add Fee Structure");
        id1.setBounds(445,280,500,50);
        id1.setFont(new Font("Airal",Font.BOLD,30));
        id1.setForeground(new Color(84, 2, 224));
        id.add(id1);
        f.add(id);

        id2=new JLabel("Class Name");
        id2.setBounds(400,350,150,30);
        id2.setFont(new Font("Arial",Font.BOLD,20));
        id2.setForeground(new Color(59, 25, 117));
        id.add(id2);

        ch1=new Choice();

        try
        {
            ConnectionClass obj=new ConnectionClass();
            String query="select distinct class_name from class";
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                ch1.add(rest.getString("class_name"));
            }
            rest.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        ch1.setBounds(600,350,150,30);
        ch1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch1);

        id3 = new JLabel("Fee/Year (Rs)");
        id3.setBounds(400,400,200,30);
        id3.setFont(new Font("Airal",Font.BOLD,20));
        id3.setForeground(new Color(59, 25, 117));
        id.add(id3);

        tf1=new JTextField();

        tf1.setBounds(600,400,150,30);
        tf1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(tf1);

        b = new JButton("Add Fee Details");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(400,450,150,40);

        id.add(b);

        b1=new JButton("Back");
        b1.setBackground(new Color(88,245,174));
        b1.setForeground(Color.BLACK);
        b1.setBounds(600,450,150,40);

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
            String class_name = ch1.getSelectedItem();
            String fee_details = tf1.getText();
            Random r = new Random();
            String fee_id=""+Math.abs(r.nextInt() % 100000);

            if(fee_details.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Fee amount should not be an empty!");
            }
            else if(Integer.parseInt(fee_details)>120000)
            {
                JOptionPane.showMessageDialog(null,"Fee amount should not be grater 12000 rs.");
            }
            else if(Integer.parseInt(fee_details)<1000)
            {
                JOptionPane.showMessageDialog(null,"Fee amount should not be less 1000 rs.");
            }
            else
            {
                try
                {
                    ConnectionClass obj = new ConnectionClass();
                    String q = "insert into fee_structure values('"+fee_id+"','"+class_name+"','"+fee_details+"')";
                    obj.stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Fee Details Successfully Inserted");
                    f.setVisible(false);
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,"The error is:"+ex);
                }
            }
        }
        if(e.getSource()==b1)
        {
            f.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new AddFeeStructure().setVisible(true);
    }
}
