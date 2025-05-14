import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args)throws Exception {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","7342823");
        System.out.println("Connection Successfully");
        Statement st=con.createStatement();
        String query="select * from student";
        ResultSet rs=st.executeQuery(query);
        rs.next();
        System.out.println("name: "+rs.getString(1));
        System.out.println("age: "+rs.getInt(2));
        con.close();
        System.out.println("success fully executed");
    }
}
