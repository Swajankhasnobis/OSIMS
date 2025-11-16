package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateClassDetails extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5;
    JButton bt1,bt2;
    JPanel p1,p2;
    JTextField tf1,tf2;
    Font f,f1;
    Choice ch1,ch2;
    String query;

    UpdateClassDetails()
    {
        super("Update Class Details");
        setLocation(50,10);
        setSize(700,320);
        setResizable(false);

        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,18);

        ch1=new Choice();
        ch2=new Choice();

        try
        {
            ConnectionClass obj=new ConnectionClass();
//            if(role=="admin")
//            {
            query="select distinct class_name from class";
//            }
//            else if(role=="user")
//            {
//                query="select username from teacher where user_id='"+user_id+"'";
//            }
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

        l1=new JLabel("Update Class Details");
        l2=new JLabel("Class Name");
        l3=new JLabel("Section");
        l4=new JLabel("Class Strength");
        l5=new JLabel("Enrolled Student");

        tf1=new JTextField();
        tf2=new JTextField();

        bt1=new JButton("Update Class");
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
        ch1.setFont(f1);
        ch2.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);

        tf2.setEditable(false);

        bt1.setFont(f1);
        bt2.setFont(f1);

        l2.setForeground(new java.awt.Color(20, 2, 117));
        l3.setForeground(new java.awt.Color(20, 2, 117));
        l4.setForeground(new java.awt.Color(20, 2, 117));
        l5.setForeground(new java.awt.Color(20, 2, 117));

        bt1.setBackground(new java.awt.Color(176, 4, 21));
        bt2.setBackground(Color.BLACK);

        bt1.setForeground(Color.WHITE);
        bt2.setForeground(new java.awt.Color(230, 225, 225));

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(5,2,10,10));

        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(ch2);
        p2.add(l4);
        p2.add(tf1);
        p2.add(l5);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);
        p2.setBackground(Color.cyan);

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
                    String q1="select section from class where class_name='"+class_name+"'";
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
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String class_name=ch1.getSelectedItem();
                    String section=ch2.getSelectedItem();
                    String q1="select * from class where class_name='"+class_name+"' and section='"+section+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next())
                    {
                        tf1.setText(rest1.getString("strength"));
                        tf2.setText(rest1.getString("enrolled"));
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
            String student_strength=tf1.getText();
            String enrolled_student=tf2.getText();

            try
            {
                ConnectionClass obj3=new ConnectionClass();
                String q1="update class set strength='"+student_strength+"' where class_name='"+class_name+"' and section='"+section+"'";
                int aa=obj3.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Class details successfully Updated");
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please!, Fill all details carefully");
                }
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }
        if(e.getSource()==bt2)
        {
            this.setVisible(false);
        }
    }
    public static void main(String[] args)
    {
        new UpdateClassDetails().setVisible(true);
    }
}
