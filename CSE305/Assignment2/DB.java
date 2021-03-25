// Min Hang Lee CSE305_Assignment_1, minhang.lee@stonybrook.edu
import java.sql.*;

public class DB {

    // Load the database driver once
    static {
        try {
            System.out.println("About to load the driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe) {
            throw new RuntimeException(cnfe);
        }
    }

    // Creates connections to the database.
  
    public static Connection openConnection () throws SQLException {

        System.out.println("About to connect ...");

        return


            DriverManager.getConnection("jdbc:mysql://localhost:8889/ps2db?serverTimezone=Asia/Seoul", //database named bank with timezone
                                        "grader",    // username
                                        "allowme");   // password
    }   
}