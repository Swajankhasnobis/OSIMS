package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.util.Date;

public class AddFeeDetails extends JFrame implements ActionListener
{
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14,id15;
    JFrame f;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JButton b,b1;
    Choice ch1,ch2,ch3,ch4;

    AddFeeDetails()
    {
        f=new JFrame("Add Student Fee Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        id=new JLabel();
        id.setBounds(0,0,840,600);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/Fee Details.jpg"));
        Image i1=img.getImage().getScaledInstance(840,600,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);

        id1=new JLabel("Add Student Fee Details");
        id1.setBounds(230,230,500,50);
        id1.setFont(new Font("Airal",Font.BOLD,30));
        id1.setForeground(new Color(84, 2, 224));
        id.add(id1);
        f.add(id);

        id2=new JLabel("Class Name");
        id2.setBounds(50,300,150,30);
        id2.setFont(new Font("Arial",Font.BOLD,20));
        id2.setForeground(new Color(59, 25, 117));
        id.add(id2);

        ch1=new Choice();
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String query="select distinct class from student";
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                ch1.add(rest.getString("class"));
            }
            rest.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ch1.setBounds(200,300,150,30);
        ch1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch1);

        id3 = new JLabel("Section");
        id3.setBounds(450,300,100,30);
        id3.setFont(new Font("Airal",Font.BOLD,20));
        id3.setForeground(new Color(59, 25, 117));
        id.add(id3);

        ch2=new Choice();

        ch1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                ch2.removeAll();
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String class_name=ch1.getSelectedItem();
                    String q1="select * from student where class='"+class_name+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next())
                    {
                        ch2.add(rest1.getString("section"));
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });

        ch2.setBounds(600,300,150,30);
        ch2.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch2);

        id4= new JLabel("Username");
        id4.setBounds(50,350,100,30);
        id4.setFont(new Font("Airal",Font.BOLD,20));
        id4.setForeground(new Color(59, 25, 117));
        id.add(id4);

        ch3=new Choice();

        ch2.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                ch3.removeAll();
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String class_name=ch1.getSelectedItem();
                    String section=ch2.getSelectedItem();
                    String q1="select * from student where class='"+class_name+"' and section='"+section+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next())
                    {
                        ch3.add(rest1.getString("username"));
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });

        ch3.setBounds(200,350,150,30);
        ch3.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch3);

        id5= new JLabel("Student Name");
        id5.setBounds(450,350,200,30);
        id5.setFont(new Font("Airal",Font.BOLD,20));
        id5.setForeground(new Color(59, 25, 117));
        id.add(id5);

        t1=new JTextField();
        t1.setBounds(600,350,150,30);
        t1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t1);
        t1.setEditable(false);

        id6= new JLabel("Email");
        id6.setBounds(50,400,140,30);
        id6.setFont(new Font("Airal",Font.BOLD,20));
        id6.setForeground(new Color(59, 25, 117));
        id.add(id6);

        t2=new JTextField();
        t2.setEditable(false);

        ch3.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String class_name=ch1.getSelectedItem();
                    String section=ch2.getSelectedItem();
                    String username=ch3.getSelectedItem();
                    String q1="select * from student where class='"+class_name+"' and section='"+section+"' and username='"+username+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next())
                    {
                        t1.setText(rest1.getString("name"));
                        t2.setText(rest1.getString("email"));
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });

        t2.setBounds(200,400,150,30);
        t2.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t2);

        id7= new JLabel("Total Fee");
        id7.setBounds(450,400,100,30);
        id7.setFont(new Font("Airal",Font.BOLD,20));
        id7.setForeground(new Color(59, 25, 117));
        id.add(id7);

        t3=new JTextField();
        t3.setEditable(false);

        ch1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String class_name=ch1.getSelectedItem();
                    String q1="select * from fee_structure where class_name='"+class_name+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    if(rest1.next())
                    {
                        t3.setText(rest1.getString("fee_rs"));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Fee Details did not added for this class "+class_name);
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });

        t3.setBounds(600,400,150,30);
        t3.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t3);

        id8= new JLabel("Submit Fee");
        id8.setBounds(50,450,120,30);
        id8.setFont(new Font("Airal",Font.BOLD,20));
        id8.setForeground(new Color(59, 25, 117));
        id.add(id8);

        t4=new JTextField();
        t4.setBounds(200,450,150,30);
        t4.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t4);

        id9= new JLabel("Fee Status");
        id9.setBounds(450,450,150,30);
        id9.setFont(new Font("Arial",Font.BOLD,20));
        id9.setForeground(new Color(59, 25, 117));
        id.add(id9);

        ch4=new Choice();
        ch4.add("Due");
        ch4.add("Complete");
        ch4.setBounds(600,450,150,30);
        ch4.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch4);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,500,150,40);

        id.add(b);

        b1=new JButton("Back");
        b1.setBackground(new Color(88,245,174));
        b1.setForeground(Color.BLACK);
        b1.setBounds(450,500,150,40);

        id.add(b1);

        b.addActionListener(this);
        b1.addActionListener(this);

        f.setVisible(true);
        f.setSize(840,600);
        f.setLocation(300,100);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            String class_name=ch1.getSelectedItem();
            String section=ch2.getSelectedItem();
            String username=ch3.getSelectedItem();
            String name=t1.getText();
            String email=t2.getText();
            String total_fee=t3.getText();
            String submit_fee=t4.getText();
            String status=ch4.getSelectedItem();
            Random r = new Random();
            String fee_id=""+Math.abs(r.nextInt() % 100000);
            Date date = new Date();

            if(submit_fee.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Fee should not be empty!");
            }
            else if(Integer.parseInt(submit_fee)>Integer.parseInt(total_fee))
            {
                JOptionPane.showMessageDialog(null,"Fee should not be grater "+total_fee);
            }
            else if((Integer.parseInt(submit_fee)==Integer.parseInt(total_fee)) && status=="Due")
            {
                JOptionPane.showMessageDialog(null,"If Fee is equal then Status should be Complete!");
            }
            else
            {
                try
                {
                    ConnectionClass obj3=new ConnectionClass();
                    String q = "insert into student_fee values('"+fee_id+"','"+class_name+"','"+section+"','"+username+"','"+name+"','"+email+"','"+total_fee+"','"+submit_fee+"','"+status+"','"+date+"')";
                    obj3.stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                    this.setVisible(false);
                }
                catch(Exception ee)
                {
                    ee.printStackTrace();
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
        new AddFeeDetails().setVisible(true);
    }
}
