import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "password");
        Statement statement = con.createStatement();

        //TASK-1. Update pass_grade to 479 of Mathematics department
        //normal string query
        //String query1 = "UPDATE departments SET pass_grade = 479 WHERE department = 'Mathematics'";
        //int updatedRows = statement.executeUpdate(query1);
        //System.out.println("updatedRows: "+updatedRows);

        System.out.println("************** Task-1 **************");
        //TASK-1. Update pass_grade to 475 of Mathematics department (use PreparedStatement)
        String query2 = "UPDATE departments SET pass_grade = ? WHERE department = ?";
        PreparedStatement prs1 = con.prepareStatement(query2);
        prs1.setInt(1, 475);
        prs1.setString(2, "Mathematics");
        int numOfUpdatedRows = prs1.executeUpdate();
        System.out.println("numOfUpdatedRows: "+numOfUpdatedRows);


        System.out.println("************** Task-2 **************");
        //TASK-2. Update pass_grade to 458 of Literature department (use PreparedStatement)
        String query3 ="UPDATE department SET pass_grade = ? WHERE department = ?";
        prs1.setInt(1, 458);
        prs1.setString(2, "Literature");
        int numOfUpdatedRows1 = prs1.executeUpdate();
        System.out.println("numOfUpdatedRows: "+numOfUpdatedRows1);


        prs1.close();
        statement.close();
        con.close();
    }
}