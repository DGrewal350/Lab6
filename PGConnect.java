/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pgconnect;

/**
 *
 * @author Daniel
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PGConnect {

    public static void main(String[] args) {
        try {
            String host = "jdbc:postgresql://localhost:5432/teammembers";
            String uName = "student";
            String uPass = "student";
            Connection con = DriverManager.getConnection(host, uName, uPass);
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM members";
            ResultSet rs = stmt.executeQuery(SQL);
            
            while ( rs.next( ) ) { 
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name"); 
                String last_name = rs.getString("Last_Name"); 
                String job = rs.getString("Job_Title");
                System.out.println( id_col + " " + first_name + " " + last_name + " " + job );  
            }

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
