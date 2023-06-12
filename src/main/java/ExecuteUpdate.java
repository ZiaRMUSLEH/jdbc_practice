import java.sql.*;

public class ExecuteUpdate {
    public static <Ziarahman> void main (String[] args) throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user", "password");
        Statement statement = con.createStatement();


        System.out.println("******************  Task-1  ******************");
        //TASK-1. Update salaries of developers whose salaries are less than average salary with average salary
        //String query1 = "UPDATE developers SET salary = (SELECT AVG(salary)FROM developers) WHERE salary < (SELECT AVG(salary)FROM developers)";
        //int updatedRows1 = statement.executeUpdate(query1);
        //System.out.println("updatedRows: " + updatedRows1);

        // to see all records
        String query = "SELECT name, salary FROM developers";
        ResultSet sql1 = statement.executeQuery(query);
        while (sql1.next()){
            System.out.println(sql1.getString("name")+"----"+sql1.getInt("salary"));
        }

        //System.out.println("******************  Task-2  ******************");
        //TASK-2. Add new developer to developers table
        //String query2 = "INSERT INTO developers VALUES (22,'Ziarahman Musleh',5000,'Java' )";
        //int insertedRows = statement.executeUpdate(query2);
       // System.out.println("insertedRows: " + insertedRows);


        System.out.println("******************  Task-3  ******************");

        //TASK-3. DELETE row which has id of 16
        String query3 = "DELETE FROM developers WHERE id = 16";
        int deletedRows = statement.executeUpdate(query3);
        System.out.println("deletedRows:  "+deletedRows );


        System.out.println("******************  Task-4  ******************");
        //TASK-4. DELETE rows from developers table if  prog_lang is “C#”
        String query4 = "DELETE FROM developers WHERE prog_lang = 'C#'";
        int deletedRows1 = statement.executeUpdate(query4);
        System.out.println("deletedRows: "+deletedRows1);



        statement.close();
        con.close();

    }

}
