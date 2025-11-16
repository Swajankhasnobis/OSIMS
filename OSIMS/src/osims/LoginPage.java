package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener
{
    JPanel panel;
    JFrame f;
    JLabel l1,l2,l3,l4,l5;
    JTextField t1;
    JPasswordField pf1;
    JButton b1,b2;
    Choice ch1;

    LoginPage()
    {
        f=new JFrame("myAkademix Login");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,750,450);
        l1.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/login.jpeg"));
        Image i1=img.getImage().getScaledInstance(750,450,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);

        l2=new JLabel("Welcome to MyAkademix");
        l2.setBounds(300,132,500,50);
        l2.setFont(new Font("Airal",Font.BOLD,30));
        l2.setForeground(new Color(53,4,117));
        l1.add(l2);
        f.add(l1);

        l3=new JLabel("Username : ");
        l3.setBounds(280,245,150,30);
        l3.setForeground(new Color(53,4,117));
        l3.setFont(new Font("Arial",Font.BOLD,20));
        l1.add(l3);

        t1=new JTextField();
        t1.setBounds(480,245,150,30);
        t1.setFont(new Font("Airal",Font.BOLD,15));
        l1.add(t1);

        l4 = new JLabel("Password : ");
        l4.setBounds(280,295,150,30);
        l4.setForeground(new Color(53,4,117));
        l4.setFont(new Font("Airal",Font.BOLD,20));
        l1.add(l4);

        pf1 = new JPasswordField();
        pf1.setBounds(480,295,150,30);
        pf1.setFont(new Font("Airal",Font.BOLD,15));
        l1.add(pf1);

        l5 = new JLabel("Account    : ");
        l5.setBounds(280,200,150,30);
        l5.setForeground(new Color(53,4,117));
        l5.setFont(new Font("Airal",Font.BOLD,20));
        l1.add(l5);

        ch1=new Choice();
        ch1.add("Admin");
        ch1.add("Faculty");
        ch1.add("User");
        ch1.setBounds(480,200,150,30);
        ch1.setFont(new Font("Airal",Font.BOLD,15));
        l1.add(ch1);

        b1 = new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(280,350,150,40);
        b1.setFont(new Font("Airal",Font.BOLD,15));

        l1.add(b1);

        b2=new JButton("Back");
        b2.setBackground(new Color(147,209,255));
        b2.setForeground(Color.BLACK);
        b2.setBounds(480,350,150,40);
        b2.setFont(new Font("Airal",Font.BOLD,15));

        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.setVisible(true);
        f.setSize(750,460);
        f.setLocation(300,100);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == b1)
        {
            String account=ch1.getSelectedItem();
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String name=t1.getText();
                String pass=pf1.getText();
                if(account.equals("Admin"))
                {
                    String q="select * from admin where username='"+name+"' and password='"+pass+"'";
                    ResultSet rs=obj.stm.executeQuery(q);

                    if(rs.next())
                    {
                        new AdminHomePage(account).setVisible(true);
                        //f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }
                else if(account.equals("Faculty"))
                {
                    String q="select * from teacher where username='"+name+"' and password='"+pass+"'";
                    ResultSet rs=obj.stm.executeQuery(q);

                    if(rs.next())
                    {
                        new TeacherHomePage(rs.getString("tid"),rs.getString("username"),account).setVisible(true);
                        //f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }
                else if(account.equals("User"))
                {
                    String q="select * from student where username='"+name+"' and password='"+pass+"'";
                    ResultSet rs=obj.stm.executeQuery(q);

                    if(rs.next())
                    {
                        new StudentHomePage(rs.getString("stu_id"),rs.getString("username"),account,rs.getString("class"),rs.getString("section")).setVisible(true);
                        f.setVisible(false);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password !");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==b2)
        {
//            new Signup_User();
            //f.setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args)
    {
        new LoginPage();
    }
}

