package osims;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class ViewFeeDetails extends JFrame
{
    String x[]={"Id","Class Name","Section","Username","Name","Email","Total Fee","Submited Fee","Status"};
    JButton bt;
    String y[][]=new String[20][9];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2,l3,l4;
    JTextField tf1,tf2,tf3;
    JPanel p1,p2,p3;
    Font f,f1;
    String q,query;

    ViewFeeDetails(String username,String account)
    {
        super("Fee information");
        setSize(1500,400);
        setLocation(1,1);
        f=new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(account.equalsIgnoreCase("User"))
            {
                query="Select * from student_fee where username='"+username+"'";
            }
            else
            {
                query="Select * from student_fee";
            }
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {
                y[i][j++]=rest.getString("fee_id");
                y[i][j++]=rest.getString("class_name");
                y[i][j++]=rest.getString("section");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("email");
                y[i][j++]=rest.getString("total_fee");
                y[i][j++]=rest.getString("submitted_fee");
                y[i][j++]=rest.getString("status");
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
        add(sp);
    }
}
