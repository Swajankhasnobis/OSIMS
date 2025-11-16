package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStudentDetails extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
    Font f,f1;
    Choice ch1;
    String query;

    UpdateStudentDetails(String stu_id, String account)
    {
        super("Update Student Details");
        setLocation(50,10);
        setSize(760,720);
        setResizable(false);

        f=new Font("Arial",Font.BOLD,25);
        f1=new Font("Arial",Font.BOLD,18);

        ch1=new Choice();

        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(account.equalsIgnoreCase("admin") || account.equalsIgnoreCase("Faculty"))
            {
                query="select username from Student";
            }
            else if(account.equalsIgnoreCase("User"))
            {
                query="select username from student where stu_id='"+stu_id+"'";
            }
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                ch1.add(rest.getString("username"));
            }
            rest.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        l1=new JLabel("Update Student Details");
        l2=new JLabel("Username");
        l3=new JLabel("Name");
        l4=new JLabel("Email");
        l5=new JLabel("Father Name");
        l6=new JLabel("Phone");
        l7=new JLabel("Class");
        l8=new JLabel("Section");
        l9=new JLabel("Gender");
        l10=new JLabel("Blood");
        l11=new JLabel("Age");
        l13=new JLabel("Dob");
        l14=new JLabel("City");
        l15=new JLabel("Roll No");

        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();
        tf7=new JTextField();
        tf8=new JTextField();
        tf9=new JTextField();
        tf10=new JTextField();
        tf11=new JTextField();
        tf12=new JTextField();

        bt1=new JButton("Update Student");
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
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l13.setFont(f1);
        l14.setFont(f1);
        l15.setFont(f1);
        ch1.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        tf9.setFont(f1);
        tf10.setFont(f1);
        tf11.setFont(f1);
        tf12.setFont(f1);

        //tf5.setEditable(false);
        //tf6.setEditable(false);
        tf12.setEditable(false);

        bt1.setFont(f1);
        bt2.setFont(f1);

        l2.setForeground(new java.awt.Color(20, 2, 117));
        l3.setForeground(new java.awt.Color(20, 2, 117));
        l4.setForeground(new java.awt.Color(20, 2, 117));
        l5.setForeground(new java.awt.Color(20, 2, 117));
        l6.setForeground(new java.awt.Color(20, 2, 117));
        l7.setForeground(new java.awt.Color(20, 2, 117));
        l8.setForeground(new java.awt.Color(20, 2, 117));
        l9.setForeground(new java.awt.Color(20, 2, 117));
        l10.setForeground(new java.awt.Color(20, 2, 117));
        l11.setForeground(new java.awt.Color(20, 2, 117));
        l13.setForeground(new java.awt.Color(20, 2, 117));
        l14.setForeground(new java.awt.Color(20, 2, 117));
        l15.setForeground(new java.awt.Color(20, 2, 117));

        bt1.setBackground(new java.awt.Color(176, 4, 21));
        bt2.setBackground(Color.BLACK);

        bt1.setForeground(Color.WHITE);
        bt2.setForeground(new java.awt.Color(230, 225, 225));

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(14,2,10,10));

        p2.add(l2);
        p2.add(ch1);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l15);
        p2.add(tf12);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(tf7);
        p2.add(l10);
        p2.add(tf8);
        p2.add(l11);
        p2.add(tf9);
        p2.add(l13);
        p2.add(tf10);
        p2.add(l14);
        p2.add(tf11);
        p2.add(bt1);
        p2.add(bt2);

        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/teacher update.png"));
        Image img1=img.getImage().getScaledInstance(230,520,Image.SCALE_SMOOTH);
        ImageIcon ic1=new ImageIcon(img1);
        l12 = new JLabel(ic1);
        p3.add(l12);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");

        ch1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj=new ConnectionClass();
                    String username=ch1.getSelectedItem();
                    String q1="select * from Student where username='"+username+"'";
                    ResultSet rest1=obj.stm.executeQuery(q1);
                    while(rest1.next())
                    {
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("email"));
                        tf3.setText(rest1.getString("father_name"));
                        tf4.setText(rest1.getString("phone"));
                        tf5.setText(rest1.getString("class"));
                        tf6.setText(rest1.getString("section"));
                        tf7.setText(rest1.getString("gender"));
                        tf8.setText(rest1.getString("blood"));
                        tf9.setText(rest1.getString("age"));
                        tf10.setText(rest1.getString("dob"));
                        tf11.setText(rest1.getString("city"));
                        tf12.setText(rest1.getString("roll_no"));
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt1)
        {
            String username=ch1.getSelectedItem();
            String name=tf1.getText();
            String email=tf2.getText();
            String fname=tf3.getText();
            String phone=tf4.getText();
            String class_name=tf5.getText();
            String section=tf6.getText();
            String gender=tf7.getText();
            String blood=tf8.getText();
            String age=tf9.getText();
            String dob=tf10.getText();
            String city=tf11.getText();
            String roll_no=tf12.getText();

            try
            {
                ConnectionClass obj3=new ConnectionClass();
                String q1="update student set name='"+name+"', email='"+email+"', father_name='"+fname+"', phone='"+phone+"', gender='"+gender+"', blood='"+blood+"', age='"+age+"', dob='"+dob+"', city='"+city+"', roll_no='"+roll_no+"' where username='"+username+"'";
                int aa=obj3.stm.executeUpdate(q1);
                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null, "Student details successfully Updated");
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
   /*public static void main(String[] args)
    {
        new UpdateStudentDetails("65194","admin").setVisible(true);
    }*/
}
