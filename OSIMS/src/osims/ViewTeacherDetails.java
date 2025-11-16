package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewTeacherDetails extends JFrame implements ActionListener
{
    String x[]={"Name","Username","Email","Father Name","Phone","Qualification","City","gender","Blood Group","Age","DOB","Total Experience","Fav Subject"};
    JButton bt;
    String y[][]=new String[20][13];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q,query;

    ViewTeacherDetails(String account, String username)
    {
        super("Teacher information");
        setSize(1500,400);
        setLocation(1,1);
        f=new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(account.equalsIgnoreCase("admin") || account.equalsIgnoreCase("User"))
            {
                query="Select * from teacher";
            }
            else if(account.equalsIgnoreCase("Faculty"))
            {
                query="Select * from teacher where username='"+username+"'";
            }
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("father_name");
                y[i][j++]=rest.getString("phone");
                y[i][j++]=rest.getString("qualification");
                y[i][j++]=rest.getString("city");
                y[i][j++]=rest.getString("gender");
                y[i][j++]=rest.getString("blood");
                y[i][j++]=rest.getString("age");
                y[i][j++]=rest.getString("dob");
                y[i][j++]=rest.getString("experience");
                y[i][j++]=rest.getString("fav_subject");
                i++;
                j=0;
            }
            t=new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);

        if(account=="Admin")
        {
            f1=new Font("Lucida Fax",Font.BOLD,25);

            l1=new JLabel("Delete any Teacher ?");
            l1.setHorizontalAlignment(JLabel.CENTER);
            l1.setFont(f1);
            l1.setForeground(Color.YELLOW);

            l2=new JLabel("Teacher Username");
            l2.setFont(f1);
            l2.setForeground(Color.GRAY);

            p1=new JPanel();
            p1.setLayout(new GridLayout(1,1,10,10));
            p1.add(l1);

            tf1=new JTextField();

            bt=new JButton("Delete Teacher");
            tf1.setFont(f);
            bt.setFont(f);


            bt.setBackground(Color.BLACK);
            bt.setForeground(Color.RED);
            bt.addActionListener(this);

            p2=new JPanel();
            p2.setLayout(new GridLayout(1,3,10,10));
            p2.add(l2);
            p2.add(tf1);
            p2.add(bt);

            p3=new JPanel();
            p3.setLayout(new GridLayout(2,1,10,10));
            p3.add(p1);
            p3.add(p2);

            p1.setBackground(Color.BLACK);
            p2.setBackground(Color.BLACK);
            p3.setBackground(Color.BLACK);

            add(p3,"South");
        }
        add(sp);
    }
    public void actionPerformed(ActionEvent e)
    {
        String username=tf1.getText();
        if(e.getSource()==bt)
        {
            if(username.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"Please fill the Teacher Username !");
            }
            else
            {
                try
                {
                    ConnectionClass obj1=new ConnectionClass();
                    String q="delete from teacher where username='"+username+"'";
                    int res=obj1.stm.executeUpdate(q);
                    if(res==1)
                    {
                        JOptionPane.showMessageDialog(null,"Teacher record is deleted !");
                        setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Teacher record does not match !");
                    }
                }
                catch(Exception evx)
                {
                    evx.printStackTrace();
                }
            }
        }
    }
//    public static void main(String[] args)
//    {
//        new ViewTeacher("User").setVisible(true);
//    }
}
