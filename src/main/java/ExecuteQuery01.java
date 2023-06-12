import java.sql.*;

public class ExecuteQuery01 {
    public static void main (String[] args) throws SQLException {

        // Create Connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user", "password");

        //Create Statement
        Statement statement = con.createStatement();

        System.out.println("******************** TASK - 1 *********************");
        // TASK-1. GET/SELECT "country_name" from countries table with ID between 5 and 10
        String query1 = "SELECT country_name FROM countries WHERE id BETWEEN 5 AND 10";
        ResultSet sql1 = statement.executeQuery(query1);
        while (sql1.next()){
            System.out.println(sql1.getString("country_name"));
        }

        System.out.println("******************** TASK - 2 *********************");
        //TASK-2: get "phone_code" and "country_name" from countries table whose phone code is greater than 500 .
        String query2 = "SELECT phone_code, country_name FROM countries WHERE phone_code >500";
        ResultSet resultSet = statement.executeQuery(query2);
        while (resultSet.next()){
            System.out.println(resultSet.getInt("phone_code")+ "----"+resultSet.getString("country_name"));
        }

        System.out.println("******************** TASK - 3 *********************");
        //TASK-3: get all information about the developers whose salary is lowest .
        String query3 = "SELECT * FROM developers WHERE salary = (SELECT MIN(salary) FROM developers )";
        ResultSet sql2 = statement.executeQuery(query3);
        while (sql2.next()){
            System.out.println(sql2.getInt("id")+ "----"+sql2.getString("name")
                    + "----"+sql2.getInt("salary")+ "----"+sql2.getString("prog_lang"));
        }

        System.out.println("******************** TASK - 4 *********************");
        //TASK-4: Display students' name and grade whose grades are higher than passing grade of departments.

        String query4 = "SELECT name,grade FROM students WHERE grade >" +
                " (SELECT pass_grade FROM departments WHERE students.department=departments.department) ";
        ResultSet sql3 = statement.executeQuery(query4);
        while (sql3.next()){
            System.out.println(sql3.getString("name") +"----"+sql3.getInt("grade"));
        }

        statement.close();
        con.close();


    }
}
