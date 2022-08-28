
/**
 * @author Sinalo Ngolozana (217211151)
 */

package za.ac.cput.student_platform;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBConnection {
            public static Connection connect() {
                  try {
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection connect = DriverManager.getConnection("jdbc:derby://localhost:1527/Student","sinalo","sinalo");
                           Statement state = connect.createStatement();
                           ResultSet result = state.executeQuery("select * from emp");
                           
                           while (result.next()) {
                                    JOptionPane.showMessageDialog(null, result.getInt(1) + " " + result.getInt(2) + " " + result.getInt(3)
                                    + " " + result.getInt(4) + " " + result.getInt(5));
                                    connect.close();
                           }
                  }
                  
                  catch (Exception e) {
                           JOptionPane.showMessageDialog(null, e);
                  }
                  return null;
         }
}