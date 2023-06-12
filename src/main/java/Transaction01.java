import java.sql.*;

public class Transaction01 {
    public static void main (String[] args) throws Exception {

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");
        Statement statement = con.createStatement();

        //TASK-1. Transfer amount of 1000 from account_nu:1234 to account_nu:5678

        con.setAutoCommit(false);

        Savepoint sp = null;

        try{

            sp = con.setSavepoint();
            String query = "UPDATE accounts SET amount = amount + ? WHERE account_nu = ?  ";
            PreparedStatement prs1 = con.prepareStatement(query);
            prs1.setInt(2, 1234);
            prs1.setInt(1, -1000);
            prs1.executeUpdate();

            if (false) {throw new Exception();
            }

            prs1.setInt(1, 1000);
            prs1.setInt(2, 5678);
            prs1.executeUpdate();
            con.commit();
            prs1.close();
            statement.close();
            con.close();
        } catch (Exception e){
            con.rollback();
        }




        statement.close();
        con.close();





    }

}
