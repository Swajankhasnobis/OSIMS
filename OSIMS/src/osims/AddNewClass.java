package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddNewClass extends JFrame implements ActionListener
{
    JLabel id,id1,id2,id3,id4,id5;
    JFrame f;
    JTextField t1;
    JButton b,b1;
    Choice ch1,ch2,ch3;

    AddNewClass()
    {
        f=new JFrame("Add New Class Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        id=new JLabel();
        id.setBounds(0,0,840,600);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/class.jpg"));
        Image i1=img.getImage().getScaledInstance(840,600,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);

        id1=new JLabel("Add New Class Details");
        id1.setBounds(420,110,500,50);
        id1.setFont(new Font("Airal",Font.BOLD,30));
        id1.setForeground(new Color(84, 2, 224));
        id.add(id1);
        f.add(id);

        id2=new JLabel("Class Name");
        id2.setBounds(400,200,150,30);
        id2.setFont(new Font("Arial",Font.BOLD,20));
        id2.setForeground(new Color(59, 25, 117));
        id.add(id2);

        ch1=new Choice();
        ch1.add("1");
        ch1.add("2");
        ch1.add("3");
        ch1.add("4");
        ch1.add("5");
        ch1.add("6");
        ch1.add("7");
        ch1.add("8");
        ch1.add("9");
        ch1.add("10");
        ch1.add("11");
        ch1.add("12");

        ch1.setBounds(600,200,150,30);
        ch1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch1);

        id3 = new JLabel("Section");
        id3.setBounds(400,250,200,30);
        id3.setFont(new Font("Airal",Font.BOLD,20));
        id3.setForeground(new Color(59, 25, 117));
        id.add(id3);

        ch2=new Choice();
        ch2.add("A");
        ch2.add("B");
        ch2.add("C");
        ch2.setBounds(600,250,150,30);
        ch2.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch2);

        id4= new JLabel("Student Strength");
        id4.setBounds(400,300,200,30);
        id4.setFont(new Font("Airal",Font.BOLD,20));
        id4.setForeground(new Color(59, 25, 117));
        id.add(id4);

        ch3=new Choice();
        ch3.add("25");
        ch3.add("35");
        ch3.add("40");
        ch3.setBounds(600,300,150,30);
        ch3.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch3);

        id5= new JLabel("Enrolled Student");
        id5.setBounds(400,350,200,30);
        id5.setFont(new Font("Airal",Font.BOLD,20));
        id5.setForeground(new Color(59, 25, 117));
        id.add(id5);

        t1=new JTextField();
        t1.setText("0");
        t1.setEditable(false);
        t1.setBounds(600,350,150,30);
        t1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t1);

        b = new JButton("Add Class");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(400,400,150,40);

        id.add(b);

        b1=new JButton("Back");
        b1.setBackground(new Color(88,245,174));
        b1.setForeground(Color.BLACK);
        b1.setBounds(600,400,150,40);

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
            String classname=ch1.getSelectedItem();
            String section = ch2.getSelectedItem();
            String student_strength = ch3.getSelectedItem();
            String enrolled_student = t1.getText();
            Random r = new Random();
            String class_id=""+Math.abs(r.nextInt() % 100000);

            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into class values('"+class_id+"','"+classname+"','"+section+"','"+student_strength+"','"+enrolled_student+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
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
        new AddNewClass().setVisible(true);
    }
}
