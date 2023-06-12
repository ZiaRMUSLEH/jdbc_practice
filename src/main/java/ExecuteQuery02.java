import java.sql.*;

public class ExecuteQuery02 {

    public static void main (String[] args) throws SQLException {

        Connection con =DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user","password");

        Statement statement = con.createStatement();

        System.out.println("************** Task-1 *************");
        //Task-1: Print department name and grade of department which has second highest pass_grade
        String query1 = "SELECT department, pass_grade FROM departments ORDER BY pass_grade DESC  OFFSET 1 LIMIT 1  ";
        ResultSet sql1 = statement.executeQuery(query1);
        while (sql1.next()){
            System.out.println(sql1.getString("department")+"-----"+sql1.getInt("pass_grade"));
        }


        System.out.println("************** Task-2 *************");
        //Task-2: Print department name and pass_grade of department which has second highest pass_grade using sub-query
        String query2 = "SELECT department, pass_grade FROM departments WHERE  pass_grade = " +
                " (SELECT MAX(pass_grade) FROM departments WHERE pass_grade < (SELECT MAX(pass_grade) FROM departments)) ";
        ResultSet sql2 = statement.executeQuery(query2);
        while (sql2.next()){
            System.out.println(sql2.getString("department")+"-----"+sql2.getInt("pass_grade"));
        }


        System.out.println("************** Task-3 *************");
        //Task-3: List department name, campus and highest grades of students from every department
        String query3 = "SELECT department, campus ,(SELECT MAX(grade) AS max_grade FROM students s WHERE d.department=s.department )" +
                "FROM  departments d  ";
        ResultSet sql3 = statement.executeQuery(query3);
        while (sql3.next()){
            System.out.println(sql3.getString("department")+"-----"
                    +sql3.getString("campus")+"----"+sql3.getInt("max_grade"));
        }

        statement.close();
        con.close();




    }

}
