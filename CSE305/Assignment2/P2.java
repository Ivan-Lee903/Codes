// Min Hang Lee CSE305_Assignment_1, minhang.lee@stonybrook.edu
import java.sql.*;
import java.util.*;

public class P2 {
    
    public static void main(String[] args){
        try {
            // Get a connection
            Connection conn = DB.openConnection();
            System.out.println("Connection Successful");
            
            // Create Statement
            Statement statement = conn.createStatement();

            // Show Course Log
            String query = "SELECT csem FROM Courses WHERE cid = 3";
            ResultSet results = statement.executeQuery(query);
            results.next();
            String csem = results.getString("csem");
            System.out.println("CSE215 is offered in : " + csem);

            //Prompt
            System.out.print("Enter a new semester this course to be open : ");
            Scanner sc = new Scanner(System.in);
            String newCsem = sc.next();

            //Update
            query = "UPDATE Courses Set csem=? WHERE cid = 3";
            PreparedStatement pstatement = conn.prepareStatement(query);
            pstatement.setString(1, newCsem);
            pstatement.executeUpdate();

            //Show
            query = "SELECT csem FROM Courses WHERE cid = 3";
            results = statement.executeQuery(query);
            results.next();
            csem = results.getString("csem");
            System.out.println("CSE215 is now offered in : " + csem);
            sc.close();
            conn.close();
        }

        catch(Exception e) {
            System.out.println("Handling exception: " + e);
        }
    }
}

