package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class AddStudentDetails extends JFrame implements ActionListener
{
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14,id15;
    JFrame f;
    JTextField t1,t2,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JPasswordField t3;
    JButton b,b1;
    Choice ch1,ch2;

    AddStudentDetails()
    {
        f=new JFrame("Add New Student Details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        id=new JLabel();
        id.setBounds(0,0,840,600);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("osims/icon/student.jpg"));
        Image i1=img.getImage().getScaledInstance(840,600,Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);

        id1=new JLabel("Add Student Details");
        id1.setBounds(230,50,500,50);
        id1.setFont(new Font("Airal",Font.BOLD,30));
        id1.setForeground(new Color(84, 2, 224));
        id.add(id1);
        f.add(id);

        id2=new JLabel("Name");
        id2.setBounds(50,150,150,30);
        id2.setFont(new Font("Arial",Font.BOLD,20));
        id2.setForeground(new Color(59, 25, 117));
        id.add(id2);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        t1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t1);

        id3 = new JLabel("Username");
        id3.setBounds(450,150,200,30);
        id3.setFont(new Font("Airal",Font.BOLD,20));
        id3.setForeground(new Color(59, 25, 117));
        id.add(id3);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        t2.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t2);

        id4= new JLabel("Password");
        id4.setBounds(50,200,100,30);
        id4.setFont(new Font("Airal",Font.BOLD,20));
        id4.setForeground(new Color(59, 25, 117));
        id.add(id4);

        t3=new JPasswordField();
        t3.setBounds(200,200,150,30);
        t3.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t3);

        id5= new JLabel("Email");
        id5.setBounds(450,200,200,30);
        id5.setFont(new Font("Airal",Font.BOLD,20));
        id5.setForeground(new Color(59, 25, 117));
        id.add(id5);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        t4.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t4);

        id6= new JLabel("Father Name");
        id6.setBounds(50,250,140,30);
        id6.setFont(new Font("Airal",Font.BOLD,20));
        id6.setForeground(new Color(59, 25, 117));
        id.add(id6);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        t5.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t5);

        id7= new JLabel("Phone");
        id7.setBounds(450,250,100,30);
        id7.setFont(new Font("Airal",Font.BOLD,20));
        id7.setForeground(new Color(59, 25, 117));
        id.add(id7);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        t6.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t6);

        id8= new JLabel("Class");
        id8.setBounds(50,300,70,30);
        id8.setFont(new Font("Airal",Font.BOLD,20));
        id8.setForeground(new Color(59, 25, 117));
        id.add(id8);

        ch1=new Choice();
        ch1.setBounds(200,300,150,30);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String query="Select distinct class_name from class";
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                ch1.add(rest.getString("class_name"));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        ch1.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch1);
       // t7=new JTextField();
        //t7.setBounds(200,300,150,30);
        //id.add(t7);

        id9= new JLabel("Section");
        id9.setBounds(450,300,100,30);
        id9.setFont(new Font("Arial",Font.BOLD,20));
        id9.setForeground(new Color(59, 25, 117));
        id.add(id9);

        ch2=new Choice();
        ch2.setBounds(600,300,150,30);
        ch2.setFont(new Font("Airal",Font.BOLD,20));
        id.add(ch2);

//        t8=new JTextField();
//        t8.setBounds(600,300,150,30);
//        id.add(t8);

        id10= new JLabel("Gender");
        id10.setBounds(50,350,100,30);
        id10.setFont(new Font("Arial",Font.BOLD,20));
        id10.setForeground(new Color(59, 25, 117));
        id.add(id10);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        t9.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t9);

        id11= new JLabel("Blood Group");
        id11.setBounds(450,350,140,30);
        id11.setFont(new Font("Arial",Font.BOLD,20));
        id11.setForeground(new Color(59, 25, 117));
        id.add(id11);

        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        t10.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t10);

        id12= new JLabel("Age");
        id12.setBounds(450,400,100,30);
        id12.setFont(new Font("Arial",Font.BOLD,20));
        id12.setForeground(new Color(59, 25, 117));
        id.add(id12);

        t11=new JTextField();
        t11.setBounds(600,400,150,30);
        t11.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t11);

        id13= new JLabel("Date of Birth");
        id13.setBounds(450,450,150,30);
        id13.setFont(new Font("Arial",Font.BOLD,20));
        id13.setForeground(new Color(59, 25, 117));
        id.add(id13);

        t12=new JTextField();
        t12.setBounds(600,450,150,30);
        t12.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t12);

        id14= new JLabel("City");
        id14.setBounds(50,400,250,30);
        id14.setFont(new Font("Arial",Font.BOLD,20));
        id14.setForeground(new Color(59, 25, 117));
        id.add(id14);

        t13=new JTextField();
        t13.setBounds(200,400,150,30);
        t13.setFont(new Font("Airal",Font.BOLD,20));
        id.add(t13);

        id15= new JLabel("Roll No");
        id15.setBounds(50,450,140,30);
        id15.setFont(new Font("Arial",Font.BOLD,20));
        id15.setForeground(new Color(59, 25, 117));
        id.add(id15);

        t14=new JTextField();
        t14.setBounds(200,450,150,30);
        t14.setFont(new Font("Airal",Font.BOLD,20));
        t14.setEditable(false);
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

        // replace existing ch1.addMouseListener(...) block with this:
        ch1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    ch2.removeAll();
                    try {
                        ConnectionClass obj = new ConnectionClass();
                        String class_name = ch1.getSelectedItem();
                        String q1 = "select distinct * from class where class_name='" + class_name + "'";
                        ResultSet rest1 = obj.stm.executeQuery(q1);
                        while (rest1.next()) {
                            ch2.add(rest1.getString("section"));
                        }
                        // If ch2 has items, set roll no for the first one immediately
                        if (ch2.getItemCount() > 0) {
                            // compute roll no for the selected class & first section
                            String section = ch2.getItem(0);
                            String q2 = "select enrolled from class where class_name='" + class_name + "' and section='" + section + "'";
                            ResultSet rs2 = obj.stm.executeQuery(q2);
                            if (rs2.next()) {
                                int new_rollno = rs2.getInt("enrolled") + 1;
                                t14.setText(Integer.toString(new_rollno));
                            } else {
                                // default if no enrolled value found
                                t14.setText("1");
                            }
                        } else {
                            t14.setText("");
                        }
                    } catch (Exception exx) {
                        exx.printStackTrace();
                    }
                }
            }
        });

        // replace existing ch2.addMouseListener(...) block with this:
        ch2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if (ie.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        ConnectionClass obj = new ConnectionClass();
                        String class_name = ch1.getSelectedItem();
                        String section = ch2.getSelectedItem();
                        String q1 = "select enrolled from class where class_name='" + class_name + "' and section='" + section + "'";
                        ResultSet rest1 = obj.stm.executeQuery(q1);
                        if (rest1.next()) {
                            int new_rollno = rest1.getInt("enrolled") + 1;
                            t14.setText(Integer.toString(new_rollno));
                        } else {
                            t14.setText("1");
                        }
                    } catch (Exception exx) {
                        exx.printStackTrace();
                    }
                }
            }
        });
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
            String class_name = ch1.getSelectedItem();
            String section = ch2.getSelectedItem();
            String gender = t9.getText();
            String blood = t10.getText();
            int age = Integer.parseInt(t11.getText());
            String dob = t12.getText();
            String city = t13.getText();
            String roll_no = t14.getText();
            Random r = new Random();
            String stu_id=""+Math.abs(r.nextInt() % 100000);
            int total_student=0;
            try
            {
                int newEnrolled = Integer.parseInt(t14.getText());
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into student values('"+stu_id+"','"+roll_no+"','"+name+"','"+username+"','"+password+"','"+email+"','"+father_name+"','"+phone+"','"+class_name+"','"+section+"','"+gender+"','"+blood+"','"+age+"','"+dob+"','"+city+"')";
                String q1="select * from class where class_name='"+class_name+"' and section='"+section+"'";
                String q2="update class set enrolled='"+newEnrolled+"' where class_name='"+class_name+"' and section='"+section+"'";

                ResultSet rest1=obj.stm.executeQuery(q1);
                while(rest1.next())
                {
                    total_student=Integer.parseInt(rest1.getString("strength"));
                }
                if(Integer.parseInt(roll_no)>total_student)
                {
                    JOptionPane.showMessageDialog(null,"Sorry ! This class or section is full.");
                }
                else
                {
                    obj.stm.executeUpdate(q);
                    obj.stm.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                    f.setVisible(false);
                }
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
        new AddStudentDetails().setVisible(true);
    }
}
