package osims;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewMarksDetails extends JFrame
{
    String[] x ={"Id","Class Name","Section","Username","Name","Subject Name","Marks","Tearm"};
    JButton bt;
    String[][] y =new String[20][8];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2,l3,l4;
    JTextField tf1,tf2,tf3;
    JPanel p1,p2,p3;
    Font f,f1;
    String q,query;
    
    ViewMarksDetails(String username, String account)
    {
        super("Marks information");
        setSize(1500,400);
        setLocation(1,1);
        f=new Font("MS UI Gothic",Font.BOLD,15);
        try
        {
            ConnectionClass obj=new ConnectionClass();
            if(account=="User")
            {
                query="Select * from marks where username='"+username+"'";
            }
            else
            {
                query="Select * from marks";
            }
            ResultSet rest=obj.stm.executeQuery(query);
            while(rest.next())
            {  
                y[i][j++]=rest.getString("exam_id");
                y[i][j++]=rest.getString("class_name");
                y[i][j++]=rest.getString("section");
                y[i][j++]=rest.getString("username");
                y[i][j++]=rest.getString("name");  
                y[i][j++]=rest.getString("subject_name"); 
                y[i][j++]=rest.getString("marks"); 
                y[i][j++]=rest.getString("term");
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
//    public static void main(String[] args) 
//    {
//        new ViewMarksDetails().setVisible(true);
//    }
}
