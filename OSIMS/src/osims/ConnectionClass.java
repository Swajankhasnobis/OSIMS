package osims;
import java.sql.*;
public class ConnectionClass {
    Connection conn;
    Statement stm;
    ConnectionClass()
    {
        String url="jdbc:mysql://localhost:3306/Students";
        String uname="root";
        String Pwd="Swajan#18";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection(url,uname,Pwd);
            stm=conn.createStatement();
            if(conn.isClosed()) {
                System.out.println("Yes");
            }
        }catch (Exception e)
        {
            System.out.println("Oops");
        }
    }

    public static void main(String[] args) {
        new ConnectionClass();
    }
}
