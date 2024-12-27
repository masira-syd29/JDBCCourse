import org.postgresql.Driver;

import java.sql.*;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        /*
        * import package
        * load and register
        * create connection
        * execute statement
        * process the results
        * close
        * */
        int sid = 102;
        String sname = "Jasmine";
        int marks = 53;

        String url = "jdbc:postgresql://localhost:5432/project";
        String uname = "postgres";
        String pass = "Msyd@999";
        //String sql = "insert into student values (" + sid + ", '"+sname+"',"+marks+")";
        String sql = "insert into student values(?,?,?)";

        //CRUD OPERATIONS SQL : CREATE, READ, UPDATE, DELETE
        //String sql = "select * from student";
        //String sql = "insert into student values (7, 'Tom', 67)";
        //String sql = "update student set sname='Max' where sid=5";
        //String sql = "delete from student where sid=7";


        //Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("Connection Established!");
//        Statement st = con.createStatement();
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,sid);
        st.setString(2,sname);
        st.setInt(3,marks);
        st.execute();


//        ResultSet rs = st.executeQuery(sql);
//        rs.next();
//        String name = rs.getString("sname");
//        System.out.println("Name of a student is : "+name);
//        while(rs.next()){
//            System.out.print(rs.getInt(1)+"-");
//            System.out.print(rs.getString(2)+"-");
//            System.out.println(rs.getInt(3));
//
//        }


        con.close();
        System.out.println("Connection Closed!");



    }
}