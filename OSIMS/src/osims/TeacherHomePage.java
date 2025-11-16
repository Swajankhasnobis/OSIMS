package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class TeacherHomePage extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Font f,f1,f2;
    JPanel p1;
    public String id,account2,username2;

    TeacherHomePage(String tec_id, String username, String account)
    {
        this.setTitle("Teacher Home Page");
        setLocation(0,0);
        setSize(1280,780);

        id=tec_id;
        account2=account;
        username2=username;

        f=new Font("Lucida Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f1=new Font("MS UI Gothic",Font.BOLD,18);

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("osims/icon/teacher home.jpg"));
        Image img=ic.getImage().getScaledInstance(1280,780,Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);

        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Teacher Profile");
        JMenuItem ment2=new JMenuItem("Update Teacher Profile");
        JMenuItem ment3=new JMenuItem("View Teacher Profile");

        JMenu men2=new JMenu("Student Profile");
        JMenuItem ment5=new JMenuItem("Update Student Details");
        JMenuItem ment6=new JMenuItem("View Student Details");

//        JMenu men3=new JMenu("Class Details");
//        JMenuItem ment7=new JMenuItem("View Class");

//        JMenu men4=new JMenu("Subject Details");
//        JMenuItem ment9=new JMenuItem("View Subjects");
//        JMenuItem ment10=new JMenuItem("Update Subject Details");

//        JMenu men5=new JMenu("Exam Details");
//        JMenuItem ment11=new JMenuItem("Add Exam Details");
//        JMenuItem ment12=new JMenuItem("Update Exam Details");

        JMenu men5=new JMenu("Result");
        JMenuItem ment11=new JMenuItem("Show Result");

        JMenu men6=new JMenu("Marks Details");
        JMenuItem ment13=new JMenuItem("Add Marks Details");
        JMenuItem ment14=new JMenuItem("View Marks Details");

        JMenu men7=new JMenu("Fee Details");
        JMenuItem ment16=new JMenuItem("View Fee Details");

        JMenu men8=new JMenu("Logout");
        JMenuItem ment15=new JMenuItem("Exit");

        men1.add(ment2);
        men1.add(ment3);
        men2.add(ment5);
        men2.add(ment6);
//        men3.add(ment7);
//        men4.add(ment9);
//        men4.add(ment10);
        men5.add(ment11);
//        men5.add(ment12);
        men6.add(ment13);
        men6.add(ment14);
        men7.add(ment16);
        men8.add(ment15);

        m1.add(men1);
        m1.add(men2);
//        m1.add(men3);
//        m1.add(men4);
        m1.add(men6);
        m1.add(men7);
        m1.add(men5);
        m1.add(men8);

        men1.setFont(f);
        men2.setFont(f);
//        men3.setFont(f);
//        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);
        men8.setFont(f);
//
//        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
//        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
//        ment7.setFont(f1);
//        ment8.setFont(f1);
//        ment9.setFont(f1);
//        ment10.setFont(f1);
        ment11.setFont(f1);
//        ment12.setFont(f1);
        ment13.setFont(f1);
        ment14.setFont(f1);
        ment16.setFont(f1);
        ment15.setFont(f1);

        m1.setBackground(new java.awt.Color(4, 1, 54));

        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
//        men3.setForeground(Color.GRAY);
//        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men6.setForeground(Color.GRAY);
        men7.setForeground(Color.GRAY);
        men8.setForeground(Color.RED);

//        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
//        ment4.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
//        ment7.setBackground(Color.BLACK);
//        ment8.setBackground(Color.BLACK);
//        ment9.setBackground(Color.BLACK);
//        ment10.setBackground(Color.BLACK);
        ment11.setBackground(Color.BLACK);
//        ment12.setBackground(Color.BLACK);
        ment13.setBackground(Color.BLACK);
        ment14.setBackground(Color.BLACK);
        ment16.setBackground(Color.BLACK);
        ment15.setBackground(Color.BLACK);

//        ment1.setForeground(new java.awt.Color(204, 102, 39));
        ment2.setForeground(Color.GREEN);
        ment3.setForeground(Color.GREEN);
//        ment4.setForeground(new java.awt.Color(204, 102, 39));
        ment5.setForeground(Color.GREEN);
        ment6.setForeground(Color.GREEN);
//        ment7.setForeground(new java.awt.Color(204, 102, 39));
//        ment8.setForeground(new java.awt.Color(204, 102, 39));
//        ment9.setForeground(new java.awt.Color(204, 102, 39));
//        ment10.setForeground(new java.awt.Color(204, 102, 39));
        ment11.setForeground(new java.awt.Color(204, 102, 39));
//        ment12.setForeground(new java.awt.Color(204, 102, 39));
        ment13.setForeground(Color.GREEN);
        ment14.setForeground(Color.GREEN);
        ment16.setForeground(Color.GREEN);
        ment15.setForeground(Color.RED);

//        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
//        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
//        ment7.addActionListener(this);
//        ment8.addActionListener(this);
//        ment9.addActionListener(this);
//        ment10.addActionListener(this);
        ment11.addActionListener(this);
//        ment12.addActionListener(this);
        ment13.addActionListener(this);
        ment14.addActionListener(this);
        ment16.addActionListener(this);
        ment15.addActionListener(this);

        setJMenuBar(m1);
        add(l1);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String comnd=e.getActionCommand();
        if(comnd.equals("Update Teacher Profile"))
        {
            new UpdateTeacherDetails(id,account2).setVisible(true);
        }
        else if(comnd.equals("View Teacher Profile"))
        {
            new ViewTeacherDetails(account2,username2).setVisible(true);
        }
        else if(comnd.equals("Update Student Details"))
        {
           // new UpdateStudentDetails(id,account2).setVisible(true);
        }
        else if(comnd.equals("View Student Details"))
        {
            //new ViewStudent(account2,"").setVisible(true);
        }
        else if (comnd.equals("Add Marks Details"))
        {
            new AddMarksDetails().setVisible(true);
        }
        else if (comnd.equals("View Marks Details"))
        {
            //new ViewMarksDetails(username2,account2).setVisible(true);
        }
        else if (comnd.equals("View Fee Details"))
        {
           // new ViewFeeDetails(username2,account2).setVisible(true);
        }
        else if (comnd.equals("Show Result"))
        {
            //new ShowResult("",account2,"","").setVisible(true);
        }
        else if (comnd.equals("Exit"))
        {
            this.setVisible(false);
//            System.exit(0);
            new LoginPage();
        }
    }
//    public static void main(String[] args)
//    {
//        new TeacherHomePage().setVisible(true);
//    }
}
