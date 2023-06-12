import java.sql.*;

public class Execute01 {
    public static void main (String[] args) throws ClassNotFoundException, SQLException {

        //1. step: Register Driver - (optional)
        Class.forName("org.postgresql.Driver");

        //2. step: Create Connection to get connected to DB
        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db_practice",
                "dev_user_practice","password");

        //3. step: Create Statement -- to execute SQL queries
        Statement statement = con.createStatement();

        // to test if we have created connection to DB
        System.out.println("Connected successfully");

        //4. step: Execute SQL queries
        // TASK: create a table named "employee" with column names of:
        // "employee_id", employee_name", "salary"
        String query1 = "CREATE TABLE employee  ( employee_id INT, employee_name VARCHAR (50), salary REAL)";
        boolean sql1 = statement.execute(query1);
        /*execute() returns boolean value and can be used for DDL (Data Definition Language ) or
        DQL(Data Query Language)
        -- if it is used with DDL it returns false
        -- if it is used with DQL (Select ... ) it returns true
         */
        System.out.println("sql1: "+sql1);

        //TASK 2: add Varchar (20) column name "city" to employee table
        String query2 = "AlTER TABLE employee ADD COLUMN city VARCHAR(20)";
        boolean sql2 = statement.execute(query2);
        System.out.println("sql2: "+sql2);

        //TASK 3: Delete employee table from SCHEMA
        String query3 = "DROP TABLE employee";
        boolean sql3 = statement.execute(query3);
        System.out.println("sql3: "+sql3);

        //5.step: close connection and statement
        statement.close();
        con.close();



    }
}
