package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddMarksDetails extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
    Font f,f1;
    Choice ch1,ch2,ch3,ch4,ch5;
    String query,query2;

    AddMarksDetails()
    {
        super("Add Marks Details");
        setLocation(50,10);
        setSize(700,480);
        setResizable(false);

        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,18);

        ch1=new Choice();
        ch4=new Choice();

        try
        {
            ConnectionClass obj=new ConnectionClass();
            query="select distinct class from student";
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

        try
        {
            ConnectionClass obj=new ConnectionClass();
            query2="select * from subject";
            ResultSet rest2=obj.stm.executeQuery(query2);
            while(rest2.next())
            {
                ch4.add(rest2.getString("subject_name"));
            }
            rest2.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        l1=new JLabel("Add Marks Details");
        l2=new JLabel("Class Name");
        l3=new JLabel("Section");
        l4=new JLabel("Student Username");
        l5=new JLabel("Student Name");
        l6=new JLabel("Subject");
        l7=new JLabel("Marks");
        l8=new JLabel("Term");

        ch2=new Choice();
        ch3=new Choice();
        tf1=new JTextField();
        ch5=new Choice();
        tf2=new JTextField();

        ch5.add("CA1");
        ch5.add("CA2");
        ch5.add("CA3");
        ch5.add("CA4");

        bt1=new JButton("Add Marks");
        bt2=new JButton("Back");

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(new java.awt.Color(176, 4, 21));

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);

        ch1.setFont(f1);
        ch2.setFont(f1);
        ch3.setFont(f1);
        ch4.setFont(f1);
        ch5.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);

        bt1.setFont(f1);
        bt2.setFont(f1);

        l2.setForeground(new java.awt.Color(20, 2, 117));
        l3.setForeground(new java.awt.Color(20, 2, 117));
        l4.setForeground(new java.awt.Color(20, 2, 117));
        l5.setForeground(new java.awt.Color(20, 2, 117));
        l6.setForeground(new java.awt.Color(20, 2, 117));
        l7.setForeground(new java.awt.Color(20, 2, 117));
        l8.setForeground(new java.awt.Color(20, 2, 117));

        bt1.setBackground(new java.awt.Color(176, 4, 21));
        bt2.setBackground(Color.BLACK);

        bt1.setForeground(Color.WHITE);
        bt2.setForeground(new java.awt.Color(230, 225, 225));

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(8,2,10,10));

        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(ch2);
        p2.add(l4);
        p2.add(ch3);
        p2.add(l5);
        p2.add(tf1);
        p2.add(l6);
        p2.add(ch4);
        p2.add(l7);
        p2.add(tf2);
        p2.add(l8);
        p2.add(ch5);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

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
                        tf1.setText(rest1.getString("name"));
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String class_name=ch1.getSelectedItem();
            String section=ch2.getSelectedItem();
            String username=ch3.getSelectedItem();
            String name=tf1.getText();
            String subject=ch4.getSelectedItem();
            String marks=tf2.getText();
            String term=ch5.getSelectedItem();
            Random r = new Random();
            String exam_id=""+Math.abs(r.nextInt() % 100000);

            if(marks.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Marks should not be empty!");
            }
            else if(Integer.parseInt(marks)>500)
            {
                JOptionPane.showMessageDialog(null,"Marks should not be grater 500");
            }
            else
            {
                try
                {
                    ConnectionClass obj3=new ConnectionClass();
                    String q = "insert into marks values('"+exam_id+"','"+class_name+"','"+section+"','"+username+"','"+name+"','"+subject+"','"+marks+"','"+term+"')";
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
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new AddMarksDetails().setVisible(true);
    }
}
