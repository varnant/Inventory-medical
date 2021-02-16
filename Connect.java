// connect to database..

import java.sql.*;

class Connect
{
 public static Connection getConnection() throws Exception
 {
  // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   return DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
//DriverManager.getConnection("jdbc:odbc:DRIVER=Microsoft Access Driver (*.mdb);DBQ=MediDB.mdb;");
 }
}
