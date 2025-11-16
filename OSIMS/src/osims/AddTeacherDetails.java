package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddTeacherDetails extends JFrame implements ActionListener
{
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14,id15;
    JFrame f;
    JTextField t1,t2,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JPasswordField t3;
    JButton b,b1;

    AddTeacherDetails()
    {
        f=new JFrame("Add New Teacher Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        id=new JLabel();
        id.setBounds(0,0,840,600);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/teacher.jpg"));
        Image i1=img.getImage().getScaledInstance(840,600,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);

        id1=new JLabel("Add Teacher Details for Signup");
        id1.setBounds(230,50,500,50);
        id1.setFont(new Font("Airal",Font.BOLD,30));
        id1.setForeground(new Color(8,161,92));
        id.add(id1);
        f.add(id);

        id2=new JLabel("Name");
        id2.setBounds(50,150,150,30);
        id2.setFont(new Font("Arial",Font.BOLD,20));
        id2.setForeground(Color.WHITE);
        id.add(id2);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id.add(t1);

        id3 = new JLabel("Username");
        id3.setBounds(450,150,200,30);
        id3.setFont(new Font("Airal",Font.BOLD,20));
        id3.setForeground(Color.WHITE);
        id.add(id3);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id.add(t2);

        id4= new JLabel("Password");
        id4.setBounds(50,200,100,30);
        id4.setFont(new Font("Airal",Font.BOLD,20));
        id4.setForeground(Color.WHITE);
        id.add(id4);

        t3=new JPasswordField();
        t3.setBounds(200,200,150,30);
        id.add(t3);

        id5= new JLabel("Email");
        id5.setBounds(450,200,200,30);
        id5.setFont(new Font("Airal",Font.BOLD,20));
        id5.setForeground(Color.WHITE);
        id.add(id5);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id.add(t4);

        id6= new JLabel("Father Name");
        id6.setBounds(50,250,140,30);
        id6.setFont(new Font("Airal",Font.BOLD,20));
        id6.setForeground(Color.WHITE);
        id.add(id6);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id.add(t5);

        id7= new JLabel("Phone");
        id7.setBounds(450,250,100,30);
        id7.setFont(new Font("Airal",Font.BOLD,20));
        id7.setForeground(Color.WHITE);
        id.add(id7);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id.add(t6);

        id8= new JLabel("Qualification");
        id8.setBounds(50,300,160,30);
        id8.setFont(new Font("Airal",Font.BOLD,20));
        id8.setForeground(Color.WHITE);
        id.add(id8);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id.add(t7);

        id9= new JLabel("City");
        id9.setBounds(450,300,100,30);
        id9.setFont(new Font("Arial",Font.BOLD,20));
        id9.setForeground(Color.WHITE);
        id.add(id9);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id.add(t8);

        id10= new JLabel("Gender");
        id10.setBounds(50,350,100,30);
        id10.setFont(new Font("Arial",Font.BOLD,20));
        id10.setForeground(Color.WHITE);
        id.add(id10);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id.add(t9);

        id11= new JLabel("Blood Group");
        id11.setBounds(450,350,140,30);
        id11.setFont(new Font("Arial",Font.BOLD,20));
        id11.setForeground(Color.WHITE);
        id.add(id11);

        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        id.add(t10);

        id12= new JLabel("Age");
        id12.setBounds(450,400,100,30);
        id12.setFont(new Font("Arial",Font.BOLD,20));
        id12.setForeground(Color.WHITE);
        id.add(id12);

        t11=new JTextField();
        t11.setBounds(600,400,150,30);
        id.add(t11);

        id13= new JLabel("Date of Birth");
        id13.setBounds(450,450,150,30);
        id13.setFont(new Font("Arial",Font.BOLD,20));
        id13.setForeground(Color.WHITE);
        id.add(id13);

        t12=new JTextField();
        t12.setBounds(600,450,150,30);
        id.add(t12);

        id14= new JLabel("Teaching Exp.");
        id14.setBounds(50,400,250,30);
        id14.setFont(new Font("Arial",Font.BOLD,20));
        id14.setForeground(Color.WHITE);
        id.add(id14);

        t13=new JTextField();
        t13.setBounds(200,400,150,30);
        id.add(t13);

        id15= new JLabel("Fav Subject");
        id15.setBounds(50,450,140,30);
        id15.setFont(new Font("Arial",Font.BOLD,20));
        id15.setForeground(Color.WHITE);
        id.add(id15);

        t14=new JTextField();
        t14.setBounds(200,450,150,30);
        id.add(t14);

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
            String name=t1.getText();
            String username = t2.getText();
            String password = t3.getText();
            String email = t4.getText();
            String father_name = t5.getText();
            String phone = t6.getText();
            String qualification = t7.getText();
            String city = t8.getText();
            String gender = t9.getText();
            String blood = t10.getText();
            int age = Integer.parseInt(t11.getText());
            String dob = t12.getText();
            String exp = t13.getText();
            String fav_sub = t14.getText();
            Random r = new Random();
            String tec_id=""+Math.abs(r.nextInt() % 100000);
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into teacher values('"+tec_id+"','"+name+"','"+username+"','"+password+"','"+email+"','"+father_name+"','"+phone+"','"+qualification+"','"+city+"','"+gender+"','"+blood+"','"+age+"','"+dob+"','"+exp+"','"+fav_sub+"')";
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
}
