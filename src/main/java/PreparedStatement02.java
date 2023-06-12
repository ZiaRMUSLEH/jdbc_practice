import java.sql.*;

public class PreparedStatement02 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "password");
        Statement statement = con.createStatement();

        System.out.println("************ TASK-1 **************");
        //TASK-1. Using preparedstatement, delete students who are from Psychology department, from students table.
        String query1 = "DELETE FROM students  WHERE department = ? ";
        PreparedStatement prs = con.prepareStatement(query1);
        prs.setString(1, "Psychology");
        int deletedRows = prs.executeUpdate();
        System.out.println("deletedRows: "+deletedRows);

        System.out.println("************ TASK-2 **************");
        //TASK-2. Insert software Literature department using prepared statement into departments table.
        // (id = 5005, pass_grade=475, campus='South')
        String query2 = "INSERT INTO departments VALUES(?,?,?,?)";
        PreparedStatement prs2 = con.prepareStatement(query2);
        prs2.setInt(1, 5005);
        prs2.setString(2, "Literature");
        prs2.setInt(3,475 );
        prs2.setString(4, "South");
        int rowsInserted = prs2.executeUpdate();
        System.out.println("rowsInserted: " + rowsInserted);



        prs.close();
        prs2.close();
        statement.close();
        con.close();
    }


}
